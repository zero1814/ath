package org.module.service.impl.system.page;

import org.module.dto.system.page.SmButtonAreaDto;
import org.module.mapper.system.page.SmButtonAreaMapper;
import org.module.model.system.page.SmButtonArea;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.page.ISmButtonAreaService;
import org.springframework.stereotype.Service;

@Service
public class SmButtonAreaServiceImpl extends BaseServiceImpl<SmButtonArea, SmButtonAreaMapper, SmButtonAreaDto>
		implements ISmButtonAreaService {

}
