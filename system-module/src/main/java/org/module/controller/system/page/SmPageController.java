package org.module.controller.system.page;

import org.module.helper.commons.CodeHelper;
import org.module.model.system.page.SmPage;
import org.module.result.EntityResult;
import org.module.result.BaseResult;
import org.module.result.TreeResult;
import org.module.service.system.page.ISmPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("system/page/")
public class SmPageController {

	@Autowired
	private ISmPageService service;

	@RequestMapping("index")
	public String index(String groupCode, ModelMap model) {
		model.addAttribute("groupCode", groupCode);
		return "jsp/system/page/index";
	}

	@RequestMapping("tree")
	@ResponseBody
	public TreeResult data(String groupCode) {
		return service.treeData(groupCode);
	}

	@RequestMapping("detail")
	public String detal(String code, ModelMap model) {
		EntityResult result = service.selectByCode(code);
		if (result.getCode() == 0) {
			model.addAttribute("page", result.getEntity());
		}
		return "jsp/system/page/detail";
	}

	@RequestMapping("addindex")
	public String addIndex(String code, String group, ModelMap model) {
		model.addAttribute("parentCode", code);
		model.addAttribute("groupCode", group);
		return "jsp/system/page/add";
	}

	@RequestMapping("add")
	@ResponseBody
	public EntityResult add(SmPage entity) {
		entity.setCreateUser("test");
		entity.setCode(CodeHelper.getUniqueCode("SP"));
		return service.insertSelective(entity);
	}

	@RequestMapping("editindex")
	public String editIndex(String code, ModelMap model) {
		EntityResult result = service.selectByCode(code);
		if (result.getCode() == 0) {
			model.addAttribute("page", result.getEntity());
		}
		return "jsp/system/page/edit";
	}

	@RequestMapping("edit")
	@ResponseBody
	public EntityResult edit(SmPage entity) {
		entity.setUpdateUser("test");
		return service.updateByCode(entity);
	}

	@RequestMapping("del")
	@ResponseBody
	public BaseResult del(String code) {
		return service.deleteByCode(code);
	}
}
