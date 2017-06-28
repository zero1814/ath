package org.module.shiro.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.Destroyable;

public class ShiroCacheManager implements CacheManager, Destroyable {

	private ShiroCacheManager manager;

	@Override
	public void destroy() throws Exception {
		manager.destroy();
	}

	/**
	 * 
	 * 方法: getCache <br>
	 * 描述: 获取缓存
	 * 
	 * @param name
	 * @return
	 * @throws CacheException
	 * @see org.apache.shiro.cache.CacheManager#getCache(java.lang.String)
	 */
	@Override
	public <K, V> Cache<K, V> getCache(String name) throws CacheException {
		return getManager().getCache(name);
	}

	public ShiroCacheManager getManager() {
		return manager;
	}

	public void setManager(ShiroCacheManager manager) {
		this.manager = manager;
	}

}
