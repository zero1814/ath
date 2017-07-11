package org.module.shiro.cache;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.module.util.SerializeUtil;
import org.module.util.SpringContextUtil;

import redis.clients.jedis.JedisCluster;

/**
 * 
 * 类: VCache <br>
 * 描述: 简单封装的Cache <br>
 * 作者: zhy<br>
 * 时间: 2017年7月3日 上午10:32:11
 */
@SuppressWarnings("unchecked")
public class VCache {

	final static JedisCluster cluster = SpringContextUtil.getBean("jedisCluster", JedisCluster.class);

	private VCache() {
	}

	/**
	 * 简单的Get
	 * 
	 * @param <T>
	 * @param key
	 * @param requiredType
	 * @return
	 */
	public static <T> T get(String key, Class<T>... requiredType) {
		try {
			byte[] skey = SerializeUtil.serialize(key);
			byte[] sval = cluster.get(skey);
			return SerializeUtil.deserialize(sval, requiredType);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource();
		}
		return null;
	}

	/**
	 * 简单的set
	 * 
	 * @param key
	 * @param value
	 */
	public static void set(Object key, Object value) {
		try {
			byte[] skey = SerializeUtil.serialize(key);
			byte[] svalue = SerializeUtil.serialize(value);
			cluster.set(skey, svalue);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource();
		}
	}

	/**
	 * 过期时间的
	 * 
	 * @param key
	 * @param value
	 * @param timer
	 *            （秒）
	 */
	public static void setex(Object key, Object value, int timer) {
		try {
			byte[] skey = SerializeUtil.serialize(key);
			byte[] svalue = SerializeUtil.serialize(value);
			cluster.setex(skey, timer, svalue);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource();
		}

	}

	/**
	 * 
	 * @param <T>
	 * @param mapkey
	 *            map
	 * @param key
	 *            map里的key
	 * @param requiredType
	 *            value的泛型类型
	 * @return
	 */
	public static <T> T getVByMap(String mapkey, String key, Class<T> requiredType) {
		try {
			byte[] mkey = SerializeUtil.serialize(mapkey);
			byte[] skey = SerializeUtil.serialize(key);
			List<byte[]> result = cluster.hmget(mkey, skey);
			if (null != result && result.size() > 0) {
				byte[] x = result.get(0);
				T resultObj = SerializeUtil.deserialize(x, requiredType);
				return resultObj;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource();
		}
		return null;
	}

	/**
	 * 
	 * @param mapkey
	 *            map
	 * @param key
	 *            map里的key
	 * @param value
	 *            map里的value
	 */
	public static void setVByMap(String mapkey, String key, Object value) {
		try {
			byte[] mkey = SerializeUtil.serialize(mapkey);
			byte[] skey = SerializeUtil.serialize(key);
			byte[] svalue = SerializeUtil.serialize(value);
			cluster.hset(mkey, skey, svalue);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource();
		}

	}

	/**
	 * 删除Map里的值
	 * 
	 * @param mapKey
	 * @param dkey
	 * @return
	 */
	public static Object delByMapKey(String mapKey, String... dkey) {
		try {
			byte[][] dx = new byte[dkey.length][];
			for (int i = 0; i < dkey.length; i++) {
				dx[i] = SerializeUtil.serialize(dkey[i]);
			}
			byte[] mkey = SerializeUtil.serialize(mapKey);
			Long result = cluster.hdel(mkey, dx);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource();
		}
		return new Long(0);
	}

	/**
	 * 往redis里取set整个集合
	 * 
	 * @param <T>
	 * @param setKey
	 * @param start
	 * @param end
	 * @param requiredType
	 * @return
	 */
	public static <T> Set<T> getVByList(String setKey, Class<T> requiredType) {
		try {
			byte[] lkey = SerializeUtil.serialize(setKey);
			Set<T> set = new TreeSet<T>();
			Set<byte[]> xx = cluster.smembers(lkey);
			for (byte[] bs : xx) {
				T t = SerializeUtil.deserialize(bs, requiredType);
				set.add(t);
			}
			return set;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource();
		}
		return null;
	}

	/**
	 * 获取Set长度
	 * 
	 * @param setKey
	 * @return
	 */
	public static Long getLenBySet(String setKey) {
		try {
			Long result = cluster.scard(setKey);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource();
		}
		return null;
	}

	/**
	 * 删除Set
	 * 
	 * @param dkey
	 * @return
	 */
	public static Long delSetByKey(String key, String... dkey) {
		try {
			Long result = 0L;
			if (null == dkey) {
				result = cluster.srem(key);
			} else {
				result = cluster.del(key);
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource();
		}
		return new Long(0);
	}

	/**
	 * 随机 Set 中的一个值
	 * 
	 * @param key
	 * @return
	 */
	public static String srandmember(String key) {
		try {
			String result = cluster.srandmember(key);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource();
		}
		return null;
	}

	/**
	 * 往redis里存Set
	 * 
	 * @param setKey
	 * @param value
	 */
	public static void setVBySet(String setKey, String value) {
		try {
			cluster.sadd(setKey, value);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource();
		}
	}

	/**
	 * 取set
	 * 
	 * @param key
	 * @return
	 */
	public static Set<String> getSetByKey(String key) {
		try {
			Set<String> result = cluster.smembers(key);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource();
		}
		return null;

	}

	/**
	 * 往redis里存List
	 * 
	 * @param listKey
	 * @param value
	 */
	public static void setVByList(String listKey, Object value) {
		try {
			byte[] lkey = SerializeUtil.serialize(listKey);
			byte[] svalue = SerializeUtil.serialize(value);
			cluster.rpush(lkey, svalue);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource();
		}
	}

	/**
	 * 往redis里取list
	 * 
	 * @param <T>
	 * @param listKey
	 * @param start
	 * @param end
	 * @param requiredType
	 * @return
	 */
	public static <T> List<T> getVByList(String listKey, int start, int end, Class<T> requiredType) {
		try {
			byte[] lkey = SerializeUtil.serialize(listKey);
			List<T> list = new ArrayList<T>();
			List<byte[]> xx = cluster.lrange(lkey, start, end);
			for (byte[] bs : xx) {
				T t = SerializeUtil.deserialize(bs, requiredType);
				list.add(t);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource();
		}
		return null;
	}

	/**
	 * 获取list长度
	 * 
	 * @param listKey
	 * @return
	 */
	public static Long getLenByList(String listKey) {
		try {
			byte[] lkey = SerializeUtil.serialize(listKey);
			Long result = cluster.llen(lkey);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource();
		}
		return null;
	}

	/**
	 * 删除
	 * 
	 * @param dkey
	 * @return
	 */
	public static Long delByKey(String... dkey) {
		try {
			byte[][] dx = new byte[dkey.length][];
			for (int i = 0; i < dkey.length; i++) {
				dx[i] = SerializeUtil.serialize(dkey[i]);
			}
			Long result = cluster.del(dx);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource();
		}
		return new Long(0);
	}

	/**
	 * 判断是否存在
	 * 
	 * @param existskey
	 * @return
	 */
	public static boolean exists(String existskey) {
		try {
			byte[] lkey = SerializeUtil.serialize(existskey);
			return cluster.exists(lkey);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource();
		}
		return false;
	}

	/**
	 * 释放
	 * 
	 * @param jedis
	 * @param isBroken
	 */
	public static void returnResource() {
		if (cluster == null)
			return;
		try {
			cluster.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
