package org.module.controller.kernel;

import org.module.dto.kernel.db.CmDatabaseDto;
import org.module.result.DataMapResult;
import org.module.result.DataResult;
import org.module.service.kernel.db.ICmDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * 类: CmDatabaseController <br>
 * 描述: 数据库相关页面交互 <br>
 * 作者: zhy<br>
 * 时间: 2017年2月2日 下午6:17:13
 */
@Controller
@RequestMapping("kernel/db/")
public class CmDatabaseController {

	@Autowired
	private ICmDatabaseService service;

	/**
	 * 
	 * 方法: index <br>
	 * 描述: 数据库列表显示页面 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月2日 下午6:17:31
	 * @return
	 */
	@RequestMapping("index")
	public String index() {
		return null;
	}

	/**
	 * 
	 * 方法: data <br>
	 * 描述: 数据库列表数据获取 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月2日 下午6:17:53
	 * @param dto
	 * @return
	 */
	@RequestMapping("data")
	@ResponseBody
	public DataResult data(CmDatabaseDto dto) {
		return service.findDataAll(dto);
	}

	/**
	 * 
	 * 方法: tableIndex <br>
	 * 描述: 数据库所有表显示页面 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月2日 下午6:18:10
	 * @return
	 */
	@RequestMapping("table/index")
	public String tableIndex() {
		return null;
	}

	/**
	 * 
	 * 方法: dbTables <br>
	 * 描述: 数据库所有表显示数据 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月2日 下午6:18:28
	 * @param dto
	 * @return
	 */
	@RequestMapping("table/data")
	@ResponseBody
	public DataMapResult dbTables(CmDatabaseDto dto) {
		return service.findTableByDb(dto);
	}

	/**
	 * 
	 * 方法: tableColumnsIndex <br>
	 * 描述: 数据库所有表列字段显示页面 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月2日 下午6:18:44
	 * @return
	 */
	@RequestMapping("table/column/index")
	public String tableColumnsIndex() {
		return null;
	}

	/**
	 * 
	 * 方法: tableColumns <br>
	 * 描述: 数据库所有表列字段显示数据 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月2日 下午6:19:01
	 * @param dto
	 * @return
	 */
	@RequestMapping("table/column/data")
	@ResponseBody
	public DataMapResult tableColumns(CmDatabaseDto dto) {
		return service.findColumnByTable(dto);
	}
}
