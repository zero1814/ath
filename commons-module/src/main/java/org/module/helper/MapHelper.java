package org.module.helper;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 类: MapHelper <br>
 * 描述: 哈希表相关操作帮助类 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月18日 上午10:37:46
 */
public class MapHelper<T> {
	/**
	 * 
	 * 方法: objectToMap <br>
	 * 描述: 对象转换map <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月18日 下午2:15:51
	 * 
	 * @param obj
	 * @return
	 */
	public Map<String, Object> objectToMap(T obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		return map;
	}

	public T mapToObject(Map<String, Object> map, T obj) {
		return obj;
	}
}
