package org.module.service.impl.system;

import org.module.dto.system.SmPagePermissionsDto;
import org.module.mapper.system.SmPagePermissionsMapper;
import org.module.model.system.SmPagePermissions;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.ISmPagePermissionsService;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: SmPagePermissionsServiceImpl <br>
 * 描述: 页面权限表业务逻辑处理接口实习类 <br>
 * 作者: zhy<br>
 * 时间: 2017年10月16日 下午7:16:04
 */
@Service
public class SmPagePermissionsServiceImpl
		extends BaseServiceImpl<SmPagePermissions, SmPagePermissionsMapper, SmPagePermissionsDto>
		implements ISmPagePermissionsService {

}
