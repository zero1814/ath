package org.module.service.impl.system.menu;

import org.module.commons.annotation.obj.ObjectExplain;
import org.module.commons.base.BaseServiceImpl;
import org.module.dto.system.menu.SmMenuPermissionDto;
import org.module.mapper.system.menu.SmMenuPermissionMapper;
import org.module.model.system.menu.SmMenuPermission;
import org.module.service.system.menu.ISmMenuPermissionService;

/**
 * 
 * 类: SmMenuPermissionServiceImpl <br>
 * 描述: 系统菜单权限业务逻辑访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2016年12月29日 下午5:48:48
 */
@ObjectExplain(name = "系统菜单权限业务逻辑访问接口", description = "对系统菜单权限相关业务逻辑操作接口")
public class SmMenuPermissionServiceImpl
		extends BaseServiceImpl<SmMenuPermission, SmMenuPermissionMapper, SmMenuPermissionDto>
		implements ISmMenuPermissionService {

}
