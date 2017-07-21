package org.module.util;

import java.io.File;
import java.util.Locale;

import freemarker.template.Configuration;

/**
 * 
 * 类: FreemarkerUtil <br>
 * 描述: Freemarker操作 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月21日 下午5:52:51
 */
public class FreeMarkerUtil {

	private static FreeMarkerUtil self;
	private Configuration config;

	public static FreeMarkerUtil instance() {
		if (self == null) {
			self = new FreeMarkerUtil();
		}
		return self;
	}

	public void createHtml(String ftlPath) {
		try {
			config = new Configuration(Configuration.VERSION_2_3_23);
			config.setEncoding(Locale.CHINA, "UTF-8");
			config.setDirectoryForTemplateLoading(new File(ftlPath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
