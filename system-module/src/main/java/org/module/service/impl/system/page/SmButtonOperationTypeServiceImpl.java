package org.module.service.impl.system.page;

import org.module.dto.system.page.SmButtonOperationTypeDto;
import org.module.mapper.system.page.SmButtonOperationTypeMapper;
import org.module.model.system.page.SmButtonOperationType;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.page.ISmButtonOperationTypeService;
import org.springframework.stereotype.Service;

@Service
public class SmButtonOperationTypeServiceImpl
		extends BaseServiceImpl<SmButtonOperationType, SmButtonOperationTypeMapper, SmButtonOperationTypeDto>
		implements ISmButtonOperationTypeService {

}
