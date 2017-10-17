package org.module.mapper.system.db;

import org.module.base.mapper.BaseMapper;
import org.module.dto.system.db.SmDatabaseDto;
import org.module.model.system.db.SmDatabase;

/**
 * 
 * 类: SmDatabaseMapper <br>
 * 描述: 数据库维护表数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月11日 下午4:34:08
 */
public interface SmDatabaseMapper extends BaseMapper<SmDatabase, SmDatabaseDto> {

	/**
	 * 
	 * 方法: sync <br>
	 * 描述: 同步数据到数据相关表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月12日 下午5:58:53
	 * 
	 * @return
	 */
	int sync();
}