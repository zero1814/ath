package org.module.controller;

import org.module.dto.BaseDto;
import org.module.model.BaseModel;
import org.module.result.PageResult;
import org.module.result.RootResult;

public abstract class RootController {

	public abstract String index();

	public abstract PageResult data(Class<? extends BaseDto> dto);

	public abstract RootResult add(Class<? extends BaseModel> entity);

	public abstract RootResult edit(Class<? extends BaseModel> entity);
	
	public abstract RootResult del(Object obj);
}
