package org.module.controller.system.db;

import org.module.dto.system.db.SmDatabaseDto;
import org.module.model.system.db.SmDatabase;
import org.module.result.EntityResult;
import org.module.result.PageResult;
import org.module.result.BaseResult;
import org.module.service.system.db.ISmDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("system/db/database/")
public class SmDatabaseController {

	@Autowired
	private ISmDatabaseService service;

	@RequestMapping("index")
	public String index() {
		return "jsp/system/db/database/index";
	}

	@RequestMapping("data")
	@ResponseBody
	public PageResult data(SmDatabaseDto dto) {
		return service.findEntityToPage(dto);
	}

	@RequestMapping("sync")
	@ResponseBody
	public BaseResult sync() {
		return service.sync();
	}

	@RequestMapping("edit")
	@ResponseBody
	public EntityResult edit(SmDatabase entity) {
		return service.updateByCode(entity);
	}

	@RequestMapping("del")
	@ResponseBody
	public BaseResult del(String dbCode) {
		return service.deleteByCode(dbCode);
	}
}
