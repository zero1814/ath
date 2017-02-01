package org.module.service.kernel.impl.db;

import org.module.dto.kernel.db.CmTableConstraintsTypeDto;
import org.module.mapper.kernel.db.CmTableConstraintsTypeTypeMapper;
import org.module.model.kernel.db.CmTableConstraintsType;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.kernel.db.ICmTableConstraintsTypeService;
import org.springframework.stereotype.Service;

@Service
public class CmTableConstraintsTypeServiceImpl
		extends BaseServiceImpl<CmTableConstraintsType, CmTableConstraintsTypeTypeMapper, CmTableConstraintsTypeDto>
		implements ICmTableConstraintsTypeService {

}
