package org.module.init.commons;

import org.module.base.map.MStringMap;
import org.module.cache.commons.CacheKey;
import org.module.file.prop.PropLoad;
import org.module.helper.CacheHelper;
import org.module.root.WebRootInit;

public class PropertiesInit extends WebRootInit {

	@Override
	public boolean onInit() {
		getLogger().logInfo("开始加载properties配置文件");
		boolean flag = true;
		try {
			initConfig();
			initInfo();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getLogger().logInfo("加载properties配置文件结束");
		}
		return flag;
	}

	@Override
	public boolean onDestory() {
		return false;
	}

	/**
	 * 
	 * 方法: initConfig <br>
	 * 描述: 加载config配置文件 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月23日 下午3:06:47
	 */
	private void initConfig() {
		logger.logInfo("开始加载config配置文件");
		try {
			MStringMap map = PropLoad.instance().getData("config");
			CacheHelper.setHash(CacheKey.PROP_CONFIG, map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			logger.logInfo("加载config配置文件结束");
		}

	}

	/**
	 * 
	 * 方法: initInfo <br>
	 * 描述: 加载info配置文件 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月23日 下午3:06:57
	 */
	private void initInfo() {
		logger.logInfo("开始加载info配置文件");
		try {
			MStringMap map = PropLoad.instance().getData("info");
			CacheHelper.setHash(CacheKey.PROP_INFO, map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			logger.logInfo("加载info配置文件结束");
		}
	}

}