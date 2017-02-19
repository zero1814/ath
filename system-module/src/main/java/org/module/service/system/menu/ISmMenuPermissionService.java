package org.module.service.system.menu;

import java.util.List;

import org.module.dto.system.menu.SmMenuPermissionDto;
import org.module.model.system.SmDefine;
import org.module.model.system.menu.SmMenuPermission;
import org.module.service.IBaseService;

public interface ISmMenuPermissionService extends IBaseService<SmMenuPermission, SmMenuPermissionDto> {
	/**
	 * 
	 * 方法: getMenuPermissionType <br>
	 * 描述: 获取菜单权限集合 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月19日 下午8:24:16
	 * 
	 * @return
	 */
	public List<SmDefine> getMenuPermissionType();
}
