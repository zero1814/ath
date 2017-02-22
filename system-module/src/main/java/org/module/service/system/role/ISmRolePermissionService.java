package org.module.service.system.role;

import org.module.dto.system.role.SmRolePermissionDto;
import org.module.model.system.role.SmRolePermission;
import org.module.result.DataResult;
import org.module.service.IBaseService;

import com.alibaba.fastjson.JSONArray;

public interface ISmRolePermissionService extends IBaseService<SmRolePermission, SmRolePermissionDto> {

	/**
	 * 
	 * 方法: getMenus <br>
	 * 描述: 获取可用菜单列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月22日 上午9:59:16
	 * 
	 * @return
	 */
	public JSONArray getMenus();
	
	/**
	 * 
	 * 方法: getMenuPermission <br>
	 * 描述: 获取菜单权限列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月22日 下午3:37:49
	 * @return
	 */
	public DataResult getMenuPermission(String menuCode);
}
