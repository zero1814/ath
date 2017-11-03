package org.module.service.echarts.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.module.service.echarts.IOrderService;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * 类: EChartsServiceImpl <br>
 * 描述: 百度图标处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年11月3日 上午9:14:27
 */
@Service
public class OrderServiceImpl implements IOrderService {

	/**
	 * 
	 * 方法: orderData <br>
	 * 
	 * @return
	 * @see org.module.service.echarts.IOrderService#orderData()
	 */
	@Override
	public JSONArray orderData() {
		JSONArray array = new JSONArray();
		array.add(orderTotal());
		array.add(orderPractical());
		array.add(orderLapse());
		return array;
	}

	/**
	 * 
	 * 方法: orderTotal <br>
	 * 描述: 订单总量 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年11月3日 上午9:31:38
	 * 
	 * @return
	 */
	private static JSONObject orderTotal() {
		JSONObject total = new JSONObject();
		total.put("name", "订单总量");
		total.put("type", "line");
		List<BigDecimal> list = new ArrayList<BigDecimal>();
		for (int i = 0; i < 20; i++) {
			BigDecimal val = BigDecimal.valueOf(Math.random() * 100).setScale(2,BigDecimal.ROUND_HALF_UP);
			list.add(val);
		}
		total.put("data", list);
		JSONArray markPoint = new JSONArray();
		JSONObject mark1 = new JSONObject();
		mark1.put("type", "max");
		mark1.put("name", "最大值");
		markPoint.add(mark1);
		JSONObject mark2 = new JSONObject();
		mark2.put("type", "min");
		mark2.put("name", "最小值");
		markPoint.add(mark2);
		total.put("markPoint", markPoint);
		return total;
	}

	/**
	 * 
	 * 方法: orderPractical <br>
	 * 描述: 实际支付订单 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年11月3日 上午9:32:30
	 * 
	 * @return
	 */
	private static JSONObject orderPractical() {
		JSONObject practical = new JSONObject();
		practical.put("name", "实际成交量");
		practical.put("type", "line");
		List<BigDecimal> list = new ArrayList<BigDecimal>();
		for (int i = 0; i < 20; i++) {
			BigDecimal val = BigDecimal.valueOf(Math.random() * 100).setScale(2,BigDecimal.ROUND_HALF_UP);
			list.add(val);
		}
		practical.put("data", list);
		JSONArray markPoint = new JSONArray();
		JSONObject mark1 = new JSONObject();
		mark1.put("type", "max");
		mark1.put("name", "最大值");
		markPoint.add(mark1);
		JSONObject mark2 = new JSONObject();
		mark2.put("type", "min");
		mark2.put("name", "最小值");
		markPoint.add(mark2);
		practical.put("markPoint", markPoint);
		return practical;
	}

	/**
	 * 
	 * 方法: orderLapse <br>
	 * 描述: 失效订单 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年11月3日 上午9:32:47
	 * 
	 * @return
	 */
	private static JSONObject orderLapse() {
		JSONObject lapse = new JSONObject();
		lapse.put("name", "失效订单量");
		lapse.put("type", "line");
		List<BigDecimal> list = new ArrayList<BigDecimal>();
		for (int i = 0; i < 20; i++) {
			BigDecimal val = BigDecimal.valueOf(Math.random() * 100).setScale(2,BigDecimal.ROUND_HALF_UP);
			list.add(val);
		}
		lapse.put("data", list);
		JSONArray markPoint = new JSONArray();
		JSONObject mark1 = new JSONObject();
		mark1.put("type", "max");
		mark1.put("name", "最大值");
		markPoint.add(mark1);
		JSONObject mark2 = new JSONObject();
		mark2.put("type", "min");
		mark2.put("name", "最小值");
		markPoint.add(mark2);
		lapse.put("markPoint", markPoint);
		return lapse;
	}
}
