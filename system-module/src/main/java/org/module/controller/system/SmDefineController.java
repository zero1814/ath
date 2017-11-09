package org.module.controller.system;

import org.module.base.result.EntityResult;
import org.module.base.result.TreeResult;
import org.module.controller.BaseController;
import org.module.helper.CodeHelper;
import org.module.helper.PropHelper;
import org.module.model.system.SmDefine;
import org.module.service.system.ISmDefineService;
import org.module.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("system/define/")
public class SmDefineController extends BaseController{

	@Autowired
	private ISmDefineService service;

	@RequestMapping("index")
	public String index() {
		return "";
	}

	@RequestMapping("tree")
	@ResponseBody
	public TreeResult tree() {
		return service.tree();
	}

	@RequestMapping("addindex")
	public String addIndex() {
		return "";
	}

	@RequestMapping("add")
	@ResponseBody
	public EntityResult add(SmDefine entity) {
		String code = CodeHelper.getCode(PropHelper.getConfig("system.define.code_prefix"));
		entity.setCode(code);
		return service.insertSelective(entity);
	}

	@RequestMapping
	public String editIndex(String code, ModelMap model) {
		EntityResult result = service.selectByCode(code);
		if (result.getCode() == Constant.RESULT_SUCCESS) {
			model.addAttribute("entity", result.getEntity());
			return "";
		} else if(result.getCode() == Constant.RESULT_NULL) {
			return NULL_URL;
		}else {
			return ERROR_URL;
		}

	}

	@RequestMapping("edit")
	@ResponseBody
	public EntityResult edit(SmDefine entity) {
		return service.updateByCode(entity);
	}

	@RequestMapping("sel")
	@ResponseBody
	public EntityResult sel(String code) {
		return service.selectByCode(code);
	}
}
