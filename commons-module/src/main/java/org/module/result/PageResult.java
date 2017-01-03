package org.module.result;

import java.util.List;

import org.module.model.BaseModel;

/**
 * 
 * 类: PageResult <br>
 * 描述: 分页结果集 <br>
 * 作者: zhy<br>
 * 时间: 2016年10月24日 上午7:33:55
 * 
 * @param <T>
 */
public class PageResult extends RootResult {

	private List<? extends BaseModel> data;

	private Integer total;

	public List<? extends BaseModel> getData() {
		return data;
	}

	public void setData(List<? extends BaseModel> data) {
		this.data = data;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

}
