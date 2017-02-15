package org.module.service.impl.system.page;

import org.module.dto.system.page.SmButtonStyleDto;
import org.module.mapper.system.page.SmButtonStyleMapper;
import org.module.model.system.page.SmButtonStyle;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.page.ISmButtonStyleService;
import org.springframework.stereotype.Service;

@Service
public class SmButtonStyleServiceImpl extends BaseServiceImpl<SmButtonStyle, SmButtonStyleMapper, SmButtonStyleDto>
		implements ISmButtonStyleService {

}
