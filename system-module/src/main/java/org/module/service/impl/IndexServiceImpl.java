package org.module.service.impl;

import org.module.result.index.IndexResult;
import org.module.service.IndexService;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: IndexServiceImpl <br>
 * 描述: 首页加载初始化 <br>
 * 作者: zhy<br>
 * 时间: 2017年1月3日 上午9:01:56
 */
@Service
public class IndexServiceImpl implements IndexService {

	/**
	 * 
	 * 方法: init <br>
	 * 
	 * @param userCode
	 * @return
	 * @see org.module.service.IndexService#init(java.lang.String)
	 */
	@Override
	public IndexResult init(String userCode) {
		IndexResult result = new IndexResult();
		return result;
	}

}
