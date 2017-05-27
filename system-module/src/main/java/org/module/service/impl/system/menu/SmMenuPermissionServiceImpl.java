package org.module.service.impl.system.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.module.dto.system.menu.SmMenuPermissionDto;
import org.module.mapper.system.menu.SmMenuPermissionMapper;
import org.module.mapper.system.menu.SmMenuPermissionTypeMapper;
import org.module.model.system.menu.SmMenuPermission;
import org.module.model.system.menu.SmMenuPermissionType;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.menu.ISmMenuPermissionService;

@Service
public class SmMenuPermissionServiceImpl
		extends BaseServiceImpl<SmMenuPermission, SmMenuPermissionMapper, SmMenuPermissionDto>
		implements ISmMenuPermissionService {

	@Autowired
	private SmMenuPermissionTypeMapper typeMapper;

	/**
	 * 
	 * 方法: getMenuPermissionType <br>
	 * 
	 * @return
	 * @see org.module.service.system.menu.ISmMenuPermissionService#getMenuPermissionType()
	 */
	@Override
	public List<SmMenuPermissionType> getMenuPermissionType() {
		return typeMapper.findEntityAll();
	}

}
