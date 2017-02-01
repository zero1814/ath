package org.module.service.kernel.impl.db;

import org.module.dto.kernel.db.CmDatabaseDto;
import org.module.mapper.kernel.db.CmDatabaseMapper;
import org.module.model.kernel.db.CmDatabase;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.kernel.db.ICmDatabaseService;
import org.springframework.stereotype.Service;

@Service
public class CmDatabaseServiceImpl extends BaseServiceImpl<CmDatabase, CmDatabaseMapper, CmDatabaseDto> implements ICmDatabaseService{

}
