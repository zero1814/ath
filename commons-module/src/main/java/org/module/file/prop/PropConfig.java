package org.module.file.prop;

import org.module.cache.RedisHash;

/**
 * 
 * 类: PropConfig <br>
 * 描述: properties配置文件相关操作 <br>
 * 作者: zhy<br>
 * 时间: 2016年9月22日 下午10:36:56
 */
public class PropConfig {

	/**
	 * 
	 * 方法: init <br>
	 * 描述: 根据命名空间获取所有该配置文件的内容 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年10月24日 下午2:07:56
	 * 
	 * @param nameSpace
	 * @return
	 */
	public static String getValue(String key) {
		return RedisHash.instance().getFiled("config", key);
	}
}