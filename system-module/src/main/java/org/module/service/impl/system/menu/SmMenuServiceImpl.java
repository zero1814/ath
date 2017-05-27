package org.module.service.impl.system.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import org.module.dto.system.menu.SmMenuDto;
import org.module.mapper.system.menu.SmMenuGroupMapper;
import org.module.mapper.system.menu.SmMenuMapper;
import org.module.mapper.system.menu.SmMenuPermissionMapper;
import org.module.model.system.menu.SmMenu;
import org.module.model.system.menu.SmMenuGroup;
import org.module.model.system.menu.SmMenuPermission;
import org.module.result.DataResult;
import org.module.result.RootResult;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.menu.ISmMenuService;

@Service
public class SmMenuServiceImpl extends BaseServiceImpl<SmMenu, SmMenuMapper, SmMenuDto> implements ISmMenuService {

	@Autowired
	private SmMenuMapper mapper;
	@Autowired
	private SmMenuGroupMapper groupMapper;
	@Autowired
	private SmMenuPermissionMapper permissionMapper;

	/**
	 * 
	 * 方法: tree <br>
	 * 
	 * @param groupCode
	 * @return
	 * @see org.module.service.system.menu.ISmMenuService#tree(java.lang.String)
	 */
	@Override
	public DataResult tree(String groupCode) {
		DataResult result = new DataResult();
		try {
			SmMenuGroup group = groupMapper.selectByCode(groupCode);
			if (group != null) {
				SmMenu root = new SmMenu();
				root.setCode("0");
				root.setText(group.getName());
				root.setNodes(getTreeData("0", groupCode));
				root.setGroupCode(group.getCode());
				List<SmMenu> list = new ArrayList<SmMenu>();
				list.add(root);
				result.setData(list);
				result.setCode(0);
				result.setMessage("查询成功");
			} else {
				result.setCode(-1);
				result.setMessage("查询菜单组为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(-1);
			result.setMessage("获取菜单列表失败，失败原因:" + e.getMessage());
		}
		return result;
	}

	/**
	 * 
	 * 方法: deleteByCode <br>
	 * 
	 * @param code
	 * @return
	 * @see org.module.service.impl.BaseServiceImpl#deleteByCode(java.lang.String)
	 */
	@Override
	public RootResult deleteByCode(String code) {
		RootResult result = new RootResult();
		Integer exists = mapper.findExistsSubMenus(code);
		if (exists > 0) {
			result.setCode(-1);
			result.setMessage("菜单包含子级菜单，请先删除子级菜单");
		} else {
			result = super.deleteByCode(code);
		}
		return result;
	}

	/**
	 * 
	 * 方法: menus <br>
	 * 
	 * @param groupCode
	 * @return
	 * @see org.module.service.system.menu.ISmMenuService#menus(java.lang.String)
	 */
	@Override
	public DataResult menus(String groupCode) {
		DataResult result = new DataResult();
		try {
			List<SmMenu> list = getData("0", groupCode);
			if (list != null && list.size() > 0) {
				result.setData(list);
				result.setCode(0);
				result.setMessage("获取菜单列表成功");
			} else {
				result.setCode(-1);
				result.setMessage("获取菜单列表为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(-1);
			result.setMessage("获取菜单列表失败，失败原因:" + e.getMessage());
		}
		return result;
	}

	/**
	 * 
	 * 方法: menusPermission <br>
	 * 
	 * @param menuCode
	 * @return
	 * @see org.module.service.system.menu.ISmMenuService#menusPermission(java.lang.String)
	 */
	@Override
	public DataResult menusPermission(String menuCode) {
		DataResult result = new DataResult();
		try {
			List<SmMenuPermission> list = permissionMapper.findMenuPermissionByMenuCode(menuCode);
			if (list != null && list.size() > 0) {
				result.setData(list);
				result.setCode(0);
				result.setMessage("查询成功");
			} else {
				result.setData(new ArrayList<SmMenuPermission>());
				result.setCode(-1);
				result.setMessage("菜单暂无权限");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.logError("获取菜单编码为" + menuCode + "的权限列表失败，失败原因：" + e.getMessage());
		}
		return result;
	}

	/**
	 * 
	 * 方法: getMenus <br>
	 * 描述: 递归获取菜单列表-树型显示 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月22日 上午10:06:45
	 * 
	 * @param dto
	 * @return
	 */
	private List<SmMenu> getTreeData(String parentCode, String groupCode) {
		// 获取一级菜单
		List<SmMenu> trees = new ArrayList<SmMenu>();
		SmMenuDto dto = new SmMenuDto();
		dto.setParentCode(parentCode);
		dto.setGroupCode(groupCode);
		List<SmMenu> list = mapper.findEntityAllForGroup(dto);
		if (list != null && list.size() > 0) {
			for (SmMenu menu : list) {
				SmMenu tree = new SmMenu();
				tree.setId(menu.getId());
				tree.setCode(menu.getCode());
				tree.setText(menu.getName());
				List<SmMenu> sub = getTreeData(menu.getCode(), groupCode);
				if (sub != null && sub.size() > 0) {
					tree.setNodes(sub);
				}
				trees.add(tree);
			}
		}
		return trees;
	}

	/**
	 * 
	 * 方法: getData <br>
	 * 描述: 递归获取菜单列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月26日 下午3:08:49
	 * 
	 * @return
	 */
	private List<SmMenu> getData(String parentCode, String groupCode) {
		SmMenuDto dto = new SmMenuDto();
		dto.setParentCode(parentCode);
		dto.setGroupCode(groupCode);
		List<SmMenu> menus = mapper.findEntityAllForGroup(dto);
		if (menus != null && menus.size() > 0) {
			for (SmMenu menu : menus) {
				List<SmMenu> sub = getTreeData(menu.getCode(), groupCode);
				if (sub != null && sub.size() > 0) {
					menu.setChildMenu(sub);
				}
			}
		}
		return menus;
	}
}
