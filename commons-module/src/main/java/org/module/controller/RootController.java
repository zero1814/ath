package org.module.controller;

import org.module.dto.BaseDto;
import org.module.model.BaseModel;
import org.module.result.EntityResult;
import org.module.result.PageResult;
import org.module.result.BaseResult;

public abstract class RootController {

	public abstract String index();

	public abstract PageResult data(Class<? extends BaseDto> dto);

	public abstract EntityResult add(Class<? extends BaseModel> entity);

	public abstract EntityResult edit(Class<? extends BaseModel> entity);

	public abstract BaseResult del(Object obj);
}
