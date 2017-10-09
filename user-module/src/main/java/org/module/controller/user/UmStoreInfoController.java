package org.module.controller.user;

import org.module.dto.user.UmStoreInfoDto;
import org.module.model.user.UmStoreInfo;
import org.module.result.EntityResult;
import org.module.result.PageResult;
import org.module.result.BaseResult;
import org.module.service.user.IUmStoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user/store/")
public class UmStoreInfoController {

	@Autowired
	private IUmStoreInfoService service;

	@RequestMapping("index")
	public String index() {
		return "jsp/user/index";
	}

	@RequestMapping("data")
	@ResponseBody
	public PageResult data(UmStoreInfoDto dto) {
		return service.findEntityToPage(dto);
	}

	@RequestMapping("detail")
	public String detail(String code, ModelMap model) {
		EntityResult result = service.selectByCode(code);
		if (result.getCode() == 0) {
			model.addAttribute("store", result.getEntity());
			return "jsp/user/detail";
		} else {
			return "jsp/error/404";
		}
	}

	@RequestMapping("addindex")
	public String addIndex(ModelMap model) {
		model.addAttribute("status", service.getStoreStatus());
		return "jsp/user/add";
	}

	@RequestMapping("add")
	@ResponseBody
	public BaseResult add(UmStoreInfo entity) {
		return null;
	}

	@RequestMapping("editindex")
	public String editIndex(String code, ModelMap model) {
		EntityResult result = service.selectByCode(code);
		if (result.getCode() == 0) {
			model.addAttribute("store", result.getEntity());
			model.addAttribute("status", service.getStoreStatus());
			return "jsp/user/edit";
		} else {
			return "jsp/error/404";
		}
	}

	@RequestMapping("edit")
	@ResponseBody
	public BaseResult edit(UmStoreInfo entity) {
		return null;
	}

	@RequestMapping("del")
	@ResponseBody
	public BaseResult del(String code) {
		return null;
	}

}
