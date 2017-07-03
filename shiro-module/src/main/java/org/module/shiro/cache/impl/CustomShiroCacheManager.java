package org.module.shiro.cache.impl;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.Destroyable;
import org.module.shiro.cache.ShiroCacheManager;

/**
 * 
 * 类: CustomShiroCacheManager <br>
 * 描述: shiro Custom Cache <br>
 * 作者: zhy<br>
 * 时间: 2017年7月3日 上午10:29:39
 */
public class CustomShiroCacheManager implements CacheManager, Destroyable {

	private ShiroCacheManager shiroCacheManager;

	@Override
	public <K, V> Cache<K, V> getCache(String name) throws CacheException {
		return getShiroCacheManager().getCache(name);
	}

	@Override
	public void destroy() throws Exception {
		shiroCacheManager.destroy();
	}

	public ShiroCacheManager getShiroCacheManager() {
		return shiroCacheManager;
	}

	public void setShiroCacheManager(ShiroCacheManager shiroCacheManager) {
		this.shiroCacheManager = shiroCacheManager;
	}

}
