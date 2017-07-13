package org.module.service.system.db;

import org.module.dto.system.db.SmDatabaseDto;
import org.module.model.system.db.SmDatabase;
import org.module.result.RootResult;
import org.module.service.IBaseService;

/**
 * 
 * 类: ISmDatabaseService <br>
 * 描述: 数据库维护表业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月11日 下午4:38:24
 */
public interface ISmDatabaseService extends IBaseService<SmDatabase, SmDatabaseDto> {

	/**
	 * 
	 * 方法: sync <br>
	 * 描述: 同步数据到数据相关表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月12日 下午5:55:35
	 * @return
	 */
	RootResult sync();
}
