package org.module.service;

import java.util.List;

import org.module.dto.BaseDto;
import org.module.model.BaseModel;
import org.module.result.DataResult;
import org.module.result.EntityResult;
import org.module.result.PageResult;
import org.module.result.BaseResult;

/**
 * 
 * 类: IBaseService <br>
 * 描述: 业务逻辑处理接口基类 <br>
 * 作者: zhy<br>
 * 时间: 2016年7月27日 上午9:41:19
 */
public interface IBaseService<T extends BaseModel, DTO extends BaseDto> {

	/**
	 * 
	 * 方法: insertSelective <br>
	 * 描述: 添加新的对象 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年8月1日 下午1:37:28
	 * 
	 * @param entity
	 * @return
	 */
	EntityResult insertSelective(T entity);

	/**
	 * 
	 * 方法: updateByPrimaryKeySelective <br>
	 * 描述: 编辑现有对象 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年8月1日 下午1:37:38
	 * 
	 * @param entity
	 * @return
	 */
	EntityResult updateByCode(T entity);

	/**
	 * 
	 * 方法: deleteByCode <br>
	 * 描述: 根据编码删除现有对象 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年8月8日 下午8:18:48
	 * 
	 * @param code
	 * @return
	 */
	BaseResult deleteByCode(String code);

	/**
	 * 
	 * 方法: deleteByCodes <br>
	 * 描述: 根据编码集合批量删除菜单组 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年1月22日 下午3:49:56
	 * 
	 * @param codes
	 * @return
	 */
	BaseResult deleteByCodes(List<String> codes);

	/**
	 * 
	 * 方法: selectByPrimaryKey <br>
	 * 描述: 根据主键查询现有对象 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年8月1日 下午1:38:02
	 * 
	 * @param pk
	 * @return
	 */
	EntityResult selectByCode(String code);

	/**
	 * 
	 * 方法: selectByEntity <br>
	 * 描述: 根据对象属性查询对象信息 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年8月1日 下午1:56:19
	 * 
	 * @param dto
	 * @return
	 */
	EntityResult selectEntity(DTO dto);

	/**
	 * 
	 * 方法: findEntityToPage <br>
	 * 描述: 数据分页 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年8月31日 上午10:01:09
	 * 
	 * @param dto
	 * @return
	 */
	PageResult findEntityToPage(DTO dto);

	/**
	 * 
	 * 方法: findDataAll <br>
	 * 描述: 查询数据集合 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年1月1日 下午5:47:10
	 * 
	 * @param dto
	 * @return
	 */
	DataResult findDataAll(DTO dto);
}
