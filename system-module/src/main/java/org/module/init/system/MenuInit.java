package org.module.init.system;

import org.module.base.result.TreeResult;
import org.module.cache.system.CacheKey;
import org.module.helper.CacheHelper;
import org.module.helper.PropHelper;
import org.module.root.WebRootInit;
import org.module.service.system.menu.ISmMenuService;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;

/**
 * 
 * 类: MenuInit <br>
 * 描述: 菜单初始化加载 <br>
 * 作者: zhy<br>
 * 时间: 2017年10月25日 上午11:12:24
 */
public class MenuInit extends WebRootInit {

	@Autowired
	private ISmMenuService service;
	
	@Override
	public boolean onInit() {
		logger.logInfo("开始加载参数列表");
		boolean flag = false;
		try {
			String groupCode = PropHelper.getConfig("menu.groupcode");
			TreeResult result = service.tree(groupCode);
			if (result.getCode() == 1) {
				CacheHelper.setValue(CacheKey.DEFINE, JSON.toJSONString(result.getData()));
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
