package org.module.result.system;

import java.util.List;

import org.module.model.system.menu.SmMenuGroup;
import org.module.result.RootResult;

/**
 * 
 * 类: MenuResult <br>
 * 描述: 菜单列表结果集 <br>
 * 作者: zhy<br>
 * 时间: 2017年4月10日 上午10:25:58
 */
public class SmMenuGroupResult extends RootResult {

	private List<SmMenuGroup> group;

	public List<SmMenuGroup> getGroup() {
		return group;
	}

	public void setGroup(List<SmMenuGroup> group) {
		this.group = group;
	}

}
