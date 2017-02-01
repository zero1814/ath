package org.module.service.kernel.impl.db;

import org.module.dto.kernel.db.CmTableConstraintsDto;
import org.module.mapper.kernel.db.CmTableConstraintsMapper;
import org.module.model.kernel.db.CmTableConstraints;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.kernel.db.ICmTableConstraintsService;
import org.springframework.stereotype.Service;

@Service
public class CmTableConstraintsServiceImpl
		extends BaseServiceImpl<CmTableConstraints, CmTableConstraintsMapper, CmTableConstraintsDto>
		implements ICmTableConstraintsService {

}
