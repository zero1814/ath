package org.module.service.commons.impl.db;

import org.module.dto.commons.db.CmColumnTypeDto;
import org.module.mapper.commons.db.CmColumnTypeMapper;
import org.module.model.commons.db.CmColumnType;
import org.module.service.commons.db.ICmColumnTypeService;
import org.module.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CmColumnTypeServiceImpl extends BaseServiceImpl<CmColumnType, CmColumnTypeMapper, CmColumnTypeDto> implements ICmColumnTypeService{

}
