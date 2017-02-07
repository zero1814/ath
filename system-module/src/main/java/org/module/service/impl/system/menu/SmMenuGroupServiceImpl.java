package org.module.service.impl.system.menu;

import org.springframework.stereotype.Service;
import org.module.dto.system.menu.SmMenuGroupDto;
import org.module.mapper.system.menu.SmMenuGroupMapper;
import org.module.model.system.menu.SmMenuGroup;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.menu.ISmMenuGroupService;

@Service
public class SmMenuGroupServiceImpl extends BaseServiceImpl<SmMenuGroup, SmMenuGroupMapper, SmMenuGroupDto>
		implements ISmMenuGroupService {

}
