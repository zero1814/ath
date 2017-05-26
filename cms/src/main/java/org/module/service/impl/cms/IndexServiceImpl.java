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
		List<SmMenu> menus = null;
		String groupCode = "SMG1000";
		try {
			menus = getData("0", groupCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menus;
	}

	/**
	 * 
	 * 方法: getMenus <br>
	 * 描述: 获取所有菜单列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月22日 上午10:06:45
	 * 
	 * @param dto
	 * @return
	 */
	private List<SmMenu> getData(String parentCode, String groupCode) {
		// 获取一级菜单
		SmMenuDto dto = new SmMenuDto();
		dto.setParentCode(parentCode);
		dto.setGroupCode(groupCode);
		List<SmMenu> list = menuMapper.findEntityAllForGroup(dto);
		if (list != null && list.size() > 0) {
			for (SmMenu menu : list) {
				List<SmMenu> sub = getData(menu.getCode(), groupCode);
				if (sub != null && sub.size() > 0) {
					menu.setChildMenu(sub);
				}
			}
		}
		return list;
	}
}
