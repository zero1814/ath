package org.module.service.impl.system.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.module.dto.system.menu.SmMenuDto;
import org.module.mapper.system.menu.SmMenuMapper;
import org.module.model.system.menu.SmMenu;
import org.module.result.DataResult;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.menu.ISmMenuService;

@Service
public class SmMenuServiceImpl extends BaseServiceImpl<SmMenu, SmMenuMapper, SmMenuDto> implements ISmMenuService {

	@Autowired
	private SmMenuMapper mapper;

	@Override
	public DataResult menus(String groupCode) {
		DataResult result = new DataResult();
		try {
			SmMenuDto dto = new SmMenuDto();
			dto.setGroupCode(groupCode);
			List<SmMenu> menus = mapper.findEntityAll(dto);
			if (menus != null && menus.size() > 0) {
				for (SmMenu smMenu : menus) {
					SmMenuDto subDto = new SmMenuDto();
					subDto.setParentCode(smMenu.getCode());
					subDto.setGroupCode(groupCode);
					List<SmMenu> subMenus = mapper.findEntityAll(subDto);
					if (subMenus != null && subMenus.size() > 0) {
						smMenu.setChildMenu(subMenus);
					}
				}
				result.setData(menus);
				result.setCode(0);
				result.setMessage("获取菜单列表成功");
			} else {
				result.setCode(-1);
				result.setMessage("获取菜单列表为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(-1);
			result.setMessage("获取菜单列表失败，失败原因：" + e.getMessage());
		}
		return result;
	}

}
