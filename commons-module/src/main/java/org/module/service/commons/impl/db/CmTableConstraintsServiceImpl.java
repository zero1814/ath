package org.module.service.commons.impl.db;

import org.module.dto.commons.db.CmTableConstraintsDto;
import org.module.mapper.commons.db.CmTableConstraintsMapper;
import org.module.model.commons.db.CmTableConstraints;
import org.module.service.commons.db.ICmTableConstraintsService;
import org.module.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CmTableConstraintsServiceImpl
		extends BaseServiceImpl<CmTableConstraints, CmTableConstraintsMapper, CmTableConstraintsDto>
		implements ICmTableConstraintsService {

}
