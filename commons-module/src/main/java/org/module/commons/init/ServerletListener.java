package org.module.commons.init;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 初始化 加载各种配置和初始化类
 * 
 * @author HJY
 * 
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
