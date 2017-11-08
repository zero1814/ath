package org.module.service.system.impl.user;

import java.util.List;

import org.module.base.result.BaseResult;
import org.module.base.result.DataResult;
import org.module.base.service.impl.BaseServiceImpl;
import org.module.dto.system.user.SmUserRoleDto;
import org.module.mapper.system.user.SmUserRoleMapper;
import org.module.model.system.user.SmRole;
import org.module.model.system.user.SmUserRole;
import org.module.service.system.user.ISmUserRoleService;
import org.module.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: SmUserRoleServiceImpl <br>
 * 描述: 用户角色关系表业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月31日 上午11:12:47
 */
@Service
public class SmUserRoleServiceImpl extends BaseServiceImpl<SmUserRole, SmUserRoleMapper, SmUserRoleDto>
		implements ISmUserRoleService {

	@Autowired
	private SmUserRoleMapper mapper;

	/**
	 * 
	 * 方法: deleteByUserCode <br>
	 * 
	 * @param userCode
	 * @return
	 * @see org.module.service.system.user.ISmUserRoleService#deleteByUserCode(java.lang.String)
	 */
	@Override
	public BaseResult deleteByUserCode(String userCode) {
		BaseResult result = new BaseResult();
		try {
			mapper.deleteByUserCode(userCode);
			result.setCode(Constant.RESULT_SUCCESS);
			result.setMessage("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(Constant.RESULT_ERROR);
			result.setMessage("删除失败，失败原因:" + e.getMessage());
		}
		return result;
	}

	/**
	 * 
	 * 方法: deleteUserRole <br>
	 * 
	 * @param dto
	 * @return
	 * @see org.module.service.system.user.ISmUserRoleService#deleteUserRole(org.module.dto.system.user.SmUserRoleDto)
	 */
	@Override
	public BaseResult deleteUserRole(SmUserRoleDto dto) {
		BaseResult result = new BaseResult();
		try {
			mapper.deleteUserRole(dto);
			result.setCode(Constant.RESULT_SUCCESS);
			result.setMessage("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(Constant.RESULT_ERROR);
			result.setMessage("删除报错，错误原因:" + e.getMessage());
		}
		return result;
	}

	/**
	 * 
	 * 方法: findUserRoleData <br>
	 * 
	 * @param userCode
	 * @return
	 * @see org.module.service.system.user.ISmUserRoleService#findUserRoleData(java.lang.String)
	 */
	@Override
	public DataResult findUserRoleData(SmUserRoleDto dto) {
		DataResult result = new DataResult();
		try {
			List<SmRole> list = mapper.findUserRoleData(dto);
			result.setData(list);
			result.setCode(Constant.RESULT_SUCCESS);
			result.setMessage("查询用户角色列表成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(Constant.RESULT_ERROR);
			result.setMessage("查询用户角色列表报错，错误原因:" + e.getMessage());
		}
		return null;
	}

}
