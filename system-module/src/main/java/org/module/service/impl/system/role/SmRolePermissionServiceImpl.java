package org.module.service.impl.system.role;

import org.module.dto.system.role.SmRolePermissionDto;
import org.module.mapper.system.role.SmRolePermissionMapper;
import org.module.model.system.role.SmRolePermission;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.role.ISmRolePermissionService;
import org.springframework.stereotype.Service;

@Service
public class SmRolePermissionServiceImpl
		extends BaseServiceImpl<SmRolePermission, SmRolePermissionMapper, SmRolePermissionDto>
		implements ISmRolePermissionService {

}
