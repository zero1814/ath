package org.module.service.system.impl.user;

import java.util.Set;

import org.module.base.service.impl.BaseServiceImpl;
import org.module.dto.system.user.SmRoleDto;
import org.module.mapper.system.user.SmRoleMapper;
import org.module.model.system.user.SmRole;
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

	@Override
	public Set<String> findRoleByUserCode(String userCode) {
		return null;
	}

}
