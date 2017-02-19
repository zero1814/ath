package org.module.service.impl.system.menu;

import org.springframework.stereotype.Service;

import org.module.dto.system.menu.SmMenuDto;
import org.module.mapper.system.menu.SmMenuMapper;
import org.module.model.system.menu.SmMenu;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.menu.ISmMenuService;

@Service
public class SmMenuServiceImpl extends BaseServiceImpl<SmMenu, SmMenuMapper, SmMenuDto> implements ISmMenuService {

}
