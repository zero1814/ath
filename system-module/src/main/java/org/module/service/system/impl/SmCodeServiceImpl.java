package org.module.service.system.impl;

import org.module.commons.service.impl.BaseServiceImpl;
import org.module.dto.system.SmCodeDto;
import org.module.mapper.system.SmCodeMapper;
import org.module.model.system.SmCode;
import org.module.service.system.ISmCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmCodeServiceImpl extends BaseServiceImpl<SmCode, SmCodeMapper, SmCodeDto> implements ISmCodeService {

	@Autowired
	private SmCodeMapper mapper;

	@Override
	public String getCode(String prefix) {
		return mapper.getCode(prefix);
	}

}
