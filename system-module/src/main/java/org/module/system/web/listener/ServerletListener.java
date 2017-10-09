package org.module.system.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.module.system.web.loader.ServerletLoader;

/**
 * 
 * 类: ServerletListener <br>
 * 描述: 初始化 加载各种配置和初始化类 <br>
 * 作者: zhy<br>
 * 时间: 2017年10月9日 上午10:37:15
 */
public class ServerletListener extends ServerletLoader implements ServletContextListener {
	private ServerletLoader contextLoader;

	public void contextInitialized(ServletContextEvent event) {

		if (this.contextLoader == null) {
			this.contextLoader = this;
		}
		this.contextLoader.init(event.getServletContext());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		this.contextLoader.destory(sce.getServletContext());
	}
}
