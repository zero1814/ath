package org.module.controller.system.menu;

import java.util.ArrayList;

import org.module.commons.annotation.obj.Object;
import org.module.dto.system.menu.SmMenuDto;
import org.module.model.system.menu.SmMenu;
import org.module.model.system.menu.SmMenuGroup;
import org.module.result.PageResult;
import org.module.result.RootResult;
import org.module.service.system.menu.ISmMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("system/menu/")
@Object(name = "系统菜单控制器", description = "系统菜单前台交互相关操作")
public class SmMenuController {

	@Autowired
	private ISmMenuService service;

	@RequestMapping("index")
	public String index() {
		return "jsp/system/menu/index";
	}

	@RequestMapping("data")
	@ResponseBody
	public JSONObject data(SmMenuDto dto) {
		JSONObject obj = new JSONObject();
		PageResult result = service.findEntityToPage(dto);
		if (result.getCode() == 0) {
			obj.put("rows", result.getData());
			obj.put("total", result.getTotal());
		} else {
			obj.put("rows", new ArrayList<SmMenuGroup>());
			obj.put("total", 0);
		}
		return obj;
	}

	@RequestMapping("addindex")
	public String addIndex() {
		return null;
	}

	@RequestMapping("add")
	@ResponseBody
	public RootResult add(SmMenu entity) {
		return service.insertSelective(entity);
	}

	@RequestMapping("editindex")
	@ResponseBody
	public String editIndex() {
		return null;
	}

	@RequestMapping("edit")
	@ResponseBody
	public RootResult edit(SmMenu entity) {
		return service.updateByCode(entity);
	}

	@RequestMapping("del")
	@ResponseBody
	public RootResult del(String code) {
		return service.deleteByCode(code);
	}
}
