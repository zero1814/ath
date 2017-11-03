package org.module.init.system;

import java.util.List;

import org.module.annotation.Inject;
import org.module.base.result.DataResult;
import org.module.cache.system.CacheKey;
import org.module.helper.CacheHelper;
import org.module.init.RootInit;
import org.module.model.system.menu.SmMenuGroup;
import org.module.service.system.menu.ISmMenuService;

import com.alibaba.fastjson.JSONArray;

/**
 * 
 * 类: MenuInit <br>
 * 描述: 菜单初始化加载 <br>
 * 作者: zhy<br>
 * 时间: 2017年10月25日 上午11:12:24
 */
public class MenuInit extends RootInit {

	@Inject
	private ISmMenuService service;

	@SuppressWarnings("unchecked")
	@Override
	public boolean onInit() {
		logger.logInfo("开始加载参数列表");
		boolean flag = false;
		try {
			DataResult result = service.findDataAll();
			if (result.getCode() == 1) {
				List<SmMenuGroup> list = (List<SmMenuGroup>) result.getData();
				for (SmMenuGroup mg : list) {
					CacheHelper.setFiledVal(CacheKey.MENU, mg.getCode(), JSONArray.toJSONString(mg.getMenus()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.logInfo("加载参数列表结束");
		return flag;
	}

	@Override
	public boolean onDestory() {
		// TODO Auto-generated method stub
		return false;
	}

}
