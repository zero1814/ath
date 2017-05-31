package org.module.service.system.impl.user;

import org.module.dto.system.user.SmRoleDto;
import org.module.mapper.system.user.SmRoleMapper;
import org.module.model.system.user.SmRole;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.user.ISmRoleService;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: SmRoleServiceImpl <br>
 * 描述: 角色业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月31日 上午11:12:20
 */
@Service
public class SmRoleServiceImpl extends BaseServiceImpl<SmRole, SmRoleMapper, SmRoleDto> implements ISmRoleService {

}
