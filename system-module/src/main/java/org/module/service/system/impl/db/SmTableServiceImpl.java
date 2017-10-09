package org.module.service.system.impl.db;

import org.module.dto.system.db.SmFieldDto;
import org.module.dto.system.db.SmTableDto;
import org.module.mapper.system.db.SmTableMapper;
import org.module.model.system.db.SmTable;
import org.module.result.DataResult;
import org.module.result.BaseResult;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.db.ISmFiledService;
import org.module.service.system.db.ISmTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: SmTableServiceImpl <br>
 * 描述: 数据表维护表业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月11日 下午4:42:12
 */
@Service
public class SmTableServiceImpl extends BaseServiceImpl<SmTable, SmTableMapper, SmTableDto> implements ISmTableService {

	@Autowired
	private ISmFiledService filedService;

	@Override
	public BaseResult deleteByCode(String tableCode) {
		BaseResult result = new BaseResult();
		SmFieldDto dto = new SmFieldDto();
		dto.setTableCode(tableCode);
		DataResult filedResult = filedService.findDataAll(dto);
		if (filedResult.getCode() == 0) {
			if (filedResult.getData() != null && filedResult.getData().size() > 0) {
				result.setCode(-1);
				result.setMessage("数据表中存在数据字段信息，请先删除数据字段信息");
			} else {
				result = super.deleteByCode(tableCode);
			}
		} else {
			result = filedResult;
		}
		return result;
	}

}
