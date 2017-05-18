package org.module.service.impl.system.user;

import org.module.dto.system.user.SmUserRoleDto;
import org.module.mapper.system.user.SmUserRoleMapper;
import org.module.model.system.user.SmUserRole;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.user.ISmUesrRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: SmUesrRoleServiceImpl <br>
 * 描述: 用户角色管理表业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月18日 下午4:19:18
 */
@Service
public class SmUserRoleServiceImpl extends BaseServiceImpl<SmUserRole, SmUserRoleMapper, SmUserRoleDto>
		implements ISmUesrRoleService {
	@Autowired
	private SmUserRoleMapper mapper;

	/**
	 * 
	 * 方法: selectByUserCode <br>
	 * 
	 * @param userCode
	 * @return
	 * @see org.module.service.system.user.ISmUesrRoleService#selectByUserCode(java.lang.String)
	 */
	@Override
	public EntityResult selectByUserCode(String userCode) {
		EntityResult result = new EntityResult();
		try {
			SmUserRole entity = mapper.selectByUserCode(userCode);
			if (entity != null) {
				result.setEntity(entity);
				result.setCode(0);
				result.setMessage("查询成功");
			} else {
				result.setCode(-1);
				result.setMessage("查询数据为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(-1);
			result.setMessage("查询数据失败");
		}
		return result;
	}

	/**
	 * 
	 * 方法: deleteByUserCode <br>
	 * 
	 * @param userCode
	 * @return
	 * @see org.module.service.system.user.ISmUesrRoleService#deleteByUserCode(java.lang.String)
	 */
	@Override
	public RootResult deleteByUserCode(String userCode) {
		RootResult result = new RootResult();
		try {
			mapper.deleteByUserCode(userCode);
			result.setCode(0);
			result.setMessage("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(-1);
			result.setMessage("删除失败");
		}
		return result;
	}

}
