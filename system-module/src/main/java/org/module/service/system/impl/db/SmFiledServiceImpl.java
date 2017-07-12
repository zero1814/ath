package org.module.service.system.impl.db;

import java.util.List;

import org.module.dto.system.db.SmFiledDto;
import org.module.mapper.system.db.SmFiledMapper;
import org.module.model.system.db.SmFiled;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.db.ISmFiledService;
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
public class SmFiledServiceImpl extends BaseServiceImpl<SmFiled, SmFiledMapper, SmFiledDto> implements ISmFiledService {

	@Autowired
	private SmFiledMapper mapper;

	@Override
	public EntityResult insertSelective(SmFiled entity) {
		EntityResult result = super.insertSelective(entity);
		if (result.getCode() == 0) {
			mapper.insertTableColumn(entity);
		}
		return result;
	}

	@Override
	public EntityResult updateByCode(SmFiled entity) {
		EntityResult result = super.updateByCode(entity);
		if (result.getCode() == 0) {
			mapper.editTableColumn(entity);
		}
		return result;
	}

	@Override
	public RootResult deleteByCode(String code) {
		EntityResult result = super.selectByCode(code);
		if (result.getCode() == 0) {
			SmFiled entity = (SmFiled) result.getEntity();
			mapper.dropTableColumn(entity);
			super.deleteByCode(code);
		}
		return result;
	}

	@Override
	public RootResult deleteByCodes(List<String> codes) {
		RootResult result = new RootResult();
		try {
			for (String code : codes) {
				EntityResult entityResult = super.selectByCode(code);
				if (entityResult.getCode() == 0) {
					SmFiled entity = (SmFiled) entityResult.getEntity();
					mapper.dropTableColumn(entity);
					super.deleteByCode(code);
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
