package org.module.service.system.impl.db;

import java.util.List;

import org.module.dto.system.db.SmFieldDto;
import org.module.mapper.system.db.SmFieldMapper;
import org.module.model.system.db.SmField;
import org.module.result.EntityResult;
import org.module.result.BaseResult;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.db.ISmFiledService;
import org.module.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: SmFiledServiceImpl <br>
 * 描述: 页面显示字段维护表业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月12日 上午11:20:16
 */
@Service
public class SmFiledServiceImpl extends BaseServiceImpl<SmField, SmFieldMapper, SmFieldDto> implements ISmFiledService {

	@Autowired
	private SmFieldMapper mapper;

	@Override
	public EntityResult insertSelective(SmField entity) {
		EntityResult result = super.insertSelective(entity);
		if (result.getCode() == 0) {
			mapper.insertTableColumn(entity);
		}
		return result;
	}

	@Override
	public EntityResult updateByCode(SmField entity) {
		EntityResult result = super.updateByCode(entity);
		if (result.getCode() == 0) {
			mapper.editTableColumn(entity);
		}
		return result;
	}

	@Override
	public BaseResult deleteByCode(String code) {
		BaseResult result = new BaseResult();
		EntityResult filedResult = super.selectByCode(code);
		if (filedResult.getCode() == 0) {
			SmField entity = (SmField) filedResult.getEntity();
			if (StringUtils.isNotBlank(entity.getFieldKey())) {
				result.setCode(-1);
				result.setMessage("字段包含索引信息，请先删除字段索引信息");
			} else {
				mapper.dropTableColumn(entity);
				result = super.deleteByCode(code);
			}
		}
		return result;
	}

	@Override
	public BaseResult deleteByCodes(List<String> codes) {
		BaseResult result = new BaseResult();
		try {
			for (String code : codes) {
				EntityResult entityResult = super.selectByCode(code);
				if (entityResult.getCode() == 0) {
					SmField entity = (SmField) entityResult.getEntity();
					if (StringUtils.isNotBlank(entity.getFieldKey())) {
						result.setCode(-1);
						result.setMessage("字段包含索引信息，请先删除字段索引信息");
						break;
					} else {
						mapper.dropTableColumn(entity);
						super.deleteByCode(code);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(-1);
			result.setMessage("批量删除失败");
		}
		return result;
	}

}
