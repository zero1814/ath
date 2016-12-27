package org.module.commons.helper;

import org.module.commons.util.UniqueIdUtil;

public class CodeHelper {

	public static String getUniqueCode(String data, String prefix) {
		long workid = 1;
		return prefix + UniqueIdUtil.getInstance(workid, workid).nextId();
	}
}
