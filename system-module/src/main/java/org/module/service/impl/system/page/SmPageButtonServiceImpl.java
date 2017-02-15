package org.module.service.impl.system.page;

import org.module.dto.system.page.SmPageButtonDto;
import org.module.mapper.system.page.SmPageButtonMapper;
import org.module.model.system.page.SmPageButton;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.page.ISmPageButtonService;
import org.springframework.stereotype.Service;

@Service
public class SmPageButtonServiceImpl extends BaseServiceImpl<SmPageButton, SmPageButtonMapper, SmPageButtonDto>
		implements ISmPageButtonService {

}
