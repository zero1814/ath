package org.module.commons.util.file.prop;

import java.io.IOException;

import org.module.commons.helper.IoHelper;
import org.springframework.core.io.Resource;

/**
 * 
 * 类: PropConfig <br>
 * 描述: properties配置文件相关操作 <br>
 * 作者: zhy<br>
 * 时间: 2016年9月22日 下午10:36:56
 */
public class PropConfig {

	public synchronized void refresh() {
		try {
			Resource[] resources = IoHelper.upResources("classpath*:properties/config.*.properties");
			for (int i = 0; i < resources.length; i++) {
				System.out.println(resources[i].getFile().getParent());
				PropLoad.loadProperties(resources[i].getFile().getPath());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new PropConfig().refresh();
	}
}
