package org.module.commons.util.file.xml;

import org.module.helper.IoHelper;
import org.springframework.core.io.Resource;

public class XMLConfig {

	public Resource[] getResource() {
		Resource[] resources = null;
		try {
			resources = IoHelper.upResources("classpath*:dbproperties.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resources;
	}
}
