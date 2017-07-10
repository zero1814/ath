package org.module.controller;

import java.util.Map;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

public class BaseController {

	public ModelAndView redirect(String redirectUrl, Map<String, Object>... parament) {
		ModelAndView view = new ModelAndView(new RedirectView(redirectUrl));
		if (null != parament && parament.length > 0) {
			view.addAllObjects(parament[0]);
		}
		return view;
	}
}
