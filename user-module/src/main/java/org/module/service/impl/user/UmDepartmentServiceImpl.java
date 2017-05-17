package org.module.service.impl.user;

import org.module.dto.UmDepartmentDto;
import org.module.mapper.user.UmDepartmentMapper;
import org.module.model.user.UmDepartment;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.user.IUmDepartmentService;
import org.springframework.stereotype.Service;

@Service
public class UmDepartmentServiceImpl extends BaseServiceImpl<UmDepartment, UmDepartmentMapper, UmDepartmentDto>
		implements IUmDepartmentService {

}
