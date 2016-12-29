package org.system.service;

import org.commons.annotation.obj.ObjectExplain;
import org.commons.base.IBaseService;
import org.system.dto.SmDefineDto;
import org.system.model.SmDefine;

/**
 * 
 * 类: ISmDefineService <br>
 * 描述: 系统参数业务逻辑访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2016年12月29日 下午5:46:50
 */
@ObjectExplain(name="系统参数业务逻辑访问接口",description="对系统参数相关业务逻辑操作接口")
public interface ISmDefineService extends IBaseService<SmDefine, SmDefineDto> {

}
