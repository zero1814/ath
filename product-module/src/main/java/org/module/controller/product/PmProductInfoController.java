package org.module.controller.product;

import org.module.dto.product.PmProductInfoDto;
import org.module.factory.UserFactory;
import org.module.helper.commons.CodeHelper;
import org.module.model.product.PmProductInfo;
import org.module.model.system.user.SmUser;
import org.module.result.EntityResult;
import org.module.result.PageResult;
import org.module.result.RootResult;
import org.module.service.product.IPmProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/product/info/")
public class PmProductInfoController {

	@Autowired
	private IPmProductInfoService service;

	@RequestMapping("index")
	public String index() {
		return "jsp/product/index";
	}

	@RequestMapping("data")
	@ResponseBody
	public PageResult data(PmProductInfoDto dto) {
		return service.findEntityToPage(dto);
	}

	@RequestMapping("addindex")
	public String addIndex(String storeCode, ModelMap model) {
		model.addAttribute("productType", service.getProductType());
		model.addAttribute("productStatus", service.getProductStatus());
		return "jsp/product/add";
	}

	@RequestMapping("add")
	@ResponseBody
	public RootResult add(PmProductInfo entity) {
		RootResult result = new RootResult();
		SmUser user = UserFactory.instance().userInfo();
		if (user != null) {
			entity.setCode(CodeHelper.getUniqueCode("PP"));
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
			model.addAttribute("product", result.getEntity());
			model.addAttribute("productType", service.getProductType());
			model.addAttribute("productStatus", service.getProductStatus());
			return "jsp/product/edit";
		} else {
			return "jsp/error/404";
		}
	}

	@RequestMapping("edit")
	@ResponseBody
	public RootResult edit(PmProductInfo entity) {
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
