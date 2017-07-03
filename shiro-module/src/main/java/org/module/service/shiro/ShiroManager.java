package org.module.service.shiro;

public interface ShiroManager {

	/**
	 * 
	 * 方法: loadFilterChainDefinitions <br>
	 * 描述: 加载过滤配置信息 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月3日 上午10:24:38
	 * 
	 * @return
	 */
	public String loadFilterChainDefinitions();

	/**
	 * 
	 * 方法: reCreateFilterChains <br>
	 * 描述: 重新构建权限过滤器 一般在修改了用户角色、用户等信息时，需要再次调用该方法 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月3日 上午10:24:44
	 */
	public void reCreateFilterChains();

}
