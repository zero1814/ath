package org.module.service.impl.cms;

import java.util.ArrayList;
import java.util.List;

import org.module.dto.system.menu.SmMenuDto;
import org.module.mapper.system.menu.SmMenuMapper;
import org.module.model.system.menu.SmMenu;
import org.module.service.cms.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: IndexServiceImpl <br>
 * 描述: 首页相关业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月19日 上午8:29:17
 */
@Service
public class IndexServiceImpl implements IndexService {
	@Autowired
	private SmMenuMapper menuMapper;

	@Override
	public List<SmMenu> initMenus() {
		List<SmMenu> menus = new ArrayList<SmMenu>();
		String groupCode = "SMG1000";
		try {
			SmMenuDto dto = new SmMenuDto();
			dto.setGroupCode(groupCode);
			dto.setParentCode("0");
			menus = menuMapper.findEntityAllForGroup(dto);
			if (menus != null && menus.size() > 0) {
				for (SmMenu smMenu : menus) {
					SmMenuDto subDto = new SmMenuDto();
					subDto.setParentCode(smMenu.getCode());
					subDto.setGroupCode(groupCode);
					List<SmMenu> subMenus = menuMapper.findEntityAllForGroup(subDto);
					if (subMenus != null && subMenus.size() > 0) {
						smMenu.setChildMenu(subMenus);
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menus;
	}

}
