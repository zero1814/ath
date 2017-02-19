package org.module.service.impl.system.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import org.module.dto.system.menu.SmMenuPermissionDto;
import org.module.mapper.system.SmDefineMapper;
import org.module.mapper.system.menu.SmMenuPermissionMapper;
import org.module.model.system.SmDefine;
import org.module.model.system.menu.SmMenuPermission;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.menu.ISmMenuPermissionService;

@Service
public class SmMenuPermissionServiceImpl
		extends BaseServiceImpl<SmMenuPermission, SmMenuPermissionMapper, SmMenuPermissionDto>
		implements ISmMenuPermissionService {

	@Autowired
	private SmDefineMapper defineMapper;

	/**
	 * 
	 * 方法: getMenuPermissionType <br>
	 * 
	 * @return
	 * @see org.module.service.system.menu.ISmMenuService#getMenuPermissionType()
	 */
	@Override
	public List<SmDefine> getMenuPermissionType() {
		List<SmDefine> list = defineMapper.findDataByParentCode("SD833281701663731712");
		if (!list.isEmpty()) {
			return list;
		} else {
			return new ArrayList<SmDefine>();
		}
	}
}
