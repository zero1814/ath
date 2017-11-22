package org.module.commons.file.prop;

import org.module.commons.BaseClass;
import org.module.commons.helper.CacheHelper;
import org.module.commons.map.MStringMap;
import org.module.commons.util.StringUtils;

/**
 * 
 * 类: PropInfo <br>
 * 描述: 信息properties文件相关操作 <br>
 * 作者: zhy<br>
 * 时间: 2016年9月22日 下午10:37:21
 */
public class PropInfo extends BaseClass {

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
		try {
			value = CacheHelper.getFiledVal("info", key);
		} catch (Exception e) {
			logger.logError(PropInfo.class, "查询PropInfo 缓存数据失败");
		} finally {
			if (StringUtils.isBlank(value)) {
				MStringMap map = PropLoad.instance().getData("info");
				value = map.get(key);
			}
		}
		return value;
	}
}
