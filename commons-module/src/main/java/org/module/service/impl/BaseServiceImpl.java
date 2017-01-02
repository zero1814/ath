package org.module.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.module.commons.base.BaseClass;
import org.module.commons.base.BaseResult;
import org.module.commons.result.EntityResult;
import org.module.commons.result.PageResult;
import org.module.commons.util.DateUtil;
import org.module.dto.BaseDto;
import org.module.mapper.BaseMapper;
import org.module.model.BaseModel;
import org.module.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * 类: BaseServiceImpl <br>
 * 描述: 业务处理接口基类实现类 <br>
 * 作者: zhy<br>
 * 时间: 2016年7月27日 上午9:45:43
 * 
 * @param <T>
 * @param <PK>
 * @param <M>
 */
public class BaseServiceImpl<T extends BaseModel, M extends BaseMapper<T, DTO>, DTO extends BaseDto> extends BaseClass
		implements IBaseService<T, DTO> {

	@Autowired
	private M mapper;

	/**
	 * 
	 * 方法: insertSelective <br>
	 * 
	 * @param entity
	 * @return
	 * @see cn.com.ath.service.IBaseService#insertSelective(cn.com.ath.model.BaseModel)
	 */
	@Override
	public EntityResult<T> insertSelective(T entity) {
		EntityResult<T> result = new EntityResult<T>();
		if (entity.getUid() == null || "".equals(entity.getUid())) {
			entity.setUid(UUID.randomUUID().toString().replace("-", ""));
		}
		if (entity.getCreateTime() == null || "".equals(entity.getCreateTime())) {
			entity.setCreateTime(DateUtil.getSysDateTime());
		}
		entity.setUpdateUser(entity.getCreateUser());
		entity.setUpdateTime(entity.getCreateTime());
		try {
			int flag = mapper.insertSelective(entity);
			if (flag > 0) {
				result.setCode(0);
				result.setMessage("添加成功");
				result.setEntity(entity);
			} else {
				result.setCode(-1);
				result.setMessage("添加失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(-1);
			result.setMessage("添加失败，错误原因:" + e.getMessage());
		}
		return result;
	}

	/**
	 * 
	 * 方法: updateByCode <br>
	 * 
	 * @param entity
	 * @return
	 * @see cn.com.ath.service.IBaseService#updateByCode(cn.com.ath.model.BaseModel)
	 */
	@Override
	public EntityResult<T> updateByCode(T entity) {
		EntityResult<T> result = new EntityResult<T>();
		if (entity.getUpdateTime() == null || "".equals(entity.getUpdateTime())) {
			entity.setUpdateTime(DateUtil.getSysDateTime());
		}
		try {
			int flag = mapper.updateByCode(entity);
			if (flag > 0) {
				result.setCode(0);
				result.setMessage("编辑成功");
			} else {
				result.setCode(-1);
				result.setMessage("编辑失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(-1);
			result.setMessage("编辑错误，错误原因:" + e.getMessage());
		}
		return result;
	}

	/**
	 * 
	 * 方法: selectByEntity <br>
	 * 
	 * @param entity
	 * @return
	 * @see cn.com.ath.service.IBaseService#selectByEntity(cn.com.ath.model.BaseModel)
	 */
	@Override
	public EntityResult<T> selectByEntity(T entity) {
		EntityResult<T> result = new EntityResult<T>();
		T entity_ = mapper.selectByEntity(entity);
		if (entity_ != null) {
			result.setCode(0);
			result.setMessage("查询成功");
			result.setEntity(entity_);
		} else {
			result.setCode(-1);
			result.setMessage("查询失败");
		}
		return result;
	}

	/**
	 * 
	 * 方法: deleteByCode <br>
	 * 
	 * @param code
	 * @return
	 * @see cn.com.ath.service.IBaseService#deleteByCode(java.lang.String)
	 */
	@Override
	public BaseResult deleteByCode(String code) {
		BaseResult result = new BaseResult();
		try {
			int flag = mapper.deleteByCode(code);
			if (flag >= 0) {
				result.setCode(0);
				result.setMessage("删除成功");
			} else {
				result.setCode(-1);
				result.setMessage("删除失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(-1);
			result.setMessage("删除失败，失败原因：" + e.getMessage());
		}
		return result;
	}

	/**
	 * 
	 * 方法: selectByCode <br>
	 * 
	 * @param code
	 * @return
	 * @see cn.com.ath.service.IBaseService#selectByCode(java.lang.String)
	 */
	@Override
	public EntityResult<T> selectByCode(String code) {
		EntityResult<T> result = new EntityResult<T>();
		T entity = mapper.selectByCode(code);
		if (entity != null) {
			result.setCode(0);
			result.setMessage("查询成功");
			result.setEntity(entity);
		} else {
			result.setCode(-1);
			result.setMessage("查询失败");
		}
		return result;
	}

	/**
	 * 
	 * 方法: findEntityToPage <br>
	 * 描述: TODO
	 * 
	 * @param dto
	 * @return
	 * @see cn.com.ath.service.IBaseService#findEntityToPage(cn.com.ath.dto.BaseDto)
	 */
	@Override
	public PageResult<T> findEntityToPage(DTO dto) {
		PageResult<T> result = new PageResult<T>();
		try {
			dto.setStart(dto.getPageIndex() * dto.getPageSize());
			List<T> list = mapper.findEntityAll(dto);
			if (list == null || list.size() <= 0) {
				list = new ArrayList<T>();
			}
			int total = mapper.findEntityAllCount(dto);
			result.setCode(0);
			result.setMessage("获取分页数据成功");
			result.setData(list);
			result.setTotal(total);
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(-1);
			result.setMessage("获取分页信息失败，失败原因：" + e.getMessage());
			getLogger().logError(this.getClass(), e.getMessage());
		}
		return result;
	}

}
