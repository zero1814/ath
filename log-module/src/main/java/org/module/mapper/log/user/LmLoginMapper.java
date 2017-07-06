package org.module.mapper.log.user;

import java.util.List;

import org.module.dto.log.user.LmLoginDto;
import org.module.mapper.BaseMapper;
import org.module.model.log.user.LmLogin;

public interface LmLoginMapper extends BaseMapper<LmLogin, LmLoginDto> {

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
	List<LmLogin> selectByUserCode(String userCode);
}