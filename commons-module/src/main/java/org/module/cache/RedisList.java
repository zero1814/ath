package org.module.cache;

import org.module.annotation.Inject;
import org.module.base.BaseClass;

import redis.clients.jedis.JedisCluster;

/**
 * 
 * 类: RedisList <br>
 * 描述: list集合redis处理 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月5日 下午5:11:27
 */
public class RedisList extends BaseClass {

	@Inject
	private JedisCluster cluster;

	/**
	 * 
	 * 方法: set <br>
	 * 描述: Redis Lpush 命令将一个或多个值插入到列表头部。 如果 key 不存在，一个空列表会被创建并执行 LPUSH 操作。 当 key
	 * 存在但不是列表类型时，返回一个错误。 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月9日 上午8:42:11
	 * 
	 * @param key
	 * @param values
	 */
	public void lpush(String key, String... values) {
		if (cluster != null) {
			cluster.lpush(key, values);
		}
	}

	/**
	 * 
	 * 方法: get <br>
	 * 描述: Redis Rpush 命令用于将一个或多个值插入到列表的尾部(最右边)。<br>
	 * 如果列表不存在，一个空列表会被创建并执行 RPUSH 操作。 当列表存在但不是列表类型时，返回一个错误。 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月9日 上午9:12:11
	 * 
	 * @param key
	 * @param string
	 */
	public void rpush(String key, String... string) {
		if (cluster != null) {
			cluster.rpush(key, string);
		}
	}

	/**
	 * 
	 * 方法: get <br>
	 * 描述: Redis Lindex 命令用于通过索引获取列表中的元素。<br>
	 * 你也可以使用负数下标，以 -1 表示列表的最后一个元素， -2 表示列表的倒数第二个元素，以此类推。 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月9日 上午9:22:57
	 * 
	 * @param key
	 * @param index
	 * @return
	 */
	public String get(String key, int index) {
		String value = "";
		if (cluster != null) {
			value = cluster.lindex(key, index);
		}
		return value;
	}
}
