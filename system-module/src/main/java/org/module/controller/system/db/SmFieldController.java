package org.module.controller.system.db;

import org.module.dto.system.db.SmFieldDto;
import org.module.model.system.db.SmField;
import org.module.result.EntityResult;
import org.module.result.PageResult;
import org.module.result.RootResult;
import org.module.service.system.db.ISmFiledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("system/db/field/")
public class SmFieldController {

	@Autowired
	private ISmFiledService service;

	@RequestMapping("index")
	public String index(String tableCode, ModelMap model) {
		model.addAttribute("tableCode", tableCode != null ? tableCode : "");
		return "jsp/system/db/filed/index";
	}

	@RequestMapping("data")
	@ResponseBody
	public PageResult data(SmFieldDto dto) {
		return service.findEntityToPage(dto);
	}
	
	@RequestMapping("edit")
	@ResponseBody
	public EntityResult edit(SmField entity){
		return service.updateByCode(entity);
	}
	
	@RequestMapping("del")
	@ResponseBody
	public RootResult del(String filedCode){
		return service.deleteByCode(filedCode);
	}
}
