package org.module.controller.product;

import org.module.helper.commons.CodeHelper;
import org.module.model.product.PmDefine;
import org.module.model.system.user.SmUser;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.result.TreeResult;
import org.module.service.product.IPmDefineService;
import org.module.system.factory.UserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("product/define/")
public class PmDefineController {

	@Autowired
	private IPmDefineService service;

	@RequestMapping("index")
	public String index() {
		return "jsp/product/define/index";
	}

	@RequestMapping("tree")
	@ResponseBody
	public TreeResult tree() {
		TreeResult result = service.tree();
		return result;
	}

	@RequestMapping("detail")
	public String detail(String code, ModelMap model) {
		EntityResult result = service.selectByCode(code);
		if (result.getCode() == 0) {
			model.addAttribute("define", result.getEntity());
			return "jsp/product/define/detail";
		} else {
			return "jsp/error/404";
		}
	}

	@RequestMapping("addindex")
	public String addIndex(String parentCode, ModelMap model) {
		model.addAttribute("parentCode", parentCode);
		return "jsp/product/define/add";
	}

	@RequestMapping("add")
	@ResponseBody
	public RootResult add(PmDefine entity) {
		RootResult result = new RootResult();
		SmUser user = UserFactory.instance().userInfo();
		if (user != null) {
			entity.setCode(CodeHelper.getUniqueCode("PD"));
			entity.setCreateUser(user.getCode());
			result = service.insertSelective(entity);
		} else {
			result.setCode(-1);
			result.setMessage("用户尚未登录");
		}

		return result;
	}

	@RequestMapping("editindex")
	public String editIndex(String code, ModelMap model) {
		EntityResult result = service.selectByCode(code);
		if (result.getCode() == 0) {
			model.addAttribute("define", result.getEntity());
			return "jsp/product/define/edit";
		} else {
			return "jsp/error/404";
		}
	}

	@RequestMapping("edit")
	@ResponseBody
	public RootResult edit(PmDefine entity) {
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
