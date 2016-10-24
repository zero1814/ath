package org.module.commons.util.file.prop;

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
	 * @param nameSpace
	 * @return
	 */
	public static MStringMap init(String nameSpace) {
		MStringMap newMap = new MStringMap();
		MStringMap map = PropLoad.instance().getData("info");

		for (String str : map.getKeys()) {
			if (StringUtils.contains(str, nameSpace)) {
				newMap.put(str, map.get(str));
			}
		}
		return newMap;
	}
}
