package org.module.commons;

import org.junit.Test;
import org.module.helper.PropHelper;

public class PropTest {

	@Test
	public void info() {
		System.out.println(PropHelper.getInfo("commons.user.login.200"));
	}
}
