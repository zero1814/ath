package org.module.service.impl.log;

import java.util.List;

import org.module.dto.log.user.LmLoginDto;
import org.module.mapper.log.user.LmLoginMapper;
import org.module.model.log.user.LmLogin;
import org.module.result.DataResult;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.log.ILmLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LmLoginServiceImpl extends BaseServiceImpl<LmLogin, LmLoginMapper, LmLoginDto> implements ILmLoginService {

	@Autowired
	private LmLoginMapper mapper;

	@Override
	public DataResult selectByUserCode(String userCode) {
		DataResult result = new DataResult();
		List<LmLogin> list = mapper.selectByUserCode(userCode);
		if (list != null && list.size() > 0) {
			result.setCode(0);
			result.setData(list);
			result.setMessage("查询成功");
		} else {
			result.setCode(-1);
			result.setMessage("查询为空");
		}
		return result;
	}

}
