package org.module.base.result;
/**
 * 
 * 类: FileResult <br>
 * 描述: 文件操作结果集 <br>
 * 作者: zhy<br>
 * 时间: 2017年11月7日 下午2:31:10
 */

import java.util.List;

import org.module.base.model.FileModel;

public class FileResult extends BaseResult {

	private List<FileModel> list;

	public List<FileModel> getList() {
		return list;
	}

	public void setList(List<FileModel> list) {
		this.list = list;
	}

}
