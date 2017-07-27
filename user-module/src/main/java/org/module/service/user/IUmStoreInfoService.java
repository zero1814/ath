package org.module.service.user;

import java.util.List;

import org.module.dto.user.UmStoreInfoDto;
import org.module.model.user.UmDefine;
import org.module.model.user.UmStoreInfo;
import org.module.service.IBaseService;

/**
 * 
 * 类: IUmStoreInfoService <br>
 * 描述: 店铺表业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月21日 下午3:11:28
 */
public interface IUmStoreInfoService extends IBaseService<UmStoreInfo, UmStoreInfoDto> {

	List<UmDefine> getStoreStatus();
}
