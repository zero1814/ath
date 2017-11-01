package org.module.mapper.system.menu;

import java.util.List;

import org.module.base.mapper.BaseMapper;
import org.module.dto.system.menu.SmMenuDto;
import org.module.model.system.menu.SmMenu;

public interface SmMenuMapper extends BaseMapper<SmMenu, SmMenuDto> {

	List<SmMenu> findDataAll(SmMenuDto dto);
}
