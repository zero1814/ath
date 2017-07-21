package org.module.service.impl.logger.event;

import java.util.List;

import org.module.dto.logger.event.LmEventFlowDto;
import org.module.helper.commons.LoggerHelper;
import org.module.mapper.logger.event.LmEventFlowMapper;
import org.module.model.logger.event.LmEventFlow;
import org.module.result.DataResult;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.logger.event.ILmEventFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: LmEventFlowServiceImpl <br>
 * 描述: 活动审核日志业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月21日 上午10:35:30
 */
@Service
public class LmEventFlowServiceImpl extends BaseServiceImpl<LmEventFlow, LmEventFlowMapper, LmEventFlowDto>
		implements ILmEventFlowService {
	@Autowired
	private LmEventFlowMapper mapper;

	/**
	 * 
	 * 方法: selectByEventCode <br>
	 * 描述: TODO
	 * @param eventCode
	 * @return 
	 * @see org.module.service.logger.event.ILmEventFlowService#selectByEventCode(java.lang.String)
	 */
	@Override
	public DataResult selectByEventCode(String eventCode) {
		LoggerHelper.info(this.getClass(), "根据活动编码查询活动审核日志信息");
		DataResult result = new DataResult();
		try {
			List<LmEventFlow> list = mapper.selectByEventCode(eventCode);
			if (list != null && list.size() > 0) {
				result.setData(list);
				result.setCode(0);
				result.setMessage("获取活动审核日志成功");
			} else {
				result.setCode(-1);
				result.setMessage("获取活动审核日志为空");
			}
		} catch (Exception e) {
			result.setCode(-1);
			result.setMessage("获取活动审核日志失败，失败原因:" + e.getMessage());
		}
		return result;
	}

}
