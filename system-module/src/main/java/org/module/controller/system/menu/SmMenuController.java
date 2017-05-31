package org.module.controller.system.menu;

import org.module.dto.system.menu.SmMenuDto;
import org.module.model.system.menu.SmMenu;
import org.module.result.EntityResult;
import org.module.result.PageResult;
import org.module.result.RootResult;
import org.module.service.system.menu.ISmMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * 类: SmMenuController <br>
 * 描述: 菜单 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月31日 下午3:19:36
 */
@Controller
@RequestMapping("system/menu/")
public class SmMenuController {

	@Autowired
	private ISmMenuService service;

	@RequestMapping("index")
	public String index() {
		return "";
	}

	@RequestMapping("data")
	@ResponseBody
	public PageResult data(SmMenuDto dto) {
		return service.findEntityToPage(dto);
	}

	@RequestMapping("add")
	@ResponseBody
	public EntityResult add(SmMenu entity) {
		entity.setCreateUser("insert");
		return service.insertSelective(entity);
	}

	@RequestMapping("edit")
	@ResponseBody
	public EntityResult edit(SmMenu entity) {
		entity.setUpdateUser("update");
		return service.updateByCode(entity);
	}

	@RequestMapping("del")
	@ResponseBody
	public RootResult del(String code) {
		return service.deleteByCode(code);
	}
}
