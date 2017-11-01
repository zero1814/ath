package org.module.controller;

import org.module.base.dto.BaseDto;
import org.module.base.model.BaseModel;
import org.module.base.result.BaseResult;
import org.module.base.result.EntityResult;
import org.module.base.result.PageResult;

public abstract class RootController {

	public abstract String index();

	public abstract PageResult data(Class<? extends BaseDto> dto);

	public abstract EntityResult add(Class<? extends BaseModel> entity);

	public abstract EntityResult edit(Class<? extends BaseModel> entity);

	public abstract BaseResult del(Object obj);
}
