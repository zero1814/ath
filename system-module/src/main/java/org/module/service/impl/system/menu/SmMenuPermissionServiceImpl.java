package org.module.service.impl.system.menu;

import org.springframework.stereotype.Service;
import org.module.dto.system.menu.SmMenuPermissionDto;
import org.module.mapper.system.menu.SmMenuPermissionMapper;
import org.module.model.system.menu.SmMenuPermission;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.menu.ISmMenuPermissionService;

@Service
public class SmMenuPermissionServiceImpl
		extends BaseServiceImpl<SmMenuPermission, SmMenuPermissionMapper, SmMenuPermissionDto>
		implements ISmMenuPermissionService {

}
