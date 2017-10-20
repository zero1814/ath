package org.module.service.system.menu;

import java.util.List;

import org.module.base.result.TreeResult;
import org.module.base.service.IBaseService;
import org.module.dto.system.menu.SmMenuDto;
import org.module.model.system.menu.SmMenu;
import org.module.model.system.page.SmPage;

/**
 * 
 * 类: ISmMenuService <br>
 * 描述: 菜单业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月31日 上午11:05:24
 */
public interface ISmMenuService extends IBaseService<SmMenu, SmMenuDto> {
	/**
	 * 
	 * 方法: findDataAll <br>
	 * 描述: 获取所有菜单集合 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月1日 上午10:41:52
	 * 
	 * @return
	 */
	TreeResult treeData();

	/**
	 * 
	 * 方法: pages <br>
	 * 描述: 获取所有可用页面 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月12日 下午9:46:47
	 * 
	 * @return
	 */
	List<SmPage> pages();
}
