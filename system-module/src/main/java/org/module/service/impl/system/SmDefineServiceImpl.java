package org.module.service.impl.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.module.dto.system.SmDefineDto;
import org.module.mapper.system.SmDefineMapper;
import org.module.model.system.SmDefine;
import org.module.result.DataMapResult;
import org.module.result.DataResult;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.ISmDefineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmDefineServiceImpl extends BaseServiceImpl<SmDefine, SmDefineMapper, SmDefineDto>
		implements ISmDefineService {

	@Autowired
	private SmDefineMapper mapper;

	@Override
	public DataResult findDataByParentCode(String parentCode) {
		DataResult result = new DataResult();
		List<SmDefine> list = mapper.findDataByParentCode(parentCode);
		if (!list.isEmpty()) {
			result.setCode(0);
			result.setData(list);
			result.setMessage("查询成功");
		} else {
			result.setCode(-1);
			result.setData(new ArrayList<SmDefine>());
			result.setMessage("查询失败");
		}
		return null;
	}

	/**
	 * 
	 * 方法: findDataAll <br>
	 * 
	 * @return
	 * @see org.module.service.system.ISmDefineService#findDataAll()
	 */
	@Override
	public DataMapResult findDataAll() {
		DataMapResult result = new DataMapResult();
		try {
			List<Map<String, Object>> list = getData("0");
			if (list != null && list.size() > 0) {
				result.setData(list);
				result.setCode(0);
				result.setMessage("查询成功");
			} else {
				result.setCode(-1);
				result.setMessage("查询参数列表为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(-1);
			result.setMessage("查询参数列表失败，失败原因：" + e.getMessage());
		}
		return result;
	}

	private List<Map<String, Object>> getData(String parentCode) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		List<SmDefine> list = mapper.findDataByParentCode(parentCode);
		if (list != null && list.size() > 0) {
			for (SmDefine define : list) {
				Map<String, Object> first = new HashMap<String, Object>();
				first.put("id", define.getCode());
				first.put("nodeId", define.getCode());
				first.put("text", define.getName());
				List<Map<String, Object>> sub = getData(define.getCode());
				if (sub != null && sub.size() > 0) {
					first.put("nodes", sub);
				}
				result.add(first);
			}
		}
		return result;
	}
}
