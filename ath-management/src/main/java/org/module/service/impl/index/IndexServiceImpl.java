package org.module.service.impl.index;

import java.util.List;

import org.module.dto.system.menu.SmMenuDto;
import org.module.dto.system.menu.SmMenuGroupDto;
import org.module.mapper.system.menu.SmMenuGroupMapper;
import org.module.mapper.system.menu.SmMenuMapper;
import org.module.model.system.menu.SmMenu;
import org.module.model.system.menu.SmMenuGroup;
import org.module.service.index.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: IndexServiceImpl <br>
 * 描述: 首页相关业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年2月7日 下午10:19:14
 */
@Service
public class IndexServiceImpl implements IndexService {

	@Autowired
	private SmMenuGroupMapper menuGroupMapper;
	@Autowired
	private SmMenuMapper menuMapper;

	@Override
	public List<SmMenuGroup> getMenus() {
		List<SmMenuGroup> groups = menuGroupMapper.findEntityAll(new SmMenuGroupDto());
		if (groups != null && groups.size() > 0) {
			for (SmMenuGroup group : groups) {
				SmMenuDto menuDto = new SmMenuDto();
				menuDto.setGroupCode(group.getCode());
				menuDto.setParentCode("0");
				List<SmMenu> menus = menuMapper.findEntityAllForGroup(menuDto);
				if (menus != null && menus.size() > 0) {
					for (SmMenu smMenu : menus) {
						menuDto.setParentCode(smMenu.getCode());
						List<SmMenu> childMenus = menuMapper.findEntityAllForGroup(menuDto);
						if (childMenus != null && childMenus.size() > 0) {
							smMenu.setChildMenu(childMenus);
						}
					}
					group.setMenus(menus);
				}
			}
		}
		return groups;
	}

}
