package org.module.init.system;

import org.module.annotation.Inject;
import org.module.base.result.TreeResult;
import org.module.helper.CacheHelper;
import org.module.root.WebRootInit;
import org.module.service.system.ISmDefineService;

import com.alibaba.fastjson.JSON;

public class SmDefineInit extends WebRootInit {

	@Inject
	private ISmDefineService service;

	@Override
	public boolean onInit() {
		logger.logInfo("开始加载参数列表");
		boolean flag = false;
		try {
			TreeResult result = service.tree();
			if (result.getCode() == 1) {
				CacheHelper.setValue("define", JSON.toJSONString(result.getData()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.logInfo("加载参数列表结束");
		return flag;
	}

	@Override
	public boolean onDestory() {
		return false;
	}

}
