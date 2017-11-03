package org.module.controller.echarts;

import org.module.service.echarts.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

@Controller
@RequestMapping("/echarts/user/")
public class UserController {

	@Autowired
	private IUserService service;

	@RequestMapping("data")
	@ResponseBody
	public JSONArray data() {
		return service.userData();
	}
}
