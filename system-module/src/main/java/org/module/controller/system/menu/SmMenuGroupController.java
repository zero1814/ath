package org.module.controller.system.menu;

import java.util.ArrayList;

import org.module.commons.helper.CodeHelper;
import org.module.dto.system.menu.SmMenuGroupDto;
import org.module.model.system.menu.SmMenuGroup;
import org.module.result.PageResult;
import org.module.result.RootResult;
import org.module.service.system.menu.ISmMenuGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("system/menugroup/")
public class SmMenuGroupController {

	@Autowired
	private ISmMenuGroupService service;

	@RequestMapping("index")
	public String index() {
		return "jsp/system/menugroup/index";
	}

	@RequestMapping("data")
	@ResponseBody
	public JSONObject data(SmMenuGroupDto dto) {
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
	public RootResult add(SmMenuGroup entity) {
		entity.setCode(CodeHelper.getUniqueCode("SM"));
		entity.setCreateUser("admin");
		return service.insertSelective(entity);
	}

	@RequestMapping("editindex")
	@ResponseBody
	public String editIndex() {
		return null;
	}

	@RequestMapping("edit")
	@ResponseBody
	public RootResult edit(SmMenuGroup entity) {
		entity.setUpdateUser("admin");
		return service.updateByCode(entity);
	}

	@RequestMapping("del")
	@ResponseBody
	public RootResult del(String code) {
		return service.deleteByCode(code);
	}
}
