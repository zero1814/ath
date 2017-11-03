package org.module.service.echarts.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.module.service.echarts.IUserService;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
/**
 * 
 * 类: UserServiceImpl <br>
 * 描述: 百度图表用户处理接口实现类 <br> <br>
 * 作者: zhy<br>
 * 时间: 2017年11月3日 上午9:38:38
 */
import com.alibaba.fastjson.JSONObject;

@Service
public class UserServiceImpl implements IUserService {

	@Override
	public JSONArray userData() {
		JSONArray array = new JSONArray();
		array.add(userTotal());
		array.add(userOld());
		array.add(userNew());
		return array;
	}

	/**
	 * 
	 * 方法: userTotal <br>
	 * 描述: 用户总数 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年11月3日 上午9:42:07
	 * 
	 * @return
	 */
	private static JSONObject userTotal() {
		JSONObject total = new JSONObject();
		total.put("name", "用户总数");
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
	 * 方法: userOld <br>
	 * 描述: 老用户 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年11月3日 上午9:42:14
	 * 
	 * @return
	 */
	private static JSONObject userOld() {
		JSONObject total = new JSONObject();
		total.put("name", "老用户");
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
	 * 方法: userNew <br>
	 * 描述: 新增用户 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年11月3日 上午9:42:21
	 * 
	 * @return
	 */
	private static JSONObject userNew() {
		JSONObject total = new JSONObject();
		total.put("name", "新增用户");
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

}
