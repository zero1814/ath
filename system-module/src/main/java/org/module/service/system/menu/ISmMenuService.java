package org.module.service.system.menu;

import org.module.dto.system.menu.SmMenuDto;
import org.module.model.system.menu.SmMenu;
import org.module.result.DataResult;
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
	DataResult tree(String groupCode);

	/**
	 * 
	 * 方法: menus <br>
	 * 描述: 获取可用的菜单列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月26日 下午3:07:38
	 * 
	 * @param groupCode
	 * @return
	 */
	DataResult menus(String groupCode);

	/**
	 * 
	 * 方法: menusPermission <br>
	 * 描述: 根据菜单编码查询菜单权限列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月27日 上午9:29:27
	 * 
	 * @param menuCode
	 * @return
	 */
	DataResult menusPermission(String menuCode);
}
