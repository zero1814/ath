package org.module.service.echarts;

import com.alibaba.fastjson.JSONArray;

/**
 * 
 * 类: IEChartsService <br>
 * 描述: 百度图表订单处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年11月3日 上午9:14:16
 */
public interface IOrderService {

	/**
	 * 
	 * 方法: orderTotal <br>
	 * 描述: 订单总量 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年11月3日 上午9:31:38
	 * @return
	 */
	JSONArray orderData();
	

}
