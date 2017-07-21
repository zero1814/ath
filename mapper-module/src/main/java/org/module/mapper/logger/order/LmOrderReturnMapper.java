package org.module.mapper.logger.order;

import java.util.List;

import org.module.dto.logger.order.LmOrderReturnDto;
import org.module.mapper.BaseMapper;
import org.module.model.logger.order.LmOrderReturn;

/**
 * 
 * 类: LmOrderReturnMapper <br>
 * 描述: 退换货日志数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月21日 上午10:54:40
 */
public interface LmOrderReturnMapper extends BaseMapper<LmOrderReturn, LmOrderReturnDto> {
	
	/**
	 * 
	 * 方法: selectByOrderCode <br>
	 * 描述: 根据订单编码查询退换货日志 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月21日 上午10:54:37
	 * @param orderCode
	 * @return
	 */
	List<LmOrderReturn> selectByOrderCode(String orderCode);
}