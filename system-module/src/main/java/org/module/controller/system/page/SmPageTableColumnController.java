package org.module.controller.system.page;

import org.module.dto.system.page.SmPageTableColumnDto;
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
	public String index() {
		return "";
	}

	@RequestMapping("data")
	@ResponseBody
	public PageResult data(SmPageTableColumnDto dto) {
		return service.findEntityToPage(dto);
	}

	@RequestMapping("addindex")
	public String addIndex(String tableCode, ModelMap model) {
		model.addAttribute("tableCode", tableCode);
		return "";
	}

	@RequestMapping("add")
	@ResponseBody
	public EntityResult add(SmPageTableColumn entity) {
		return service.insertSelective(entity);
	}

	@RequestMapping("editindex")
	public String editIndex(String code, ModelMap model) {
		EntityResult result = service.selectByCode(code);
		if (result.getCode() == 0) {
			model.addAttribute("column", result.getEntity());
		}
		return "";
	}

	@RequestMapping("edit")
	@ResponseBody
	public EntityResult edit(SmPageTableColumn entity) {
		return service.updateByCode(entity);
	}

	@RequestMapping("del")
	@ResponseBody
	public RootResult del(String code) {
		return service.deleteByCode(code);

	}

}
