package org.module.mapper.logger.order;

import java.util.List;

import org.module.dto.logger.order.LmOrderStatusDto;
import org.module.mapper.BaseMapper;
import org.module.model.logger.order.LmOrderStatus;

/**
 * 
 * 类: LmOrderStatusMapper <br>
 * 描述: 订单状态更新日志数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月21日 上午11:20:10
 */
public interface LmOrderStatusMapper extends BaseMapper<LmOrderStatus, LmOrderStatusDto> {
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
	List<LmOrderStatus> selectByOrderCode(String orderCode);
}