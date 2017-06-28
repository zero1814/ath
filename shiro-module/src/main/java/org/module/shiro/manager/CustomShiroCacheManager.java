package org.module.shiro.manager;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.Destroyable;

/**
 * 
 * 类: CustomShiroCacheManager <br>
 * 描述: shiro Custom Cache <br>
 * 作者: zhy<br>
 * 时间: 2017年6月28日 下午2:32:41
 */
public class CustomShiroCacheManager implements CacheManager, Destroyable {

	private ShiroCacheManager shiroCacheManager;

	@Override
	public void destroy() throws Exception {
		shiroCacheManager.destroy();
	}

	@Override
	public <K, V> Cache<K, V> getCache(String name) throws CacheException {
		return shiroCacheManager.getCache(name);
	}

	public ShiroCacheManager getShiroCacheManager() {
		return shiroCacheManager;
	}

	public void setShiroCacheManager(ShiroCacheManager shiroCacheManager) {
		this.shiroCacheManager = shiroCacheManager;
	}

}
