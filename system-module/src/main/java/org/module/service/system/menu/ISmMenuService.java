package org.module.service.system.menu;

import java.util.List;

import org.module.base.result.DataResult;
import org.module.base.result.TreeResult;
import org.module.base.service.IBaseService;
import org.module.dto.system.menu.SmMenuDto;
import org.module.model.system.menu.SmMenu;
import org.module.model.system.menu.SmMenuGroup;
import org.module.model.system.menu.SmPage;

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

	/**
	 * 
	 * 方法: cacheMenu <br>
	 * 描述: 缓存菜单 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年10月25日 下午1:35:42
	 * 
	 * @return
	 */
	DataResult cacheMenu();

	/**
	 * 
	 * 方法: getMenuGroups <br>
	 * 描述: 获取所有分组 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年11月3日 上午10:42:46
	 * 
	 * @return
	 */
	List<SmMenuGroup> getMenuGroups();

	/**
	 * 
	 * 方法: getPages <br>
	 * 描述: 获取所有可用页面 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年11月3日 上午10:42:54
	 * 
	 * @return
	 */
	List<SmPage> getPages();
}
