package org.module.controller.system.menu;

import org.module.base.result.BaseResult;
import org.module.base.result.EntityResult;
import org.module.base.result.PageResult;
import org.module.controller.BaseController;
import org.module.dto.system.menu.SmPageDto;
import org.module.helper.CodeHelper;
import org.module.model.system.menu.SmPage;
import org.module.service.system.menu.ISmPageService;
import org.module.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/system/menu/page/")
public class SmPageController extends BaseController {

	@Autowired
	private ISmPageService service;

	@RequestMapping("index")
	public String index() {
		return "jsp/system/menu/page/index";
	}

	@RequestMapping("data")
	@ResponseBody
	public PageResult data(SmPageDto dto) {
		return service.findEntityToPage(dto);
	}

	@RequestMapping("addindex")
	public String addIndex() {
		return "jsp/system/menu/page/add";
	}

	@RequestMapping("add")
	@ResponseBody
	public EntityResult add(SmPage entity) {
		entity.setCode(CodeHelper.getCode("SP"));
		entity.setCreateUser("admin");
		return service.insertSelective(entity);
	}

	@RequestMapping("editindex")
	public String editIndex(String code, ModelMap model) {
		EntityResult result = service.selectByCode(code);
		if (result.getCode() == Constant.RESULT_SUCCESS) {
			return "jsp/system/menu/page/index";
		} else if (result.getCode() == Constant.RESULT_NULL) {
			return NULL_URL;
		} else {
			return ERROR_URL;
		}
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
