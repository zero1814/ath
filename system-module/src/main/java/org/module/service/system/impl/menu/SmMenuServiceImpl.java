package org.module.service.system.impl.menu;

import java.util.List;

import org.module.base.result.TreeResult;
import org.module.base.service.impl.BaseServiceImpl;
import org.module.dto.system.menu.SmMenuDto;
import org.module.mapper.system.menu.SmMenuGroupMapper;
import org.module.mapper.system.menu.SmMenuMapper;
import org.module.model.system.menu.SmMenu;
import org.module.model.system.menu.SmMenuGroup;
import org.module.service.system.menu.ISmMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmMenuServiceImpl extends BaseServiceImpl<SmMenu, SmMenuMapper, SmMenuDto> implements ISmMenuService {

	@Autowired
	private SmMenuMapper mapper;
	@Autowired
	private SmMenuGroupMapper groupMapper;

	@Override
	public TreeResult tree(String groupCode) {
		TreeResult result = new TreeResult();
		try {
			SmMenuGroup group = groupMapper.selectByCode(groupCode);
			if (group != null) {
				result.setCode(0);
				result.setTreeText(group.getName());
				result.setTreeCode(group.getCode());
				List<SmMenu> list = data("0", groupCode);
				result.setData(list);
				result.setMessage("查询菜单成功");
			} else {
				result.setCode(-1);
				result.setMessage("菜单组下菜单信息为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(-1);
			result.setMessage("查询菜单失败，失败原因:" + e.getMessage());
		}
		return result;
	}

	/**
	 * 
	 * 方法: data <br>
	 * 描述: 根据菜单分组编码和父级编码查询菜单列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月1日 上午10:47:22
	 * 
	 * @param parentCode
	 * @param groupCode
	 * @return
	 */
	private List<SmMenu> data(String parentCode, String groupCode) {
		SmMenuDto dto = new SmMenuDto();
		dto.setGroupCode(groupCode);
		dto.setParentCode(parentCode);
		List<SmMenu> list = mapper.findDataAll(dto);
		if (list != null && list.size() > 0) {
			for (SmMenu m : list) {
				SmMenuDto sbDto = new SmMenuDto();
				sbDto.setGroupCode(groupCode);
				sbDto.setParentCode(m.getCode());
				List<SmMenu> sub = mapper.findDataAll(sbDto);
				if (sub != null && sub.size() > 0) {
					m.setNodes(sub);
				}
			}
		}
		return list;
	}
}
