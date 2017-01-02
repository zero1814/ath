package org.module.service.impl.system.menu;

import org.module.commons.annotation.obj.ObjectExplain;
import org.module.dto.system.menu.SmMenuDto;
import org.module.mapper.system.menu.SmMenuMapper;
import org.module.model.system.menu.SmMenu;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.menu.ISmMenuService;

/**
 * 
 * 类: SmMenuServiceImpl <br>
 * 描述: 系统菜单业务逻辑访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2016年12月29日 下午5:49:11
 */
@ObjectExplain(name = "系统菜单业务逻辑访问接口", description = "对系统菜单相关业务逻辑操作接口")
public class SmMenuServiceImpl extends BaseServiceImpl<SmMenu, SmMenuMapper, SmMenuDto> implements ISmMenuService {

}
