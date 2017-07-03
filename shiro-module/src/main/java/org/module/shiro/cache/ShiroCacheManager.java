package org.module.shiro.cache;

import org.apache.shiro.cache.Cache;

/**
 * 
 * 类: ShiroCacheManager <br>
 * 描述: shiro cache manager 接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月3日 上午10:29:28
 */
public interface ShiroCacheManager {

	<K, V> Cache<K, V> getCache(String name);

	void destroy();

}
