package org.module.service.impl.logger.order;

import java.util.List;

import org.module.dto.logger.order.LmOrderStatusDto;
import org.module.helper.commons.LoggerHelper;
import org.module.mapper.logger.order.LmOrderStatusMapper;
import org.module.model.logger.order.LmOrderStatus;
import org.module.result.DataResult;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.logger.order.ILmOrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: LmOrderStatusServiceImpl <br>
 * 描述: 订单状态更新日志业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月21日 上午11:22:38
 */
@Service
public class LmOrderStatusServiceImpl extends BaseServiceImpl<LmOrderStatus, LmOrderStatusMapper, LmOrderStatusDto>
		implements ILmOrderStatusService {

	@Autowired
	private LmOrderStatusMapper mapper;

	/**
	 * 
	 * 方法: selectByOrderCode <br>
	 * 
	 * @param orderCode
	 * @return
	 * @see org.module.service.logger.order.ILmOrderStatusService#selectByOrderCode(java.lang.String)
	 */
	@Override
	public DataResult selectByOrderCode(String orderCode) {
		LoggerHelper.info(this.getClass(), "根据订单编码查询订单状态更新日志");
		DataResult result = new DataResult();
		try {
			List<LmOrderStatus> list = mapper.selectByOrderCode(orderCode);
			if (list != null && list.size() > 0) {
				result.setData(list);
				result.setCode(0);
				result.setMessage("获取订单状态更新日志成功");
			} else {
				result.setCode(-1);
				result.setMessage("获取订单状态更新日志为空");
			}
		} catch (Exception e) {
			result.setCode(-1);
			result.setMessage("获取订单状态更新日志失败，失败原因:" + e.getMessage());
		}
		return result;
	}

}
