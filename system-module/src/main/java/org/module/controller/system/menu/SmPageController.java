package org.module.controller.system.menu;

import org.module.base.result.BaseResult;
import org.module.base.result.EntityResult;
import org.module.base.result.PageResult;
import org.module.dto.system.menu.SmPageDto;
import org.module.model.system.menu.SmPage;
import org.module.service.system.menu.ISmPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class SmPageController {

	@Autowired
	private ISmPageService service;

	@RequestMapping("index")
	public String index() {
		return null;
	}

	@RequestMapping("data")
	@ResponseBody
	public PageResult data(SmPageDto dto) {
		return service.findEntityToPage(dto);
	}

	@RequestMapping("add")
	@ResponseBody
	public EntityResult add(SmPage entity) {
		return service.insertSelective(entity);
	}

	@RequestMapping("edit")
	@ResponseBody
	public EntityResult edit(SmPage entity) {
		return service.updateByCode(entity);
	}

	@RequestMapping("del")
	@ResponseBody
	public BaseResult del(String code) {
		return service.deleteByCode(code);
	}

}
