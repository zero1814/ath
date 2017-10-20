package org.module.service.system.impl.menu;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.module.base.result.BaseResult;
import org.module.base.result.TreeResult;
import org.module.base.service.impl.BaseServiceImpl;
import org.module.dto.system.menu.SmMenuDto;
import org.module.helper.CacheHelper;
import org.module.helper.PropHelper;
import org.module.mapper.system.menu.SmMenuMapper;
import org.module.mapper.system.page.SmPageMapper;
import org.module.model.system.menu.SmMenu;
import org.module.model.system.page.SmPage;
import org.module.service.system.menu.ISmMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

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
	@Autowired
	private SmPageMapper pageMapper;

	@Override
	public TreeResult treeData() {
		TreeResult result = new TreeResult();
		try {
			result.setCode(0);
			result.setTreeText(PropHelper.getConfig("system.menu.tree.text"));
			result.setTreeCode("");
			List<SmMenu> list = data("0");
			result.setData(list);
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
	 * 方法: getMenus <br>
	 * 
	 * @return
	 * @see org.module.service.system.menu.ISmMenuService#getMenus()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public TreeResult getMenus() {
		TreeResult result = new TreeResult();
		try {
			String str = new CacheHelper().getValue("menu");
			if (StringUtils.isNotBlank(str)) {
				JSONObject obj = JSON.parseObject(str);
				List<SmMenu> list = obj.toJavaObject(List.class);
				if (list != null && list.size() > 0) {
					result.setData(list);
					result.setCode(1);
					result.setMessage("查询菜单成功");
				} else {
					result.setCode(1);
					result.setMessage("查询菜单成功");
					result = treeData();
				}
			} else {
				result.setCode(1);
				result.setMessage("查询菜单成功");
				result = treeData();
			}
		} catch (Exception e) {
			result.setCode(-1);
			result.setMessage("查询菜单列表报错");
			e.printStackTrace();
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
	private List<SmMenu> data(String parentCode) {
		SmMenuDto dto = new SmMenuDto();
		dto.setParentCode(parentCode);
		List<SmMenu> list = mapper.findDataAll(dto);
		if (list != null && list.size() > 0) {
			for (SmMenu m : list) {
				SmMenuDto sbDto = new SmMenuDto();
				sbDto.setParentCode(m.getCode());
				List<SmMenu> sub = mapper.findDataAll(sbDto);
				if (sub != null && sub.size() > 0) {
					m.setNodes(sub);
				}
			}
		}
		return list;
	}

	@Override
	public BaseResult deleteByCode(String code) {
		BaseResult result = new BaseResult();
		Integer isExistsChild = mapper.isExistsChildMenu(code);
		if (isExistsChild > 0) {
			result.setCode(-1);
			result.setMessage("菜单包含子菜单，请先删除子菜单信息");
		} else {
			result = super.deleteByCode(code);
		}

		return result;
	}

	/**
	 * 
	 * 方法: pages <br>
	 * 
	 * @return
	 * @see org.module.service.system.menu.ISmMenuService#pages()
	 */
	@Override
	public List<SmPage> pages() {
		return pageMapper.findPages(null);
	}
}
