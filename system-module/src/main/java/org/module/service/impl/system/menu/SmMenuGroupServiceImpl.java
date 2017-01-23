package org.module.service.impl.system.menu;

import java.util.List;

import org.module.commons.annotation.obj.ObjectExplain;
import org.module.dto.system.menu.SmMenuDto;
import org.module.dto.system.menu.SmMenuGroupDto;
import org.module.mapper.system.menu.SmMenuGroupMapper;
import org.module.mapper.system.menu.SmMenuMapper;
import org.module.model.system.menu.SmMenu;
import org.module.model.system.menu.SmMenuGroup;
import org.module.result.DataResult;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.menu.ISmMenuGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 
 * 类: SmMenuGroupServiceImpl <br>
 * 描述: 系统菜单组业务逻辑访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2016年12月29日 下午5:48:22
 */
@ObjectExplain(name = "系统菜单组业务逻辑访问接口", description = "对系统菜单组相关业务逻辑操作接口")
@Service
public class SmMenuGroupServiceImpl extends BaseServiceImpl<SmMenuGroup, SmMenuGroupMapper, SmMenuGroupDto>
		implements ISmMenuGroupService {

	@Autowired
	private SmMenuGroupMapper mapper;
	@Autowired
	private SmMenuMapper menuMapper;

	@Override
	public DataResult getMenuData(String userCode) {
		DataResult result = new DataResult();
		List<SmMenuGroup> list = mapper.findEntityAll(null);
		if (list != null) {
			for (SmMenuGroup group : list) {
				SmMenuDto menuDto = new SmMenuDto();
				menuDto.setGroupCode(group.getCode());
				menuDto.setParentCode("0");
				List<SmMenu> menus = menuMapper.findEntityAll(menuDto);
				if (menus != null && menus.size() > 0) {
					for (SmMenu menu : menus) {
						SmMenuDto childMenuDto = new SmMenuDto();
						childMenuDto.setParentCode(menu.getCode());
						childMenuDto.setGroupCode(group.getCode());
						List<SmMenu> childMenus = menuMapper.findEntityAll(childMenuDto);
						if (childMenus != null && childMenus.size() > 0) {
							menu.setChildMenu(childMenus);
						}
					}
				}
				group.setMenus(menus);
			}
		}
		result.setData(list);
		return result;
	}

}
