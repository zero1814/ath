package org.module.service.kernel.impl.db;

import org.module.dto.kernel.db.CmTableDto;
import org.module.mapper.kernel.db.CmTableMapper;
import org.module.model.kernel.db.CmTable;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.kernel.db.ICmTableService;
import org.springframework.stereotype.Service;

@Service
public class CmTableServiceImpl extends BaseServiceImpl<CmTable, CmTableMapper, CmTableDto> implements ICmTableService{

}
