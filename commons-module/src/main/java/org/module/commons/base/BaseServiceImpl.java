package org.module.commons.base;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.module.commons.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;

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
	 * 描述: TODO
	 * 
	 * @param entity
	 * @return
	 * @see cn.com.ath.service.IBaseService#insertSelective(cn.com.ath.model.BaseModel)
	 */
	@Override
	public JSONObject insertSelective(T entity) {
		if (entity.getUuid() == null || "".equals(entity.getUuid())) {
			entity.setUuid(UUID.randomUUID().toString().replace("-", ""));
		}
		if (entity.getCreateTime() == null || "".equals(entity.getCreateTime())) {
			entity.setCreateTime(DateUtil.getSysDateTime());
		}
		entity.setUpdateUser(entity.getCreateUser());
		entity.setUpdateTime(entity.getCreateTime());

		JSONObject obj = new JSONObject();
		try {
			int result = mapper.insertSelective(entity);
			if (result > 0) {
				obj.put("code", 0);
				obj.put("msg", "添加成功");
			} else {
				obj.put("code", 0);
				obj.put("msg", "添加失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			obj.put("code", -1);
			obj.put("msg", "添加错误，请联系管理员");
		}
		return obj;
	}

	/**
	 * 
	 * 方法: updateByCode <br>
	 * 描述: TODO
	 * 
	 * @param entity
	 * @return
	 * @see cn.com.ath.service.IBaseService#updateByCode(cn.com.ath.model.BaseModel)
	 */
	@Override
	public JSONObject updateByCode(T entity) {
		if (entity.getUpdateTime() == null || "".equals(entity.getUpdateTime())) {
			entity.setUpdateTime(DateUtil.getSysDateTime());
		}
		JSONObject obj = new JSONObject();
		try {
			int result = mapper.updateByCode(entity);
			if (result > 0) {
				obj.put("code", 0);
				obj.put("msg", "编辑成功");
			} else {
				obj.put("code", 0);
				obj.put("msg", "编辑失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			obj.put("code", -1);
			obj.put("msg", "编辑错误，请联系管理员");
		}
		return obj;
	}

	/**
	 * 
	 * 方法: selectByEntity <br>
	 * 描述: TODO
	 * 
	 * @param entity
	 * @return
	 * @see cn.com.ath.service.IBaseService#selectByEntity(cn.com.ath.model.BaseModel)
	 */
	@Override
	public T selectByEntity(T entity) {
		return mapper.selectByEntity(entity);
	}

	/**
	 * 
	 * 方法: deleteByCode <br>
	 * 描述: TODO
	 * 
	 * @param code
	 * @return
	 * @see cn.com.ath.service.IBaseService#deleteByCode(java.lang.String)
	 */
	@Override
	public JSONObject deleteByCode(String code) {
		JSONObject obj = new JSONObject();
		try {
			int result = mapper.deleteByCode(code);
			if (result >= 0) {
				obj.put("code", 0);
				obj.put("msg", "删除成功");
			} else {
				obj.put("code", -1);
				obj.put("msg", "删除失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			obj.put("code", -1);
			obj.put("msg", "删除错误，请联系管理员");
		}
		return obj;
	}

	/**
	 * 
	 * 方法: selectByCode <br>
	 * 描述: TODO
	 * 
	 * @param code
	 * @return
	 * @see cn.com.ath.service.IBaseService#selectByCode(java.lang.String)
	 */
	@Override
	public T selectByCode(String code) {
		return mapper.selectByCode(code);
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
	public JSONObject findEntityToPage(DTO dto) {
		dto.setStart(dto.getPageIndex() * dto.getPageSize());
		List<T> list = mapper.findEntityAll(dto);
		if (list == null || list.size() <= 0) {
			list = new ArrayList<T>();
		}
		int total = mapper.findEntityAllCount(dto);
		JSONObject obj = new JSONObject();
		obj.put("data", list);
		obj.put("total", total);
		return obj;
	}

}
