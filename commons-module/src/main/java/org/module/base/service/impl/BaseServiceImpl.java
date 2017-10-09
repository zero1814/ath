package org.module.base.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.module.base.BaseClass;
import org.module.base.dto.BaseDto;
import org.module.base.mapper.BaseMapper;
import org.module.base.model.BaseModel;
import org.module.base.result.BaseResult;
import org.module.base.result.DataResult;
import org.module.base.result.EntityResult;
import org.module.base.result.PageResult;
import org.module.base.service.IBaseService;
import org.module.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
	public EntityResult insertSelective(T entity) {
		logger.logInfo(this.getClass().getName() + "，开始执行insertSelective方法");
		EntityResult result = new EntityResult();
		if (entity.getUid() == null || "".equals(entity.getUid())) {
			entity.setUid(UUID.randomUUID().toString().replace("-", ""));
		}
		if (entity.getCreateTime() == null || "".equals(entity.getCreateTime())) {
			entity.setCreateTime(DateUtil.getSysDateTime());
		}
		entity.setUpdateUser(entity.getCreateUser());
		entity.setUpdateTime(entity.getCreateTime());
		try {
			mapper.insertSelective(entity);
			result.setCode(0);
			result.setMessage("添加成功");
			result.setEntity(entity);
			logger.logInfo(this.getClass().getName() + "，执行insertSelective方法成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(-1);
			result.setMessage("添加失败，错误原因:" + e.getMessage());
			logger.logError(this.getClass().getName() + "执行insertSelective方法失败，失败原因:" + e.getMessage());
		}
		logger.logInfo(this.getClass().getName() + "，执行insertSelective方法结束");
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
	public EntityResult updateByCode(T entity) {
		logger.logInfo(this.getClass().getName() + "，开始执行updateByCode方法");
		EntityResult result = new EntityResult();
		if (entity.getUpdateTime() == null || "".equals(entity.getUpdateTime())) {
			entity.setUpdateTime(DateUtil.getSysDateTime());
		}
		try {
			T t = mapper.selectByCode(entity.getCode());
			if (t != null) {
				mapper.updateByCode(entity);
				result.setCode(0);
				result.setMessage("编辑成功");
			} else {
				result.setCode(-1);
				result.setMessage("编辑对象不存在");
			}
			logger.logInfo(this.getClass().getName() + "，执行updateByCode方法成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(-1);
			result.setMessage("编辑错误，错误原因:" + e.getMessage());
			logger.logError(this.getClass().getName() + "执行updateByCode方法失败，失败原因:" + e.getMessage());
		}
		logger.logInfo(this.getClass().getName() + "，执行updateByCode方法结束");
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
	public EntityResult selectEntity(DTO dto) {
		logger.logInfo(this.getClass().getName() + "，开始执行selectByEntity方法");
		EntityResult result = new EntityResult();
		try {
			T entity_ = mapper.selectEntity(dto);
			if (entity_ != null) {
				result.setCode(0);
				result.setMessage("查询成功");
				result.setEntity(entity_);
			} else {
				result.setCode(-1);
				result.setMessage("查询数据为空");
			}
			logger.logInfo(this.getClass().getName() + "，执行selectByEntity方法成功");
		} catch (Exception e) {
			result.setCode(-1);
			result.setMessage("查询数据失败");
			logger.logError(this.getClass().getName() + "执行selectByEntity方法失败，失败原因:" + e.getMessage());
		}
		logger.logInfo(this.getClass().getName() + "，执行selectByEntity方法结束");

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
		logger.logInfo(this.getClass().getName() + "，开始执行deleteByCode方法");
		BaseResult result = new BaseResult();
		try {
			T t = mapper.selectByCode(code);
			if (t != null) {
				int flag = mapper.deleteByCode(code);
				if (flag >= 0) {
					result.setCode(0);
					result.setMessage("删除成功");
				} else {
					result.setCode(-1);
					result.setMessage("删除失败");
				}
			} else {
				result.setCode(-1);
				result.setMessage("删除对象不存在");
			}
			logger.logInfo(this.getClass().getName() + "，执行deleteByCode方法成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(-1);
			result.setMessage("删除失败，失败原因：" + e.getMessage());
			logger.logError(this.getClass().getName() + "执行deleteByCode方法失败，失败原因:" + e.getMessage());
		}
		logger.logInfo(this.getClass().getName() + "，执行deleteByCode方法结束");
		return result;
	}

	/**
	 * 
	 * 方法: deleteByCodes <br>
	 * 
	 * @param codes
	 * @return
	 * @see org.module.service.IBaseService#deleteByCodes(java.util.List)
	 */
	@Override
	public BaseResult deleteByCodes(List<String> codes) {
		logger.logInfo(this.getClass().getName() + "，开始执行deleteByCodes方法");
		BaseResult result = new BaseResult();
		try {
			if (codes != null && codes.size() > 0) {
				int flag = mapper.deleteByCodes(codes);
				if (flag < 0) {
					result.setCode(-1);
					result.setMessage("编码集合为空");
				}
			} else {
				result.setCode(-1);
				result.setMessage("批量删除中编码集合为空");
			}
			logger.logInfo(this.getClass().getName() + "，执行deleteByCodes方法成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(-1);
			result.setMessage("批量删除失败，失败原因：" + e.getMessage());
			logger.logError(this.getClass().getName() + "执行deleteByCodes方法失败，失败原因:" + e.getMessage());
		}
		logger.logInfo(this.getClass().getName() + "，执行deleteByCodes方法结束");
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
	public EntityResult selectByCode(String code) {
		logger.logInfo(this.getClass().getName() + "，开始执行selectByCode方法");
		EntityResult result = new EntityResult();
		try {
			T entity = mapper.selectByCode(code);
			if (entity != null) {
				result.setCode(0);
				result.setMessage("查询成功");
				result.setEntity(entity);
			} else {
				result.setCode(-1);
				result.setMessage("查询数据为空");
			}
			logger.logInfo(this.getClass().getName() + "，执行selectByCode方法成功");
		} catch (Exception e) {
			logger.logError(this.getClass().getName() + "执行selectByCode方法失败，失败原因:" + e.getMessage());
		}
		logger.logInfo(this.getClass().getName() + "，执行selectByCode方法结束");
		return result;
	}

	/**
	 * 
	 * 方法: findEntityToPage <br>
	 * 
	 * @param dto
	 * @return
	 * @see cn.com.ath.service.IBaseService#findEntityToPage(cn.com.ath.dto.BaseDto)
	 */
	@Override
	public PageResult findEntityToPage(DTO dto) {
		logger.logInfo(this.getClass().getName() + "，开始执行findEntityToPage方法");
		PageResult result = new PageResult();
		try {
			if (dto.getPageNumber() == null) {
				dto.setPageNumber(1);
			}
			if (dto.getPageSize() == null) {
				dto.setPageSize(10);
			}
			PageHelper.startPage(dto.getPageNumber(), dto.getPageSize());
			List<T> list = mapper.findEntityAllToPage(dto);
			if (list == null || list.size() <= 0) {
				list = new ArrayList<T>();
			}
			PageInfo<T> page = new PageInfo<T>(list);
			result.setCode(0);
			result.setMessage("获取分页数据成功");
			result.setRows(page.getList());
			result.setTotal(new Long(page.getTotal()).intValue());
			logger.logInfo(this.getClass().getName() + "，执行findEntityToPage方法成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(-1);
			result.setMessage("获取分页信息失败，失败原因：" + e.getMessage());
			logger.logError(this.getClass().getName() + "执行findEntityToPage方法失败，失败原因:" + e.getMessage());
		}
		logger.logInfo(this.getClass().getName() + "，执行findEntityToPage方法结束");
		return result;
	}

	@Override
	public DataResult findDataAll(DTO dto) {
		logger.logInfo(this.getClass().getName() + "，开始执行findDataAll方法");
		DataResult result = new DataResult();
		try {
			List<T> list = mapper.findEntityAll(dto);
			if (list != null && list.size() > 0) {
				result.setData(list);
			} else {
				result.setCode(-1);
				result.setMessage("获取列表为空");
			}
			logger.logInfo(this.getClass().getName() + "，执行findDataAll方法成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(-1);
			result.setMessage("获取列表错误");
			logger.logError(this.getClass().getName() + "执行findDataAll方法失败，失败原因:" + e.getMessage());
		}
		logger.logInfo(this.getClass().getName() + "，执行findDataAll方法结束");
		return result;
	}
}
