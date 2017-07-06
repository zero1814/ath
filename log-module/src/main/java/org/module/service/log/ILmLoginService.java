package org.module.service.log;


import org.module.dto.log.user.LmLoginDto;
import org.module.model.log.user.LmLogin;
import org.module.result.DataResult;
import org.module.service.IBaseService;

public interface ILmLoginService extends IBaseService<LmLogin, LmLoginDto> {
	/**
	 * 
	 * 方法: selectByUserCode <br>
	 * 描述: 根据用户编码查询日志记录 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月6日 下午2:14:29
	 * 
	 * @param userCode
	 * @return
	 */
	DataResult selectByUserCode(String userCode);
}
