package org.module.commons.service.impl;

import org.module.commons.dto.db.CmDatabaseDto;
import org.module.commons.mapper.db.CmDatabaseMapper;
import org.module.commons.model.db.CmDatabase;
import org.module.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CmDatabaseServiceImpl extends BaseServiceImpl<CmDatabase, CmDatabaseMapper, CmDatabaseDto>{

}
