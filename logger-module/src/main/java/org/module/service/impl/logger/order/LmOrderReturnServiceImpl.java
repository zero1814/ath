package org.module.service.impl.logger.order;

import java.util.List;

import org.module.dto.logger.order.LmOrderReturnDto;
import org.module.helper.commons.LoggerHelper;
import org.module.mapper.logger.order.LmOrderReturnMapper;
import org.module.model.logger.order.LmOrderReturn;
import org.module.result.DataResult;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.logger.order.ILmOrderReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: LmOrderReturnServiceImpl <br>
 * 描述: 退换货日志业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月21日 上午10:57:07
 */
@Service
public class LmOrderReturnServiceImpl extends BaseServiceImpl<LmOrderReturn, LmOrderReturnMapper, LmOrderReturnDto>
		implements ILmOrderReturnService {

	@Autowired
	private LmOrderReturnMapper mapper;

	/**
	 * 
	 * 方法: selectByOrderCode <br>
	 * 
	 * @param orderCode
	 * @return
	 * @see org.module.service.logger.order.ILmOrderReturnService#selectByOrderCode(java.lang.String)
	 */
	@Override
	public DataResult selectByOrderCode(String orderCode) {
		LoggerHelper.info(this.getClass(), "根据订单编码查询退换货日志");
		DataResult result = new DataResult();
		try {
			List<LmOrderReturn> list = mapper.selectByOrderCode(orderCode);
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
