package org.module.controller.user;

import org.module.factory.UserFactory;
import org.module.helper.commons.CodeHelper;
import org.module.model.system.user.SmUser;
import org.module.model.user.UmDefine;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.result.TreeResult;
import org.module.service.user.IUmDefineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user/define/")
public class UmDefineController {

	@Autowired
	private IUmDefineService service;

	@RequestMapping("index")
	public String index() {
		return "jsp/user/define/index";
	}

	@RequestMapping("tree")
	@ResponseBody
	public TreeResult tree() {
		return service.treeData();
	}

	@RequestMapping("addindex")
	public String addIndex() {
		return "jsp/user/define/add";
	}

	@RequestMapping("add")
	@ResponseBody
	public RootResult add(UmDefine entity) {
		RootResult result = new RootResult();
		SmUser user = UserFactory.instance().userInfo();
		if (user != null) {
			entity.setCode(CodeHelper.getUniqueCode("UD"));
			entity.setCreateUser(user.getCode());
			result = service.insertSelective(entity);
		} else {
			result.setCode(-1);
			result.setMessage("用户尚未登录");
		}
		return result;
	}

	@RequestMapping("editindex")
	public String editIndex(String code,ModelMap model) {
		EntityResult result = service.selectByCode(code);
		if(result.getCode() == 0){
			model.addAttribute("define", result.getEntity());
			return "jsp/user/define/edit";
		}else{
			return "jsp/error/404";
		}
	}

	@RequestMapping("edit")
	@ResponseBody
	public RootResult edit(UmDefine entity) {
		RootResult result = new RootResult();
		SmUser user = UserFactory.instance().userInfo();
		if (user != null) {
			entity.setUpdateUser(user.getCode());
			result = service.updateByCode(entity);
		} else {
			result.setCode(-1);
			result.setMessage("用户尚未登录");
		}
		return result;
	}

	@RequestMapping("del")
	@ResponseBody
	public RootResult del(String code) {
		RootResult result = new RootResult();
		SmUser user = UserFactory.instance().userInfo();
		if (user != null) {
			result = service.deleteByCode(code);
		} else {
			result.setCode(-1);
			result.setMessage("用户尚未登录");
		}
		return result;
	}
}
