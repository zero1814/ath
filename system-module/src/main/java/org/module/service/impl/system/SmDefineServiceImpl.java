package org.module.service.impl.system;

import java.util.ArrayList;
import java.util.List;

import org.module.dto.system.SmDefineDto;
import org.module.mapper.system.SmDefineMapper;
import org.module.model.system.SmDefine;
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
		if(!list.isEmpty()){
			result.setCode(0);
			result.setData(list);
			result.setMessage("查询成功");
		}else{
			result.setCode(-1);
			result.setData(new ArrayList<SmDefine>());
			result.setMessage("查询失败");
		}
		return null;
	}
}
