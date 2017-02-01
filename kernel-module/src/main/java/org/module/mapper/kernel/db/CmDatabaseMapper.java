package org.module.mapper.kernel.db;

import java.util.List;
import java.util.Map;

import org.module.dto.kernel.db.CmDatabaseDto;
import org.module.mapper.BaseMapper;
import org.module.model.kernel.db.CmDatabase;

public interface CmDatabaseMapper extends BaseMapper<CmDatabase, CmDatabaseDto> {

	/**
	 * 
	 * 方法: findTableByDb <br>
	 * 描述: 根据数据库名称获取数据库所有数据表信息 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月1日 下午9:58:56
	 * 
	 * @param dto
	 * @return
	 */
	List<Map<String, Object>> findTableByDb(CmDatabaseDto dto);

	/**
	 * 
	 * 方法: findColumnByTable <br>
	 * 描述: 根据数据库名称和数据表名称查询数据表所有列信息 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月1日 下午9:58:43
	 * 
	 * @param dto
	 * @return
	 */
	List<Map<String, Object>> findColumnByTable(CmDatabaseDto dto);
}