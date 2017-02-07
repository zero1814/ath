package org.module.service.impl.system.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.module.dto.system.menu.SmMenuDto;
import org.module.dto.system.menu.SmMenuGroupDto;
import org.module.mapper.system.menu.SmMenuGroupMapper;
import org.module.mapper.system.menu.SmMenuMapper;
import org.module.model.system.menu.SmMenu;
import org.module.model.system.menu.SmMenuGroup;
import org.module.result.DataResult;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.menu.ISmMenuGroupService;

@Service
public class SmMenuGroupServiceImpl extends BaseServiceImpl<SmMenuGroup, SmMenuGroupMapper, SmMenuGroupDto>
		implements ISmMenuGroupService {

	@Autowired
	private SmMenuGroupMapper mapper;
	@Autowired
	private SmMenuMapper menuMapper;

	@Override
	public DataResult findDataAll() {
		DataResult result = new DataResult();
		List<SmMenuGroup> groups = mapper.findEntityAll(new SmMenuGroupDto());
		if (groups != null && groups.size() > 0) {
			for (SmMenuGroup group : groups) {
				SmMenuDto menuDto = new SmMenuDto();
				menuDto.setGroupCode(group.getCode());
				List<SmMenu> menus = menuMapper.findEntityAllForGroup(menuDto);
				if (menus != null && menus.size() > 0) {
					group.setMenus(menus);
				}
			}
			result.setData(groups);
		} else {
			result.setCode(-1);
			result.setMessage("系统菜单组为空");
		}
		return result;
	}
}
