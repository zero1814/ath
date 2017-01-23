package org.module.result.system.menugroup;

import org.module.commons.map.MStringMap;
import org.module.commons.util.file.prop.PropLoad;
import org.module.result.RootResult;

public class SmMenuGroupAddResult extends RootResult {

	public static void main(String[] args) {
		MStringMap map = PropLoad.instance().getData("info");
		System.out.println(map);
	}
}
