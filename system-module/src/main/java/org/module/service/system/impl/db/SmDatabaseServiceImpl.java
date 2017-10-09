package org.module.service.system.impl.db;

import org.module.dto.system.db.SmDatabaseDto;
import org.module.dto.system.db.SmTableDto;
import org.module.mapper.system.db.SmDatabaseMapper;
import org.module.model.system.db.SmDatabase;
import org.module.result.DataResult;
import org.module.result.BaseResult;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.db.ISmDatabaseService;
import org.module.service.system.db.ISmTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: SmDatabaseServiceImpl <br>
 * 描述: 数据库维护表业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月11日 下午4:41:57
 */
@Service
public class SmDatabaseServiceImpl extends BaseServiceImpl<SmDatabase, SmDatabaseMapper, SmDatabaseDto>
		implements ISmDatabaseService {

	@Autowired
	private SmDatabaseMapper mapper;
	@Autowired
	private ISmTableService tableService;

	/**
	 * 
	 * 方法: sync <br>
	 * 
	 * @return
	 * @see org.module.service.system.db.ISmDatabaseService#sync()
	 */
	@Override
	public BaseResult sync() {
		BaseResult result = new BaseResult();
		try {
			mapper.sync();
			result.setCode(0);
			result.setMessage("同步成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(-1);
			result.setMessage("同步失败，失败原因：" + e.getMessage());
		}
		return result;
	}

	@Override
	public BaseResult deleteByCode(String dbCode) {
		BaseResult result = new BaseResult();
		SmTableDto dto = new SmTableDto();
		dto.setDbCode(dbCode);
		DataResult tableResult = tableService.findDataAll(dto);
		if (tableResult.getCode() == 0) {
			if (tableResult.getData() != null && tableResult.getData().size() > 0) {
				result.setCode(-1);
				result.setMessage("数据库中包含表数据，请先删除数据表信息");
			} else {
				result = super.deleteByCode(dbCode);
			}
		} else {
			result = tableResult;
		}
		return result;
	}

}
