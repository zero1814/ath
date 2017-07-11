package org.module.helper.commons;

import org.module.base.BaseLog;

/**
 * 
 * 类: LogHelper <br>
 * 描述: 日志帮助类 <br>
 * 作者: zhy<br>
 * 时间: 2017年6月26日 下午2:15:06
 */
public class LoggerHelper {
	public static BaseLog logger = new BaseLog();

	/**
	 * 
	 * 方法: info <br>
	 * 描述: info类型日志输出 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月26日 下午2:15:12
	 * 
	 * @param clazz
	 * @param info
	 */
	public static void info(Class<?> clazz, String info) {
		logger.logInfo(clazz, info);
	}

	/**
	 * 
	 * 方法: debug <br>
	 * 描述: debug类型日志输出 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月26日 下午2:15:50
	 * 
	 * @param clazz
	 * @param debug
	 */
	public static void debug(Class<?> clazz, String debug) {
		logger.logDebug(clazz, debug);
	}

	/**
	 * 
	 * 方法: warn <br>
	 * 描述: warn类型日志输出 <br>
	 * 
	 * 作者: zhy<br>
	 * 时间: 2017年6月26日 下午2:20:13
	 * 
	 * @param clazz
	 * @param warn
	 */
	public static void warn(Class<?> clazz, String warn) {
		logger.logWarn(clazz, warn);
	}

	/**
	 * 
	 * 方法: error <br>
	 * 描述: error类型日志输出 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月26日 下午2:19:20
	 * 
	 * @param clazz
	 * @param error
	 */
	public static void error(Class<?> clazz, String error) {
		logger.logError(clazz, error);
	}

}
