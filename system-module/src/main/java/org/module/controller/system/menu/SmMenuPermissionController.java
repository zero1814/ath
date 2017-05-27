package org.module.controller.system.menu;

import org.module.dto.system.menu.SmMenuPermissionDto;
import org.module.helper.commons.CodeHelper;
import org.module.model.system.menu.SmMenuPermission;
import org.module.result.EntityResult;
import org.module.result.PageResult;
import org.module.result.RootResult;
import org.module.service.system.menu.ISmMenuPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("system/menu/permission/")
public class SmMenuPermissionController {

	@Autowired
	private ISmMenuPermissionService service;

	@RequestMapping("index")
	public String index(ModelMap model, String menuCode) {
		model.addAttribute("menuCode", menuCode);
		model.addAttribute("permissionType", service.getMenuPermissionType());
		return "jsp/system/menu/permission";
	}

	@RequestMapping("data")
	@ResponseBody
	public PageResult data(SmMenuPermissionDto dto) {
		PageResult result = service.findEntityToPage(dto);
		System.out.println("result:" + JSON.toJSON(result));
		return result;
	}

	@RequestMapping("addindex")
	public String addIndex(String menuCode, ModelMap model) {
		model.addAttribute("menuCode", menuCode);
		model.addAttribute("types", service.getMenuPermissionType());
		return "jsp/system/menu/permission/add";
	}

	@RequestMapping("add")
	@ResponseBody
	public RootResult add(SmMenuPermission entity) {
		entity.setCode(CodeHelper.getUniqueCode("SMP"));
		entity.setCreateUser("admin");
		return service.insertSelective(entity);
	}

	@RequestMapping("editindex")
	public String editIndex(String code, ModelMap model) {
		model.addAttribute("permission", service.selectByCode(code).getEntity());
		model.addAttribute("types", service.getMenuPermissionType());
		return "jsp/system/menu/permission/edit";
	}

	@RequestMapping("edit")
	@ResponseBody
	public RootResult edit(SmMenuPermission entity) {
		entity.setUpdateUser("admin");
		return service.updateByCode(entity);
	}

	@RequestMapping("del")
	@ResponseBody
	public RootResult del(String code) {
		return service.deleteByCode(code);
	}

	@RequestMapping("detail")
	@ResponseBody
	public EntityResult detail(String code) {
		return service.selectByCode(code);
	}
}
