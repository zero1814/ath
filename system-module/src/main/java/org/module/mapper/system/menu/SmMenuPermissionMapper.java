package org.module.mapper.system.menu;

import org.module.commons.annotation.obj.ObjectExplain;
import org.module.dto.system.menu.SmMenuPermissionDto;
import org.module.mapper.BaseMapper;
import org.module.model.system.menu.SmMenuPermission;

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