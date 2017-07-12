package org.module.mapper.system.db;

import org.module.dto.system.db.SmFiledDto;
import org.module.mapper.BaseMapper;
import org.module.model.system.db.SmFiled;

/**
 * 
 * 类: SmFiledMapper <br>
 * 描述: 页面显示字段维护表数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月12日 上午11:22:30
 */
public interface SmFiledMapper extends BaseMapper<SmFiled, SmFiledDto> {

	/**
	 * 
	 * 方法: insertTableColumn <br>
	 * 描述: 数据表新添加字段 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月12日 上午11:23:14
	 * 
	 * @param entity
	 * @return
	 */
	int insertTableColumn(SmFiled entity);

	/**
	 * 
	 * 方法: editTableColumn <br>
	 * 描述: 数据表修改字段 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月12日 上午11:23:21
	 * 
	 * @param entity
	 * @return
	 */
	int editTableColumn(SmFiled entity);

	/**
	 * 
	 * 方法: dropTableColumn <br>
	 * 描述: 数据表删除字段 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月12日 上午11:23:57
	 * 
	 * @param entity
	 * @return
	 */
	int dropTableColumn(SmFiled entity);

}