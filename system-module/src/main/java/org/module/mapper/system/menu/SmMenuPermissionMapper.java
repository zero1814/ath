package org.module.mapper.system.menu;

import java.util.List;

import org.module.dto.system.menu.SmMenuPermissionDto;
import org.module.mapper.BaseMapper;
import org.module.model.system.menu.SmMenuPermission;

/**
 * 
 * 类: SmMenuPermissionMapper <br>
 * 描述: 菜单权限表数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年2月15日 下午5:15:24
 */
public interface SmMenuPermissionMapper extends BaseMapper<SmMenuPermission, SmMenuPermissionDto> {

	/**
	 * 
	 * 方法: findMenuPermissionByMenuCode <br>
	 * 描述: 根据菜单编码查询菜单权限列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月27日 上午9:26:34
	 * 
	 * @param menuCode
	 * @return
	 */
	List<SmMenuPermission> findMenuPermissionByMenuCode(String menuCode);
}