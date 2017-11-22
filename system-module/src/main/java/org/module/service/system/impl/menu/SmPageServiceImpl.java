package org.module.service.system.impl.menu;

import org.module.commons.service.impl.BaseServiceImpl;
import org.module.dto.system.menu.SmPageDto;
import org.module.mapper.system.menu.SmPageMapper;
import org.module.model.system.menu.SmPage;
import org.module.service.system.menu.ISmPageService;
import org.springframework.stereotype.Service;

@Service
public class SmPageServiceImpl extends BaseServiceImpl<SmPage, SmPageMapper, SmPageDto> implements ISmPageService {

}
