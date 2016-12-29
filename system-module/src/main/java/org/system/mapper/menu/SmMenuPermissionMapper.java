package org.system.mapper.menu;

import org.commons.annotation.obj.ObjectExplain;
import org.commons.base.BaseMapper;
import org.system.dto.menu.SmMenuPermissionDto;
import org.system.model.menu.SmMenuPermission;

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