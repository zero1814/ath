package org.module.service.impl.system.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import org.module.dto.system.menu.SmMenuDto;
import org.module.mapper.system.menu.SmMenuGroupMapper;
import org.module.mapper.system.menu.SmMenuMapper;
import org.module.model.TreeModel;
import org.module.model.system.menu.SmMenu;
import org.module.model.system.menu.SmMenuGroup;
import org.module.result.DataResult;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.menu.ISmMenuService;

@Service
public class SmMenuServiceImpl extends BaseServiceImpl<SmMenu, SmMenuMapper, SmMenuDto> implements ISmMenuService {

	@Autowired
	private SmMenuMapper mapper;
	@Autowired
	private SmMenuGroupMapper groupMapper;

	@Override
	public DataResult tree(String groupCode) {
		DataResult result = new DataResult();
		try {
			SmMenuGroup group = groupMapper.selectByCode(groupCode);
			if (group != null) {
				TreeModel root = new TreeModel();
				root.setCode("0");
				root.setText(group.getName());
				root.setNodes(getData("0", groupCode));
				List<TreeModel> list = new ArrayList<TreeModel>();
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
	 * 方法: getMenus <br>
	 * 描述: 获取所有菜单列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月22日 上午10:06:45
	 * 
	 * @param dto
	 * @return
	 */
	private List<TreeModel> getData(String parentCode, String groupCode) {
		// 获取一级菜单
		List<TreeModel> trees = new ArrayList<TreeModel>();
		SmMenuDto dto = new SmMenuDto();
		dto.setParentCode(parentCode);
		dto.setGroupCode(groupCode);
		List<SmMenu> list = mapper.findEntityAllForGroup(dto);
		if (list != null && list.size() > 0) {
			for (SmMenu menu : list) {
				TreeModel tree = new TreeModel();
				tree.setId(menu.getId());
				tree.setCode(menu.getCode());
				tree.setText(menu.getName());
				List<TreeModel> sub = getData(menu.getCode(), groupCode);
				if (sub != null && sub.size() > 0) {
					tree.setNodes(sub);
				}
				trees.add(tree);
			}
		}
		return trees;
	}
}
