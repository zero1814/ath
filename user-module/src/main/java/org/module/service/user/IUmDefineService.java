package org.module.service.user;

import org.module.dto.user.UmDefineDto;
import org.module.model.user.UmDefine;
import org.module.result.TreeResult;
import org.module.service.IBaseService;

/**
 * 
 * 类: IUmDefineService <br>
 * 描述: 用户模块参数表业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月21日 下午1:56:29
 */
public interface IUmDefineService extends IBaseService<UmDefine, UmDefineDto> {

	/**
	 * 
	 * 方法: treeData <br>
	 * 描述: 获取用户参数树型结构 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月21日 下午2:03:55
	 * 
	 * @return
	 */
	TreeResult treeData();
}
