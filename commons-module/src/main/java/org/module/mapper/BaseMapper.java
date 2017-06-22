package org.module.mapper;

import java.util.List;

import org.module.dto.BaseDto;
import org.module.model.BaseModel;

/**
 * 
 * 类: BaseMapper <br>
 * 描述: 数据库访问接口基类 <br>
 * 作者: zhy<br>
 * 时间: 2016年7月27日 上午9:35:41
 * 
 * @param <T>
 */
public interface BaseMapper<T extends BaseModel, DTO extends BaseDto> {

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
	int insertSelective(T entity);

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
	int updateByCode(T entity);

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
	int deleteByCode(String code);

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
	int deleteByCodes(List<String> codes);

	/**
	 * 
	 * 方法: selectByPrimaryKey <br>
	 * 描述: 根据编码查询现有对象 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年8月1日 下午1:38:02
	 * 
	 * @param code
	 * @return
	 */
	T selectByCode(String code);

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
	T selectEntity(DTO dto);

	/**
	 * 
	 * 方法: findEntityAll <br>
	 * 描述: 根据对象属性查询所有对象 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年8月1日 下午1:38:35
	 * 
	 * @return
	 */
	List<T> findEntityAll(DTO dto);

	/**
	 * 
	 * 方法: findEntityAllCount <br>
	 * 描述: 根据对象属性查询所有对象总数 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年8月1日 下午1:39:53
	 * 
	 * @param entity
	 * @return
	 */
	int findEntityAllCount(DTO dto);

	/**
	 * 
	 * 方法: findEntityAll <br>
	 * 描述: 根据对象属性查询所有对象 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年8月1日 下午1:38:35
	 * 
	 * @return
	 */
	List<T> findEntityAllToPage(DTO dto);

	/**
	 * 
	 * 方法: findEntityAllCount <br>
	 * 描述: 根据对象属性查询所有对象总数 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年8月1日 下午1:39:53
	 * 
	 * @param entity
	 * @return
	 */
	int findEntityAllCountToPage(DTO dto);
}
