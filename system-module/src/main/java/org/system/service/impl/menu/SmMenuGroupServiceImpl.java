package org.system.service.impl.menu;

import org.commons.annotation.obj.ObjectExplain;
import org.commons.base.BaseServiceImpl;
import org.system.dto.menu.SmMenuGroupDto;
import org.system.mapper.menu.SmMenuGroupMapper;
import org.system.model.menu.SmMenuGroup;
import org.system.service.menu.ISmMenuGroupService;

/**
 * 
 * 类: SmMenuGroupServiceImpl <br>
 * 描述: 系统菜单组业务逻辑访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2016年12月29日 下午5:48:22
 */
@ObjectExplain(name = "系统菜单组业务逻辑访问接口", description = "对系统菜单组相关业务逻辑操作接口")
public class SmMenuGroupServiceImpl extends BaseServiceImpl<SmMenuGroup, SmMenuGroupMapper, SmMenuGroupDto>
		implements ISmMenuGroupService {

}
