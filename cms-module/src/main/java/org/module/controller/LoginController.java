package org.module.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.module.annotation.SKipAuthPassport;
import org.module.base.result.EntityResult;
import org.module.dto.system.user.SmUserDto;
import org.module.service.system.user.ISmUserService;
import org.module.util.Constant;
import org.module.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.google.code.kaptcha.Constants;

@Controller
@RequestMapping("/user/")
public class LoginController extends BaseController {

	@Autowired
	private ISmUserService service;

	@SKipAuthPassport
	@RequestMapping("login")
	@ResponseBody
	public EntityResult login(SmUserDto dto, HttpServletRequest request, HttpServletResponse response) {
		EntityResult result = new EntityResult();
		if (StringUtils.isBlank(dto.getUserName())) {
			result.setCode(Constant.RESULT_ERROR);
			result.setMessage("用户名不能为空");
			return result;
		} else if (StringUtils.isBlank(dto.getPassword())) {
			result.setCode(Constant.RESULT_ERROR);
			result.setMessage("密码不能为空");
			return result;
		} else if (StringUtils.isBlank(dto.getVertifyCode())) {
			result.setCode(Constant.RESULT_ERROR);
			result.setMessage("验证码不能为空");
			return result;
		} else if (StringUtils.isNotBlank(dto.getVertifyCode())) {
			String code = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
			if (!StringUtils.equals(dto.getVertifyCode(), code)) {
				result.setCode(Constant.RESULT_ERROR);
				result.setMessage("验证码错误");
				return result;
			}
		}
		result = service.login(dto);
		if (result.getCode() == Constant.RESULT_SUCCESS) {
			String userJson = JSONObject.toJSONString(result);
			Cookie user = new Cookie("user", userJson);
			response.addCookie(user);
		}
		return result;
	}
}
