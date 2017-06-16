package org.module.controller.system.page;

import org.module.dto.system.page.SmPageTableColumnDto;
import org.module.helper.commons.CodeHelper;
import org.module.model.system.page.SmPageTableColumn;
import org.module.result.EntityResult;
import org.module.result.PageResult;
import org.module.result.RootResult;
import org.module.service.system.page.ISmPageTableColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("system/page/table/column/")
public class SmPageTableColumnController {

	@Autowired
	private ISmPageTableColumnService service;

	@RequestMapping("index")
	public String index(String tableCode, ModelMap model) {
		model.addAttribute("tableCode", tableCode);
		return "jsp/system/page/table/column/index";
	}

	@RequestMapping("data")
	@ResponseBody
	public PageResult data(SmPageTableColumnDto dto) {
		return service.findEntityToPage(dto);
	}

	@RequestMapping("addindex")
	public String addIndex(String tableCode, ModelMap model) {
		model.addAttribute("tableCode", tableCode);
		return "jsp/system/page/table/column/add";
	}

	@RequestMapping("add")
	@ResponseBody
	public EntityResult add(SmPageTableColumn entity) {
		entity.setCode(CodeHelper.getUniqueCode("SPTC"));
		entity.setCreateUser("add");
		return service.insertSelective(entity);
	}

	@RequestMapping("editindex")
	public String editIndex(String code, ModelMap model) {
		EntityResult result = service.selectByCode(code);
		if (result.getCode() == 0) {
			model.addAttribute("column", result.getEntity());
		}
		return "jsp/system/page/table/column/edit";
	}

	@RequestMapping("edit")
	@ResponseBody
	public EntityResult edit(SmPageTableColumn entity) {
		entity.setUpdateUser("edit");
		return service.updateByCode(entity);
	}

	@RequestMapping("del")
	@ResponseBody
	public RootResult del(String code) {
		return service.deleteByCode(code);

	}

}
