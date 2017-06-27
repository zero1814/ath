package org.module.shiro.cache;

import java.util.Collection;
import java.util.Set;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.module.cache.RedisByte;
import org.module.commons.annotation.Inject;
import org.module.commons.util.SerializeUtil;

import redis.clients.jedis.JedisCluster;

/**
 * 
 * 类: RedisShiroCache <br>
 * 描述: reids shiro缓存 <br>
 * 作者: zhy<br>
 * 时间: 2017年6月27日 下午2:44:16
 * 
 * @param <K>
 * @param <V>
 */
public class RedisShiroCache<K, V> implements Cache<K, V> {

	@Inject
	private JedisCluster cluster;

	@Override
	public void clear() throws CacheException {

	}

	/**
	 * 
	 * 方法: get <br>
	 * 描述: TODO
	 * 
	 * @param k
	 * @return
	 * @throws CacheException
	 * @see org.apache.shiro.cache.Cache#get(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public V get(K k) throws CacheException {
		byte[] key = SerializeUtil.serialize(k);
		byte[] val = RedisByte.instance().getValue(key);
		return (V) SerializeUtil.serialize(val);
	}

	@Override
	public Set<K> keys() {
		return null;
	}

	/**
	 * 
	 * 方法: put <br>
	 * 描述: TODO
	 * 
	 * @param k
	 * @param v
	 * @return
	 * @throws CacheException
	 * @see org.apache.shiro.cache.Cache#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V put(K k, V v) throws CacheException {
		byte[] key = SerializeUtil.serialize(k);
		byte[] value = SerializeUtil.serialize(v);
		RedisByte.instance().setValue(key, value);
		return v;
	}

	/**
	 * 
	 * 方法: remove <br>
	 * 描述: TODO
	 * 
	 * @param k
	 * @return
	 * @throws CacheException
	 * @see org.apache.shiro.cache.Cache#remove(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public V remove(K k) throws CacheException {
		byte[] key = SerializeUtil.serialize(k);
		byte[] val = RedisByte.instance().getValue(key);
		if (val != null && val.length > 0) {
			RedisByte.instance().delValue(key);
		}
		return (V) SerializeUtil.serialize(val);
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public Collection<V> values() {
		return null;
	}

}
