package org.module.controller.system.page;

import org.module.dto.system.page.SmPageDto;
import org.module.model.system.page.SmPage;
import org.module.result.EntityResult;
import org.module.result.PageResult;
import org.module.result.RootResult;
import org.module.service.system.page.ISmPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("system/page/")
public class SmPageController {

	@Autowired
	private ISmPageService service;

	@RequestMapping("index")
	public String index() {
		return "";
	}

	@RequestMapping("data")
	@ResponseBody
	public PageResult data(SmPageDto dto) {
		return service.findEntityToPage(dto);
	}

	@RequestMapping("add")
	@ResponseBody
	public EntityResult add(SmPage entity) {
		entity.setCreateUser("test");
		return service.insertSelective(entity);
	}

	@RequestMapping("edit")
	@ResponseBody
	public EntityResult edit(SmPage entity) {
		entity.setUpdateUser("test");
		return service.updateByCode(entity);
	}

	@RequestMapping("del")
	@ResponseBody
	public RootResult del(String code) {
		return service.deleteByCode(code);
	}
}
