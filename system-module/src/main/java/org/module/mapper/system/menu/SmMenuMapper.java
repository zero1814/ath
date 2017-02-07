package org.module.mapper.system.menu;

import java.util.List;

import org.module.commons.annotation.obj.Object;
import org.module.dto.system.menu.SmMenuDto;
import org.module.mapper.BaseMapper;
import org.module.model.system.menu.SmMenu;

/**
 * 
 * 类: SmMenuMapper <br>
 * 描述: 系统菜单数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年2月7日 下午9:56:21
 */
@Object(name = "系统菜单数据库访问接口", description = "系统菜单数据库访问接口")
public interface SmMenuMapper extends BaseMapper<SmMenu, SmMenuDto> {

	/**
	 * 
	 * 方法: findEntityAllForGroup <br>
	 * 描述: 查询菜单组下的所有可用菜单集合 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月7日 下午9:55:58
	 * 
	 * @param dto
	 * @return
	 */
	List<SmMenu> findEntityAllForGroup(SmMenuDto dto);
}