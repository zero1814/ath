package org.module.service.logger.order;

import org.module.dto.logger.order.LmOrderStatusDto;
import org.module.model.logger.order.LmOrderStatus;
import org.module.result.DataResult;
import org.module.service.IBaseService;

/**
 * 
 * 类: ILmOrderStatusService <br>
 * 描述: 订单状态更新日志业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月21日 上午11:22:11
 */
public interface ILmOrderStatusService extends IBaseService<LmOrderStatus, LmOrderStatusDto> {
	/**
	 * 
	 * 方法: selectByOrderCode <br>
	 * 描述: 根据订单编码查询订单状态更新日志 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月21日 上午10:54:37
	 * 
	 * @param orderCode
	 * @return
	 */
	DataResult selectByOrderCode(String orderCode);
}
