package org.module.commons.result;

import java.util.List;

import org.module.commons.base.BaseResult;

/**
 * 
 * 类: DataResult <br>
 * 描述: 获取对象 <br>
 * 作者: zhy<br>
 * 时间: 2016年10月24日 上午7:33:55
 * @param <T>
 */
public class PageResult<T> extends BaseResult {

	private List<T> data;

	private Integer total;

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

}
