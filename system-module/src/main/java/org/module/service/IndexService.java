package org.module.service;

import org.module.result.index.IndexResult;

public interface IndexService {

	/**
	 * 
	 * 方法: init <br>
	 * 描述: 初始化系统相关 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年1月3日 上午9:01:31
	 * 
	 * @return
	 */
	IndexResult init(String userCode);
}
