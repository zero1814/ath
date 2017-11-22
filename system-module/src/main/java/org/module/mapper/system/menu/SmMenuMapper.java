package org.module.mapper.system.menu;

import java.util.List;

import org.module.commons.mapper.BaseMapper;
import org.module.dto.system.menu.SmMenuDto;
import org.module.model.system.menu.SmMenu;

public interface SmMenuMapper extends BaseMapper<SmMenu, SmMenuDto> {

	List<SmMenu> findDataAll(SmMenuDto dto);

	/**
	 * 
	 * 方法: findAbleAddChildMenu <br>
	 * 描述: 查询所有可以添加子级菜单的菜单菜单名称 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年11月6日 上午10:12:57
	 * 
	 * @param code
	 * @return
	 */
	List<SmMenu> findAbleAddChildMenu(String code);
}
