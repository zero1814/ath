package org.module.service.impl.system.role;

import java.util.List;

import org.module.dto.system.menu.SmMenuDto;
import org.module.dto.system.menu.SmMenuGroupDto;
import org.module.dto.system.menu.SmMenuPermissionDto;
import org.module.dto.system.role.SmRolePermissionDto;
import org.module.mapper.system.menu.SmMenuGroupMapper;
import org.module.mapper.system.menu.SmMenuMapper;
import org.module.mapper.system.menu.SmMenuPermissionMapper;
import org.module.mapper.system.role.SmRolePermissionMapper;
import org.module.model.system.menu.SmMenu;
import org.module.model.system.menu.SmMenuGroup;
import org.module.model.system.menu.SmMenuPermission;
import org.module.model.system.role.SmRolePermission;
import org.module.result.PageResult;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.role.ISmRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Service
public class SmRolePermissionServiceImpl
		extends BaseServiceImpl<SmRolePermission, SmRolePermissionMapper, SmRolePermissionDto>
		implements ISmRolePermissionService {

	@Autowired
	private SmMenuGroupMapper menuGroupmapper;
	@Autowired
	private SmMenuMapper menuMapper;
	@Autowired
	private SmMenuPermissionMapper menuPermissionMapper;

	/**
	 * 
	 * 方法: getMenus <br>
	 * 
	 * @return
	 * @see org.module.service.system.role.ISmRolePermissionService#getMenus()
	 */
	@Override
	public JSONArray getMenus() {
		JSONArray array = new JSONArray();
		List<SmMenuGroup> groups = menuGroupmapper.findEntityAll(new SmMenuGroupDto());
		if (!groups.isEmpty()) {
			for (SmMenuGroup group : groups) {
				JSONObject obj = new JSONObject();
				obj.put("text", group.getName());
				SmMenuDto menuDto = new SmMenuDto();
				menuDto.setGroupCode(group.getCode());
				menuDto.setParentCode("0");
				JSONArray menus = getChildMenus(menuDto);
				if (menus != null && menus.size() > 0) {
					obj.put("nodes", menus);
				}
				array.add(obj);
			}
		}
		return array;
	}

	/**
	 * 
	 * 方法: getMenuPermission <br>
	 * 
	 * @param menuCode
	 * @return
	 * @see org.module.service.system.role.ISmRolePermissionService#getMenuPermission(java.lang.String)
	 */
	@Override
	public PageResult getMenuPermission(SmMenuPermissionDto dto) {
		PageResult result = new PageResult();
		dto.setFlagAble(0);
		dto.setStart((dto.getPageNumber() - 1) * dto.getPageSize());
		List<SmMenuPermission> permissions = menuPermissionMapper.findEntityAllToPage(dto);
		if (!permissions.isEmpty()) {
			result.setCode(0);
			result.setRows(permissions);
			Integer total = menuPermissionMapper.findEntityAllCountToPage(dto);
			result.setTotal(total);
			result.setMessage("查询成功");
		} else {
			result.setCode(-1);
			result.setMessage("获取菜单权限列表失败");
		}
		return result;
	}

	/**
	 * 
	 * 方法: getChildMenus <br>
	 * 描述: 递归查询菜单子菜单 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月22日 下午3:38:26
	 * 
	 * @param dto
	 * @return
	 */
	private JSONArray getChildMenus(SmMenuDto dto) {
		JSONArray array = new JSONArray();
		List<SmMenu> menus = menuMapper.findEntityAllForGroup(dto);
		for (SmMenu m : menus) {
			JSONObject obj = new JSONObject();
			obj.put("text", m.getName());
			obj.put("code", m.getCode());
			dto.setParentCode(m.getCode());
			List<SmMenu> childMenus = menuMapper.findEntityAllForGroup(dto);
			if (childMenus.size() > 0) {
				JSONArray childs = new JSONArray();
				for (SmMenu childMenu : childMenus) {
					JSONObject child = new JSONObject();
					child.put("text", childMenu.getName());
					child.put("code", childMenu.getCode());
					childs.add(child);
				}
				obj.put("nodes", childs);
			} else {
				obj.put("nodes", new JSONArray());
				continue;
			}
			array.add(obj);
		}
		return array;
	}
}
