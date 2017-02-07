package org.module.service.index;

import java.util.List;

import org.module.model.system.menu.SmMenuGroup;

/**
 * 
 * 类: IndexService <br>
 * 描述: 首页相关业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年2月7日 下午10:18:50
 */
public interface IndexService {

	/**
	 * 
	 * 方法: getMenus <br>
	 * 描述: 获取菜单集合 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月7日 下午10:18:39
	 * 
	 * @return
	 */
	List<SmMenuGroup> getMenus();
}
