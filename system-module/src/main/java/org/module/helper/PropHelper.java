package org.module.helper;

import org.module.commons.base.BaseClass;
import org.module.file.PropConfig;
import org.module.file.PropInfo;

/**
 * 
 * 类: PropHelper <br>
 * 描述: properties文件相关操作 <br>
 * 作者: zhy<br>
 * 时间: 2016年9月19日 下午10:14:19
 */
public class PropHelper extends BaseClass {

	/**
	 * 
	 * 方法: getConfig <br>
	 * 描述: 根据key值读取config的properties文件相关信息 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年9月22日 下午10:39:55
	 * 
	 * @param nameSpace
	 *            命名空间
	 * @param key
	 *            key
	 * @return
	 */
	public static String getConfig(String key) {
		return PropConfig.getValue(key);
	}

	/**
	 * 
	 * 方法: getConfig <br>
	 * 描述: 根据key值读取config的properties文件相关信息 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年9月22日 下午10:39:55
	 * 
	 * @param nameSpace
	 *            命名空间
	 * @param key
	 *            key
	 * @param params
	 *            参数数组
	 * @return
	 */
	public static String getConfig(String key, String... params) {
		String str = PropConfig.getValue(key);
		for (int i = 0, j = params.length; i < j; i++) {
			str = str.replace("{" + (i) + "}", params[i].toString());
		}
		return str;
	}

	/**
	 * 
	 * 方法: getInfo <br>
	 * 描述: 根据key值读取info的properties文件相关信息 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年9月22日 下午10:40:22
	 * 
	 * @param nameSpace
	 *            命名空间
	 * @param key
	 *            key
	 * 
	 * @return
	 */
	public static String getInfo(String key) {
		return PropInfo.getValue(key);
	}

	/**
	 * 
	 * 方法: getInfo <br>
	 * 描述: 根据key值读取info的properties文件相关信息 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年9月22日 下午10:40:22
	 * 
	 * @param nameSpace
	 *            命名空间
	 * @param key
	 *            key
	 * @param params
	 *            参数数组
	 * 
	 * @return
	 */
	public static String getInfo(String key, String... params) {
		String str = PropInfo.getValue(key);
		for (int i = 0, j = params.length; i < j; i++) {
			str = str.replace("{" + (i) + "}", params[i].toString());
		}
		return str;
	}
}