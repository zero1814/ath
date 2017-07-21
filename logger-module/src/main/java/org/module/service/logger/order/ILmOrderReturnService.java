package org.module.service.logger.order;

import org.module.dto.logger.order.LmOrderReturnDto;
import org.module.model.logger.order.LmOrderReturn;
import org.module.result.DataResult;
import org.module.service.IBaseService;

/**
 * 
 * 类: ILmOrderReturnService <br>
 * 描述: 退换货日志业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月21日 上午10:56:47
 */
public interface ILmOrderReturnService extends IBaseService<LmOrderReturn, LmOrderReturnDto> {
	/**
	 * 
	 * 方法: selectByOrderCode <br>
	 * 描述: 根据订单编码查询退换货日志 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月21日 上午10:54:37
	 * 
	 * @param orderCode
	 * @return
	 */
	DataResult selectByOrderCode(String orderCode);
}
