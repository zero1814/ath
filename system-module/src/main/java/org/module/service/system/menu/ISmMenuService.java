package org.module.service.system.menu;

import org.module.dto.system.menu.SmMenuDto;
import org.module.model.system.menu.SmMenu;
import org.module.service.IBaseService;

public interface ISmMenuService extends IBaseService<SmMenu, SmMenuDto> {

	/**
	 * 
	 * 方法: updateFlagAble <br>
	 * 描述: 修改菜单是否可用状态 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年1月3日 上午8:31:47
	 * 
	 * @param code
	 * @param flag
	 * @return
	 */
	public int updateFlagAble(String userCode, String code, Integer flag);
}
