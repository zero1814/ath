package org.module.service.kernel.impl.db;

import org.module.dto.kernel.db.CmColumnDto;
import org.module.mapper.kernel.db.CmColumnMapper;
import org.module.model.kernel.db.CmColumn;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.kernel.db.ICmColumnService;
import org.springframework.stereotype.Service;

@Service
public class CmColumnServiceImpl extends BaseServiceImpl<CmColumn, CmColumnMapper, CmColumnDto> implements ICmColumnService{

}
