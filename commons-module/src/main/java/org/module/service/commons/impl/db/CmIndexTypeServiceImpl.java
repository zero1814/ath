package org.module.service.commons.impl.db;

import org.module.dto.commons.db.CmIndexTypeDto;
import org.module.mapper.commons.db.CmIndexTypeMapper;
import org.module.model.commons.db.CmIndexType;
import org.module.service.commons.db.ICmIndexTypeService;
import org.module.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CmIndexTypeServiceImpl extends BaseServiceImpl<CmIndexType,CmIndexTypeMapper, CmIndexTypeDto> implements ICmIndexTypeService{

}
