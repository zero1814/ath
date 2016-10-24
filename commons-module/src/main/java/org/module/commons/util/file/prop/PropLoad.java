package org.module.commons.util.file.prop;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.module.commons.map.MStringMap;

/**
 * 
 * 类: LoadProp <br>
 * 描述: 读取properties配置文件 <br>
 * 作者: zhy<br>
 * 时间: 2016年9月22日 下午10:37:56
 */
public class PropLoad {

	/**
	 * 
	 * 方法: loadProperties <br>
	 * 描述: 读取配置文件 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年9月21日 下午10:30:38
	 * 
	 * @param path
	 * @return
	 */
	public static MStringMap loadProperties(String path) {
		MStringMap map = new MStringMap();
		FileInputStream fis = null;
		try {
			/**
			 * 遍历所有properties后缀的文件
			 */
			Collection<File> files = FileUtils.listFiles((new File(path)), new String[] { "properties" }, true);
			for (File file : files) {
				PropertiesConfiguration config = new PropertiesConfiguration();
				fis = FileUtils.openInputStream(file);
				/**
				 * 读取文件
				 */
				config.load(fis, "UTF-8");
				Iterator<String> keys = config.getKeys();
				// 定义命名空间
				String nameSpace = StringUtils.defaultString(config.getString("@this$namespace"), "");
				/**
				 * 遍历config的所有key
				 */
				while (keys.hasNext()) {
					String key = keys.next();
					// 定义是否强制覆盖
					boolean overWriteFlag = false;
					String value = StringUtils.join(config.getStringArray(key), ",");
					if (StringUtils.isNotEmpty(nameSpace)) {
						if (!StringUtils.startsWith(key, "@") && !StringUtils.startsWith(key, nameSpace)) {
							key = nameSpace + "." + key;
						}
					}
					// 进行特殊判断模式
					if (StringUtils.startsWith(key, "@")) {
						String sTarget = StringUtils.substringBetween(key, "@", "$");
						// 覆写配置
						if (sTarget.equals("override")) {
							// override
							overWriteFlag = true;
						}
						// 本配置指向
						else if (sTarget.equals("this")) {

						}
						key = StringUtils.substringAfter(key, "$");
					}

					if (overWriteFlag || !map.containsKey(key)) {
						map.put(key, value);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return map;
	}
}
