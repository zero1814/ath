package org.module.result.index;

import java.util.List;

import org.module.model.system.menu.SmMenu;
import org.module.result.RootResult;

/**
 * 
 * 类: IndexResult <br>
 * 描述: 首页加载结果集 <br>
 * 作者: zhy<br>
 * 时间: 2017年1月3日 上午9:02:36
 */
public class IndexResult extends RootResult {

	/**
	 * 菜单栏
	 */
	private List<SmMenu> menus;

	public List<SmMenu> getMenus() {
		return menus;
	}

	public void setMenus(List<SmMenu> menus) {
		this.menus = menus;
	}

}
