package org.module.service.system.impl.menu;

import java.util.List;

import org.module.dto.system.menu.SmMenuDto;
import org.module.mapper.system.menu.SmMenuMapper;
import org.module.model.system.menu.SmMenu;
import org.module.result.DataResult;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.menu.ISmMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: SmMenuServiceImpl <br>
 * 描述: 菜单业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月31日 上午11:11:28
 */
@Service
public class SmMenuServiceImpl extends BaseServiceImpl<SmMenu, SmMenuMapper, SmMenuDto> implements ISmMenuService {

	@Autowired
	private SmMenuMapper mapper;

	@Override
	public DataResult treeData(String groupCode) {
		DataResult result = new DataResult();
		try {
			result.setCode(0);
			result.setData(data("0", groupCode));
			result.setMessage("查询菜单成功");
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
