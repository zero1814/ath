package org.module.service.kernel.impl.db;

import org.module.dto.kernel.db.CmColumnTypeDto;
import org.module.mapper.kernel.db.CmColumnTypeMapper;
import org.module.model.kernel.db.CmColumnType;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.kernel.db.ICmColumnTypeService;
import org.springframework.stereotype.Service;

@Service
public class CmColumnTypeServiceImpl extends BaseServiceImpl<CmColumnType, CmColumnTypeMapper, CmColumnTypeDto> implements ICmColumnTypeService{

}
