package org.module.web;

import org.apache.commons.lang.StringUtils;
import org.module.base.BaseClass;
import org.module.helper.commons.IoHelper;

/**
 * alias TopDir 主路径
 * 
 * @author HJY
 */
public class SysWorkDir extends BaseClass {

	/**
	 * alias upTempDir 获取临时文件夹路径
	 * 
	 * @param sTempDir
	 *            临时目录的子文件夹
	 * @return
	 */
	public String getTempDir(String sTempDir) {
		String tmp = getServerletPath("ath/adir/temp/");
		IoHelper.createDir(tmp);
		return tmp;
	}

	/**
	 * alias upServerletPath 获取程序路径
	 * 
	 * @param sSubDir
	 * @return
	 */
	public String getServerletPath(String sSubDir) {

		String sReturnString = System.getProperty("user.home");

		if (StringUtils.isNotBlank(sSubDir)) {
			sSubDir = "/" + sSubDir;
		}

		sReturnString = sReturnString + sSubDir;
		IoHelper.createDir(sReturnString);
		return sReturnString;

	}

	/**
	 * alias upCustomPath 获取加载扩展配置目录
	 * 
	 * @param sPath
	 *            目录名称 如果传入的参数以/结尾则自动创建文件夹
	 * @return
	 */
	public String getCustomPath(String sPath) {
		String sReturn = sPath;

		if (sReturn.endsWith("/")) {
			IoHelper.createDir(sReturn);
		}

		return sReturn;

	}

	/**
	 * alias upLocalConfigPath 获取本地配置目录 该目录为最后加载的配置 会覆盖所有已加载配置
	 * 
	 * @return
	 */
	public String getLocalConfigPath() {
		String sReturn = "";

		String sServerPath = getServerletPath("");

		String sStart = "/etc/ath/local/";

		// 判断如果是windows系统 则默认取系统所在路径的根目录
		if (StringUtils.substring(sServerPath, 1, 2).equals(":")) {
			sStart = sServerPath.substring(0, 2) + sStart;
		}

		sReturn = sStart;
		IoHelper.createDir(sReturn);
		return sReturn;

	}

}
