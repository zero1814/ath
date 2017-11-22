package system;

import org.junit.Test;
import org.module.commons.helper.PropHelper;

public class PropTest {

	@Test
	public void test() {
		System.out.println(PropHelper.getConfig("system.define.tree.text"));
	}
}
