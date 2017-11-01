package org.module.service.system.impl.menu;

import org.module.base.service.impl.BaseServiceImpl;
import org.module.dto.system.menu.SmMenuGroupDto;
import org.module.mapper.system.menu.SmMenuGroupMapper;
import org.module.model.system.menu.SmMenuGroup;
import org.module.service.system.menu.ISmMenuGroupService;
import org.springframework.stereotype.Service;

@Service
public class SmMenuGroupServiceImpl extends BaseServiceImpl<SmMenuGroup, SmMenuGroupMapper, SmMenuGroupDto>
		implements ISmMenuGroupService {

}
