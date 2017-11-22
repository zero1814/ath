package org.module.commons.file.prop;

import org.module.commons.BaseClass;
import org.module.commons.helper.CacheHelper;
import org.module.commons.map.MStringMap;
import org.module.commons.util.StringUtils;

/**
 * 
 * 类: PropConfig <br>
 * 描述: properties配置文件相关操作 <br>
 * 作者: zhy<br>
 * 时间: 2016年9月22日 下午10:36:56
 */
public class PropConfig extends BaseClass{

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
			value = CacheHelper.getFiledVal("config", key);
		} catch (Exception e) {
			logger.logError(PropConfig.class,"查询PropConfig 缓存数据失败");
		} finally {
			if (StringUtils.isBlank(value)) {
				MStringMap map = PropLoad.instance().getData("config");
				value = map.get(key);
			}
		}
		return value;
	}
}
