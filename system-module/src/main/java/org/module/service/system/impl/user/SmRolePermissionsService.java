package org.module.service.system.impl.user;

import org.module.commons.service.impl.BaseServiceImpl;
import org.module.dto.system.user.SmRolePermissionsDto;
import org.module.mapper.system.user.SmRolePermissionsMapper;
import org.module.model.system.user.SmRolePermissions;
import org.module.service.system.user.ISmRolePermissionsService;
import org.springframework.stereotype.Service;

@Service
public class SmRolePermissionsService
		extends BaseServiceImpl<SmRolePermissions, SmRolePermissionsMapper, SmRolePermissionsDto>
		implements ISmRolePermissionsService {

}
