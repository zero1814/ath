package org.module.service.system.menu;

import java.util.List;

import org.module.dto.system.menu.SmMenuDto;
import org.module.model.system.menu.SmMenu;
import org.module.service.IBaseService;

/**
 * 
 * 类: ISmMenuService <br>
 * 描述: 菜单表业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月18日 下午5:17:06
 */
public interface ISmMenuService extends IBaseService<SmMenu, SmMenuDto> {

	/**
	 * 
	 * 方法: menus <br>
	 * 描述: 根据菜单分组编码查询菜单列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月18日 下午5:17:26
	 * 
	 * @param groupCode
	 * @return
	 */
	List<SmMenu> menus(String groupCode);
}
