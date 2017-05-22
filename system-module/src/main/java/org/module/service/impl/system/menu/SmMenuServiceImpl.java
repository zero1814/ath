package org.module.service.impl.system.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.module.dto.system.menu.SmMenuDto;
import org.module.mapper.system.menu.SmMenuMapper;
import org.module.model.system.menu.SmMenu;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.menu.ISmMenuService;

@Service
public class SmMenuServiceImpl extends BaseServiceImpl<SmMenu, SmMenuMapper, SmMenuDto> implements ISmMenuService {

	@Autowired
	private SmMenuMapper mapper;

	@Override
	public List<SmMenu> menus(String groupCode) {
		SmMenuDto dto = new SmMenuDto();
		dto.setGroupCode(groupCode);
		dto.setParentCode("0");
		return getMenus(dto);
	}
	
	

	/**
	 * 
	 * 方法: getMenus <br>
	 * 描述: 获取所有菜单列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月22日 上午10:06:45
	 * @param dto
	 * @return
	 */
	private List<SmMenu> getMenus(SmMenuDto dto) {
		// 获取一级菜单
		List<SmMenu> list = mapper.findEntityAllForGroup(dto);
		if (list != null && list.size() > 0) {
			for (SmMenu menu : list) {
				SmMenuDto subDto = new SmMenuDto();
				subDto.setGroupCode(dto.getGroupCode());
				subDto.setParentCode(menu.getCode());
				// 获取子级菜单
				List<SmMenu> subMenus = getMenus(subDto);
				if (subMenus != null && subMenus.size() > 0) {
					menu.setChildMenu(subMenus);
				}
			}
		}
		return list;
	}
}
