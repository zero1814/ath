package org.module.result;

import java.util.List;

import org.module.model.BaseModel;

/**
 * 
 * 类: TreeResult <br>
 * 描述: 树型菜单结果集 <br>
 * 作者: zhy<br>
 * 时间: 2017年6月12日 上午11:02:48
 */
public class TreeResult extends RootResult {

	private String treeCode;
	private String treeText;

	private List<? extends BaseModel> data;

	public String getTreeCode() {
		return treeCode;
	}

	public void setTreeCode(String treeCode) {
		this.treeCode = treeCode;
	}

	public String getTreeText() {
		return treeText;
	}

	public void setTreeText(String treeText) {
		this.treeText = treeText;
	}

	public List<? extends BaseModel> getData() {
		return data;
	}

	public void setData(List<? extends BaseModel> data) {
		this.data = data;
	}

}
