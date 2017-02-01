package org.module.service.kernel.db;

import java.util.List;

import org.module.commons.map.MDataMap;
import org.module.dto.kernel.db.CmDatabaseDto;
import org.module.model.kernel.db.CmDatabase;
import org.module.service.IBaseService;

/**
 * 
 * 类: ICmDatabaseService <br>
 * 描述: 数据库相关业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年2月1日 下午10:01:16
 */
public interface ICmDatabaseService extends IBaseService<CmDatabase, CmDatabaseDto> {

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
	List<MDataMap> findTableByDb(CmDatabaseDto dto);

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
	List<MDataMap> findColumnByTable(CmDatabaseDto dto);
}
