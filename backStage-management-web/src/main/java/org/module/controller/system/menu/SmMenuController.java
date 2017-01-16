package org.module.controller.system.menu;

import java.util.List;

import org.module.dto.system.menu.SmMenuDto;
import org.module.model.system.menu.SmMenu;
import org.module.model.system.menu.SmMenuGroup;
import org.module.result.EntityResult;
import org.module.result.PageResult;
import org.module.result.RootResult;
import org.module.service.system.menu.ISmMenuService;
import org.module.web.util.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("system/menu/")
public class SmMenuController {

	@Autowired
	private ISmMenuService service;

	/**
	 * 
	 * 方法: index <br>
	 * 描述: 菜单管理列表页 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年1月4日 上午8:53:51
	 * 
	 * @return
	 */
	@RequestMapping(Request.INDEX)
	public String index() {
		return "jsp/system/menu/index";
	}

	/**
	 * 
	 * 方法: data <br>
	 * 描述: ajax分页加载数据 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年1月4日 上午8:57:10
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(Request.DATA)
	@ResponseBody
	public PageResult data(SmMenuDto dto) {
		return service.findEntityToPage(dto);
	}

	/**
	 * 
	 * 方法: addIndex <br>
	 * 描述: 添加页 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年1月4日 上午9:08:27
	 * 
	 * @return
	 */
	@RequestMapping(Request.ADD_INDEX)
	public String addIndex(ModelMap model) {
		List<SmMenuGroup> list = null;
		model.addAttribute("groups", list);
		return "jsp/system/menu/add";
	}

	/**
	 * 
	 * 方法: add <br>
	 * 描述: ajax添加 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年1月4日 上午9:08:35
	 * 
	 * @param entity
	 * @return
	 */
	@RequestMapping(Request.ADD)
	@ResponseBody
	public RootResult add(SmMenu entity) {
		return service.insertSelective(entity);
	}

	/**
	 * 
	 * 方法: editIndex <br>
	 * 描述: 编辑页 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年1月4日 上午9:08:41
	 * 
	 * @return
	 */
	@RequestMapping(Request.EDIT_INDEX)
	public String editIndex(String code, ModelMap model) {
		EntityResult<SmMenu> result = service.selectByCode(code);
		if (result.getCode() == 0) {
			model.addAttribute("menu", result.getEntity());
		}
		return "jsp/system/menu/edit";
	}

	/**
	 * 
	 * 方法: edit <br>
	 * 描述: ajax编辑 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年1月4日 上午9:08:48
	 * 
	 * @param entity
	 * @return
	 */
	@RequestMapping(Request.EDIT)
	@ResponseBody
	public RootResult edit(SmMenu entity) {
		return service.updateByCode(entity);
	}

	/**
	 * 
	 * 方法: del <br>
	 * 描述: ajax删除 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年1月4日 上午9:09:00
	 * 
	 * @param code
	 * @return
	 */
	@RequestMapping(Request.DELETE)
	public RootResult del(String code) {
		return service.deleteByCode(code);
	}
}
