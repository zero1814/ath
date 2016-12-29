package org.commons.util.file.xml;

import org.commons.helper.IoHelper;
import org.springframework.core.io.Resource;

public class XMLConfig {

	public String getResource() {
		try {
			Resource[] resources = IoHelper.upResources("classpath*:dbproperties.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
