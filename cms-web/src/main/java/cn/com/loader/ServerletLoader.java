package cn.com.loader;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.module.helper.LoggerHelper;
import org.module.init.commons.PropertiesInit;
import org.module.init.system.SmDefineInit;
import org.module.util.SpringContextUtil;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 
 * 类: ServerletLoader <br>
 * 描述: * Serverlet加载时调用
 * 
 * 该类兼容两种调用模式 一种是由<br>
 * {@link ServerletListener#contextInitialized} 调用,<br>
 * 此调用模式需要在web.xml增加listener <br>
 * 另外一种是由继承{@link WebApplicationInitializer#onStartup}的调用<br>
 * 此调用模式支持spring的注解式调用<br>
 * 两种调用模式用{@linkplain #bFlagLoad}参数来防止重复调用 作者: zhy<br>
 * 时间: 2017年10月23日 下午1:49:56
 */
public class ServerletLoader {

	/**
	 * 是否已加载 该参数标记该初始化操作是否已加载 默认初始化只调用一次
	 */
	private static boolean bFlagLoad = false;

	/**
	 * 初始化类
	 * 
	 * 
	 * @param servletContext
	 */
	public synchronized boolean init(ServletContext servletContext) {
		boolean flag = true;
		if (!bFlagLoad) {
			bFlagLoad = true;
			try {
				LoggerHelper.info(getClass(), "开始初始化数据。。。。。。。。");
				servletContext.log("Initializing cms web core");
				WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(servletContext);
				SpringContextUtil.setApplicationContext(wac);
				new PropertiesInit().init();
				new SmDefineInit().init();
				servletContext.log("Initializing cms web core finished");
				LoggerHelper.info(getClass(), "初始化数据完成。。。。。。。。");
			} catch (RuntimeException ex) {
				flag = false;
				servletContext.log("Error occurs in initializing cms web core" + ex.getMessage());
				LoggerHelper.error(getClass(), "初始化数据完成。。。。。。。。");
			}
		}
		return flag;
	}

	public void onStartup(ServletContext servletContext) throws ServletException {

		if (!bFlagLoad) {
			if (!init(servletContext)) {
				servletContext.log(this.getClass().getName() + " Error onStartup");
				throw new ServletException("init error");
			}
		}
	}

	/**
	 * 容器关闭时调用
	 * 
	 * @param servletContext
	 * @return
	 */
	public synchronized boolean destory(ServletContext servletContext) {
		return true;
	}

}
