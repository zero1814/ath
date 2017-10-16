package org.module.service.impl.system;

import org.module.dto.system.SmRolePermissionsDto;
import org.module.mapper.system.SmRolePermissionsMapper;
import org.module.model.system.SmRolePermissions;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.ISmRolePermissionsService;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: SmRolePermissionsServiceImpl <br>
 * 描述: 角色权限表业务逻辑处理接口实习类 <br>
 * 作者: zhy<br>
 * 时间: 2017年10月16日 下午7:16:34
 */
@Service
public class SmRolePermissionsServiceImpl
		extends BaseServiceImpl<SmRolePermissions, SmRolePermissionsMapper, SmRolePermissionsDto>
		implements ISmRolePermissionsService {

}
