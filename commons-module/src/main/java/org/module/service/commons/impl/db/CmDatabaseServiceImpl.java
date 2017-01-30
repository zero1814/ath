package org.module.service.commons.impl.db;

import org.module.dto.commons.db.CmDatabaseDto;
import org.module.mapper.commons.db.CmDatabaseMapper;
import org.module.model.commons.db.CmDatabase;
import org.module.service.commons.db.ICmDatabaseService;
import org.module.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CmDatabaseServiceImpl extends BaseServiceImpl<CmDatabase, CmDatabaseMapper, CmDatabaseDto> implements ICmDatabaseService{

}
