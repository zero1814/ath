package org.module.base.result;

import java.util.List;

import org.module.base.model.BaseModel;

/**
 * 
 * 类: BaseResult <br>
 * 描述: 数据集合处理结果 <br>
 * 作者: zhy<br>
 * 时间: 2016年9月17日 下午5:22:04
 */
public class DataResult extends BaseResult {

	private List<? extends BaseModel> data;

	public List<? extends BaseModel> getData() {
		return data;
	}

	public void setData(List<? extends BaseModel> data) {
		this.data = data;
	}

}
