package org.module.service.kernel.impl.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.module.commons.map.MDataMap;
import org.module.dto.kernel.db.CmDatabaseDto;
import org.module.mapper.kernel.db.CmDatabaseMapper;
import org.module.model.kernel.db.CmDatabase;
import org.module.result.DataMapResult;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.kernel.db.ICmDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: CmDatabaseServiceImpl <br>
 * 描述: 数据库相关业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年2月1日 下午10:01:44
 */
@Service
public class CmDatabaseServiceImpl extends BaseServiceImpl<CmDatabase, CmDatabaseMapper, CmDatabaseDto>
		implements ICmDatabaseService {

	@Autowired
	private CmDatabaseMapper mapper;

	/**
	 * 
	 * 方法: findTableByDb <br>
	 * 描述: 根据数据库名称获取数据库所有数据表信息 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月1日 下午10:05:19
	 * 
	 * @param dto
	 * @return
	 */
	@Override
	public DataMapResult findTableByDb(CmDatabaseDto dto) {
		DataMapResult result = new DataMapResult();
		List<MDataMap> data = new ArrayList<MDataMap>();
		try {
			List<Map<String, Object>> list = mapper.findTableByDb(dto);
			if (list != null && list.size() > 0) {
				for (Map<String, Object> map : list) {
					MDataMap m = new MDataMap(map);
					data.add(m);
				}
			}else{
				result.setCode(-1);
				result.setMessage("数据库表为空");
			}
		} catch (Exception e) {
			result.setCode(-1);
			result.setMessage(e.getMessage());
			e.printStackTrace();
		}
		result.setData(data);
		return result;
	}

	/**
	 * 
	 * 方法: findColumnByTable <br>
	 * 描述: 根据数据库名称和数据表名称查询数据表所有列信息 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月1日 下午10:05:25
	 * 
	 * @param dto
	 * @return
	 */
	@Override
	public DataMapResult findColumnByTable(CmDatabaseDto dto) {
		DataMapResult result = new DataMapResult();
		List<MDataMap> data = new ArrayList<MDataMap>();
		try {
			List<Map<String, Object>> list = mapper.findColumnByTable(dto);
			if (list != null && list.size() > 0) {
				for (Map<String, Object> map : list) {
					MDataMap m = new MDataMap(map);
					data.add(m);
				}
			}else{
				result.setCode(-1);
				result.setMessage("表字段为空");
			}
		} catch (Exception e) {
			result.setCode(-1);
			result.setMessage(e.getMessage());
			e.printStackTrace();
		}
		result.setData(data);
		return result;
	}

}
