package cn.com.cms.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import cn.com.cms.loader.ServerletLoader;


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