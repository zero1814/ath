package org.module.service.system.impl.menu;

import org.module.base.service.impl.BaseServiceImpl;
import org.module.dto.system.menu.SmMenuDto;
import org.module.mapper.system.menu.SmMenuMapper;
import org.module.model.system.menu.SmMenu;
import org.module.service.system.menu.ISmMenuService;
import org.springframework.stereotype.Service;

@Service
public class SmMenuServiceImpl extends BaseServiceImpl<SmMenu, SmMenuMapper, SmMenuDto> implements ISmMenuService {

}
