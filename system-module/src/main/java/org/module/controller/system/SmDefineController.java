package org.module.controller.system;

import org.module.helper.commons.CodeHelper;
import org.module.model.system.SmDefine;
import org.module.result.DataResult;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.system.ISmDefineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("system/define/")
public class SmDefineController {

	@Autowired
	private ISmDefineService service;

	@RequestMapping("index")
	public String index() {
		return "jsp/system/define/index";
	}

	@RequestMapping("data")
	@ResponseBody
	public DataResult data() {
		return service.treeData();
	}

	@RequestMapping("detail")
	public String detail(String code, ModelMap model) {
		EntityResult result = service.selectByCode(code);
		if (result.getCode() == 0) {
			model.addAttribute("define", result.getEntity());
		}
		return "jsp/system/define/detail";
	}

	@RequestMapping("add")
	@ResponseBody
	public EntityResult add(SmDefine entity) {
		entity.setCode(CodeHelper.getUniqueCode("SD"));
		entity.setCreateUser("test");
		return service.insertSelective(entity);
	}

	@RequestMapping("del")
	@ResponseBody
	public RootResult del(String code) {
		return service.deleteByCode(code);
	}

	@RequestMapping("edit")
	@ResponseBody
	public EntityResult edit(SmDefine entity) {
		entity.setUpdateUser("test");
		return service.updateByCode(entity);

	}
}
