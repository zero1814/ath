package org.module.system.mapper.menu;

import org.module.commons.annotation.obj.ObjectExplain;
import org.module.commons.base.BaseMapper;
import org.module.system.dto.menu.SmMenuPermissionDto;
import org.module.system.model.menu.SmMenuPermission;

/**
 * 
 * 类: SmMenuPermissionMapper <br>
 * 描述: 系统菜单权限数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2016年12月29日 下午5:25:12
 */
@ObjectExplain(name = "系统菜单权限数据库访问接口", description = "对于systemmodudel库的sm_menu_permission表进行数据库操作")
public interface SmMenuPermissionMapper extends BaseMapper<SmMenuPermission, SmMenuPermissionDto> {
}