package org.module.service.system.menu;

import org.module.base.result.TreeResult;
import org.module.base.service.IBaseService;
import org.module.dto.system.menu.SmMenuDto;
import org.module.model.system.menu.SmMenu;

public interface ISmMenuService extends IBaseService<SmMenu, SmMenuDto> {

	/**
	 * 
	 * 方法: tree <br>
	 * 描述: 加载树形菜单 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年10月23日 下午6:05:45
	 * 
	 * @param groupCode
	 * @return
	 */
	TreeResult tree(String groupCode);
}
