package org.module.helper.system;

import org.module.annotation.Inject;
import org.module.service.system.ISmCodeService;

public class CodeHelper {

	@Inject
	private ISmCodeService service;

	public static String getCode(String prefix) {
		new CodeHelper();
		return CodeHelper.getCode(prefix);
	}
}
