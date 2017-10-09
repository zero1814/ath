package org.module.controller.system.db;

import org.module.dto.system.db.SmTableDto;
import org.module.model.system.db.SmTable;
import org.module.result.EntityResult;
import org.module.result.PageResult;
import org.module.result.BaseResult;
import org.module.service.system.db.ISmTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("system/db/table/")
public class SmTableController {

	@Autowired
	private ISmTableService service;

	@RequestMapping("index")
	public String databaseTableIndex(String dbCode, ModelMap model) {
		model.addAttribute("dbCode", dbCode != null ? dbCode : "");
		return "jsp/system/db/table/index";
	}

	@RequestMapping("data")
	@ResponseBody
	public PageResult data(SmTableDto dto) {
		return service.findEntityToPage(dto);
	}
	
	@RequestMapping("edit")
	@ResponseBody
	public EntityResult edit(SmTable entity){
		return service.updateByCode(entity);
	}
	
	@RequestMapping("del")
	@ResponseBody
	public BaseResult del(String tableCode){
		return service.deleteByCode(tableCode);
	}
}
