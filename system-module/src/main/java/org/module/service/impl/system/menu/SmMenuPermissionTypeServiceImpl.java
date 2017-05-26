package org.module.service.impl.system.menu;

import org.module.dto.system.menu.SmMenuPermissionTypeDto;
import org.module.mapper.system.menu.SmMenuPermissionTypeMapper;
import org.module.model.system.menu.SmMenuPermissionType;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.menu.ISmMenuPermissionTypeService;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: SmMenuPermissionTypeServiceImpl <br>
 * 描述: 菜单权限类型表业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月26日 上午10:06:08
 */
@Service
public class SmMenuPermissionTypeServiceImpl
		extends BaseServiceImpl<SmMenuPermissionType, SmMenuPermissionTypeMapper, SmMenuPermissionTypeDto>
		implements ISmMenuPermissionTypeService {

}
