package org.module.service.system.menu;

import org.module.dto.system.menu.SmMenuDto;
import org.module.model.system.menu.SmMenu;
import org.module.result.DataResult;
import org.module.service.IBaseService;

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
	DataResult findDataAll();

	/**
	 * 
	 * 方法: getMenuPermission <br>
	 * 描述: 获取菜单权限列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月5日 下午5:57:57
	 * 
	 * @param code
	 * @return
	 */
	DataResult getMenuPermission(String code);
}
