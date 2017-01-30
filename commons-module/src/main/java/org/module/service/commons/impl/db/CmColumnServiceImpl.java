package org.module.service.commons.impl.db;

import org.module.dto.commons.db.CmColumnDto;
import org.module.mapper.commons.db.CmColumnMapper;
import org.module.model.commons.db.CmColumn;
import org.module.service.commons.db.ICmColumnService;
import org.module.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CmColumnServiceImpl extends BaseServiceImpl<CmColumn, CmColumnMapper, CmColumnDto> implements ICmColumnService{

}
