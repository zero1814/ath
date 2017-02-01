package org.module.controller.kernel;

import org.module.dto.kernel.db.CmDatabaseDto;
import org.module.result.DataMapResult;
import org.module.result.DataResult;
import org.module.service.kernel.db.ICmDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("kernel/db/")
public class CmDatabaseController {

	@Autowired
	private ICmDatabaseService service;

	@RequestMapping("index")
	public String index() {
		return null;
	}

	@RequestMapping("data")
	@ResponseBody
	public DataResult data(CmDatabaseDto dto) {
		return service.findDataAll(dto);
	}
	
	@RequestMapping("db/tables")
	@ResponseBody
	public DataMapResult dbTables(CmDatabaseDto dto){
		return service.findTableByDb(dto);
	}
	
	@RequestMapping("db/table/columns")
	@ResponseBody
	public DataMapResult tableColumns(CmDatabaseDto dto){
		return service.findColumnByTable(dto);
	}
}
