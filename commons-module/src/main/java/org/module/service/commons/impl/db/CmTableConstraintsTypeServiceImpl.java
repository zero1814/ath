package org.module.service.commons.impl.db;

import org.module.dto.commons.db.CmTableConstraintsTypeDto;
import org.module.mapper.commons.db.CmTableConstraintsTypeTypeMapper;
import org.module.model.commons.db.CmTableConstraintsType;
import org.module.service.commons.db.ICmTableConstraintsTypeService;
import org.module.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CmTableConstraintsTypeServiceImpl
		extends BaseServiceImpl<CmTableConstraintsType, CmTableConstraintsTypeTypeMapper, CmTableConstraintsTypeDto>
		implements ICmTableConstraintsTypeService {

}
