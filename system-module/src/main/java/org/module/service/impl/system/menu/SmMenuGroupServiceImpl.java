package org.module.service.impl.system.menu;

import org.module.commons.annotation.obj.ObjectExplain;
import org.module.dto.system.menu.SmMenuGroupDto;
import org.module.mapper.system.menu.SmMenuGroupMapper;
import org.module.model.system.menu.SmMenuGroup;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.menu.ISmMenuGroupService;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: SmMenuGroupServiceImpl <br>
 * 描述: 系统菜单组业务逻辑访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2016年12月29日 下午5:48:22
 */
@ObjectExplain(name = "系统菜单组业务逻辑访问接口", description = "对系统菜单组相关业务逻辑操作接口")
@Service
public class SmMenuGroupServiceImpl extends BaseServiceImpl<SmMenuGroup, SmMenuGroupMapper, SmMenuGroupDto>
		implements ISmMenuGroupService {

}
