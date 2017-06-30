package org.module.service.cms;

import java.util.List;

import org.module.model.system.menu.SmMenu;

/**
 * 
 * 类: IndexService <br>
 * 描述: 首页相关业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月19日 上午8:29:00
 */
public interface IndexService {

	/**
	 * 
	 * 方法: init <br>
	 * 描述: 初始化数据加载 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月19日 上午8:30:03
	 * 
	 * @return
	 */
	List<SmMenu> initMenus();

}
