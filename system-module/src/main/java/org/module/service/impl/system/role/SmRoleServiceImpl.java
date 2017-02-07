package org.module.service.impl.system.role;

import org.springframework.stereotype.Service;
import org.module.dto.system.role.SmRoleDto;
import org.module.mapper.system.role.SmRoleMapper;
import org.module.model.system.role.SmRole;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.role.ISmRoleService;

@Service
public class SmRoleServiceImpl extends BaseServiceImpl<SmRole, SmRoleMapper, SmRoleDto> implements ISmRoleService {

}
