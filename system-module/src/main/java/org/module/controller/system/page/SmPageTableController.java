package org.module.controller.system.page;

import org.module.dto.system.page.SmPageTableDto;
import org.module.helper.commons.CodeHelper;
import org.module.model.system.page.SmPageTable;
import org.module.result.EntityResult;
import org.module.result.PageResult;
import org.module.result.RootResult;
import org.module.service.system.page.ISmPageTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("system/page/table/")
public class SmPageTableController {

	@Autowired
	private ISmPageTableService service;

	@RequestMapping("index")
	public String index() {
		return "jsp/system/page/table/index";
	}

	@RequestMapping("data")
	@ResponseBody
	public PageResult data(SmPageTableDto dto) {
		return service.findEntityToPage(dto);
	}

	@RequestMapping("addindex")
	public String addIndex(ModelMap model) {
		model.addAttribute("pages", service.findPageAll());
		return "jsp/system/page/table/add";
	}

	@RequestMapping("add")
	@ResponseBody
	public EntityResult add(SmPageTable entity) {
		entity.setCode(CodeHelper.getUniqueCode("SPT"));
		entity.setCreateUser("add");
		return service.insertSelective(entity);
	}

	@RequestMapping("editindex")
	public String editIndex(String code, ModelMap model) {
		EntityResult result = service.selectByCode(code);
		if (result.getCode() == 0) {
			model.addAttribute("table", result.getEntity());
		}
		model.addAttribute("pages", service.findPageAll());
		return "jsp/system/page/table/edit";
	}

	@RequestMapping("edit")
	@ResponseBody
	public EntityResult edit(SmPageTable entity) {
		entity.setUpdateUser("edit");
		return service.updateByCode(entity);
	}

	@RequestMapping("del")
	@ResponseBody
	public RootResult del(String code) {
		return service.deleteByCode(code);
	}
}
