package org.module.service.commons.impl.db;

import org.module.dto.commons.db.CmTableDto;
import org.module.mapper.commons.db.CmTableMapper;
import org.module.model.commons.db.CmTable;
import org.module.service.commons.db.ICmTableService;
import org.module.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CmTableServiceImpl extends BaseServiceImpl<CmTable, CmTableMapper, CmTableDto> implements ICmTableService{

}
