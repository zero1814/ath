package org.module.service.impl.user;

import org.module.dto.UmCompanyDto;
import org.module.mapper.user.UmCompanyMapper;
import org.module.model.user.UmCompany;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.user.IUmCompanyService;
import org.springframework.stereotype.Service;

@Service
public class UmCompanyServiceImpl extends BaseServiceImpl<UmCompany, UmCompanyMapper, UmCompanyDto>
		implements IUmCompanyService {

}
