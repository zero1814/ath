package org.module.shiro.manager;

import org.apache.shiro.cache.Cache;

/**
 * 
 * 类: ShiroCacheManager <br>
 * 描述: shiro cache manager 接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年6月28日 下午2:34:03
 */
public interface ShiroCacheManager {
	<K, V> Cache<K, V> getCache(String name);

	void destroy();

}
