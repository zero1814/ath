package org.module.service.impl.logger.event;

import java.util.List;

import org.module.dto.logger.event.LmEventStatusDto;
import org.module.helper.commons.LoggerHelper;
import org.module.mapper.logger.event.LmEventStatusMapper;
import org.module.model.logger.event.LmEventStatus;
import org.module.result.DataResult;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.logger.event.ILmEventStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: LmEventStatusServiceImpl <br>
 * 描述: 活动状态变更日志业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月21日 上午10:43:43
 */
@Service
public class LmEventStatusServiceImpl extends BaseServiceImpl<LmEventStatus, LmEventStatusMapper, LmEventStatusDto>
		implements ILmEventStatusService {
	@Autowired
	private LmEventStatusMapper mapper;

	/**
	 * 
	 * 方法: selectByEventCode <br>
	 * 
	 * @param eventCode
	 * @return
	 * @see org.module.service.logger.event.ILmEventStatusService#selectByEventCode(java.lang.String)
	 */
	@Override
	public DataResult selectByEventCode(String eventCode) {
		LoggerHelper.info(this.getClass(), "根据活动编码查询活动状态变更日志");
		DataResult result = new DataResult();
		try {
			List<LmEventStatus> list = mapper.selectByEventCode(eventCode);
			if (list != null && list.size() > 0) {
				result.setData(list);
				result.setCode(0);
				result.setMessage("获取活动状态变更日志成功");
			} else {
				result.setCode(-1);
				result.setMessage("获取活动状态变更日志为空");
			}
		} catch (Exception e) {
			result.setCode(-1);
			result.setMessage("获取活动状态变更日志失败，失败原因:" + e.getMessage());
		}
		return result;
	}

}
