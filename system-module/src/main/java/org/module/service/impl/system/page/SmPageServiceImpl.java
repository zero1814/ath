package org.module.service.impl.system.page;

import org.module.dto.system.page.SmPageDto;
import org.module.mapper.system.page.SmPageMapper;
import org.module.model.system.page.SmPage;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.page.ISmPageService;
import org.springframework.stereotype.Service;

@Service
public class SmPageServiceImpl extends BaseServiceImpl<SmPage, SmPageMapper, SmPageDto> implements ISmPageService {

}
