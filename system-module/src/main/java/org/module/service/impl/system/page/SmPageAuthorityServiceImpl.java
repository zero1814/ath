package org.module.service.impl.system.page;

import org.module.dto.system.page.SmPageAuthorityDto;
import org.module.mapper.system.page.SmPageAuthorityMapper;
import org.module.model.system.page.SmPageAuthority;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.page.ISmPageAuthorityService;
import org.springframework.stereotype.Service;

@Service
public class SmPageAuthorityServiceImpl extends
		BaseServiceImpl<SmPageAuthority, SmPageAuthorityMapper, SmPageAuthorityDto> implements ISmPageAuthorityService {

}
