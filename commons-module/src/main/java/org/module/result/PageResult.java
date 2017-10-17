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
public class PageResult extends BaseResult {

	private List<? extends BaseModel> rows;

	private Integer total;

	public List<? extends BaseModel> getRows() {
		return rows;
	}

	public void setRows(List<? extends BaseModel> rows) {
		this.rows = rows;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

}
