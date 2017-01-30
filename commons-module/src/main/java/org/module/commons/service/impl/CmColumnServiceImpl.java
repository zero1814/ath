package org.module.commons.service.impl;

import org.module.commons.dto.db.CmColumnDto;
import org.module.commons.mapper.db.CmColumnMapper;
import org.module.commons.model.db.CmColumn;
import org.module.commons.service.ICmColumnService;
import org.module.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CmColumnServiceImpl extends BaseServiceImpl<CmColumn, CmColumnMapper, CmColumnDto> implements ICmColumnService{

}
