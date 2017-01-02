package org.module.mapper.system.menu;

import org.module.commons.annotation.obj.ObjectExplain;
import org.module.dto.system.menu.SmMenuDto;
import org.module.mapper.BaseMapper;
import org.module.model.system.menu.SmMenu;

/**
 * 
 * 类: SmMenuMapper <br>
 * 描述: 系统菜单表数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2016年12月29日 下午1:00:27
 */
@ObjectExplain(name = "系统菜单数据库访问接口", description = "对于systemmodudel库的sm_menu表进行数据库操作")
public interface SmMenuMapper extends BaseMapper<SmMenu, SmMenuDto> {
}