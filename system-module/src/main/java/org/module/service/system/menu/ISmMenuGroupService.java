package org.module.service.system.menu;

import org.module.dto.system.menu.SmMenuGroupDto;
import org.module.model.system.menu.SmMenuGroup;
import org.module.result.DataResult;
import org.module.service.IBaseService;

public interface ISmMenuGroupService extends IBaseService<SmMenuGroup, SmMenuGroupDto> {
	DataResult findDataAll();
}
