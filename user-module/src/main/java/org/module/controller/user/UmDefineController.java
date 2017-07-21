package org.module.controller.user;

import org.module.model.user.UmDefine;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.result.TreeResult;
import org.module.service.user.IUmDefineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user/define/")
public class UmDefineController {

	@Autowired
	private IUmDefineService service;

	@RequestMapping("index")
	public String index() {
		return "";
	}

	@RequestMapping("tree")
	@ResponseBody
	public TreeResult tree() {
		return service.treeData();
	}

	@RequestMapping("addindex")
	public String addIndex() {
		return "";
	}

	@RequestMapping("add")
	@ResponseBody
	public EntityResult add(UmDefine entity) {
		return service.insertSelective(entity);
	}

	@RequestMapping("editindex")
	public String editIndex() {
		return "";
	}

	@RequestMapping("edit")
	@ResponseBody
	public EntityResult edit(UmDefine entity) {
		return service.updateByCode(entity);
	}

	@RequestMapping("del")
	@ResponseBody
	public RootResult del(String code) {
		return service.deleteByCode(code);
	}
}
