package org.module.mapper.system.menu;

import org.module.commons.annotation.obj.ObjectExplain;
import org.module.commons.base.BaseMapper;
import org.module.dto.system.menu.SmMenuGroupDto;
import org.module.model.system.menu.SmMenuGroup;

/**
 * 
 * 类: SmMenuGroupMapper <br>
 * 描述: 系统菜单组数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2016年12月29日 下午5:23:09
 */
@ObjectExplain(name = "系统菜单组数据库访问接口", description = "对于systemmodudel库的sm_menu_group表进行数据库操作")
public interface SmMenuGroupMapper extends BaseMapper<SmMenuGroup, SmMenuGroupDto> {
}