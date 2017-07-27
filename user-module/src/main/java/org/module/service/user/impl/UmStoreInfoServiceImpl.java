package org.module.service.user.impl;

import java.util.List;

import org.module.dto.user.UmStoreInfoDto;
import org.module.helper.commons.PropHelper;
import org.module.mapper.user.UmDefineMapper;
import org.module.mapper.user.UmStoreInfoMapper;
import org.module.model.user.UmDefine;
import org.module.model.user.UmStoreInfo;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.user.IUmStoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: UmStoreInfoServiceImpl <br>
 * 描述: 店铺表业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月21日 下午3:11:49
 */
@Service
public class UmStoreInfoServiceImpl extends BaseServiceImpl<UmStoreInfo, UmStoreInfoMapper, UmStoreInfoDto>
		implements IUmStoreInfoService {

	@Autowired
	private UmDefineMapper defineMapper;

	@Override
	public List<UmDefine> getStoreStatus() {
		return defineMapper.findDefineByParentCode(PropHelper.getConfig("user.store.statusCode"));
	}

}
