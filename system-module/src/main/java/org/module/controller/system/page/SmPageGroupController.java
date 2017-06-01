package org.module.controller.system.page;

import org.module.dto.system.page.SmPageGroupDto;
import org.module.model.system.page.SmPageGroup;
import org.module.result.DataResult;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.system.page.ISmPageGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("system/page/group/")
public class SmPageGroupController {

	@Autowired
	private ISmPageGroupService service;

	@RequestMapping("index")
	public String index() {
		return "";
	}

	@RequestMapping("data")
	@ResponseBody
	public DataResult data(SmPageGroupDto dto) {
		return service.findDataAll(dto);
	}

	@RequestMapping("add")
	@ResponseBody
	public EntityResult add(SmPageGroup entity) {
		return null;
	}

	@RequestMapping("edit")
	@ResponseBody
	public EntityResult edit(SmPageGroup entity) {
		return null;
	}

	@RequestMapping("del")
	@ResponseBody
	public RootResult del(String code) {
		return null;
	}
}
