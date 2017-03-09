package org.module.commons.tools.file.prop;

import org.apache.commons.lang3.StringUtils;
import org.module.commons.map.MStringMap;

/**
 * 
 * 类: PropInfo <br>
 * 描述: 信息properties文件相关操作 <br>
 * 作者: zhy<br>
 * 时间: 2016年9月22日 下午10:37:21
 */
public class PropInfo {

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
		String value = "";
		MStringMap map = PropLoad.instance().getData("info");
		if(StringUtils.isNoneBlank(map.get(key))){
			value = map.get(key);
		}
		return value;
	}
}
