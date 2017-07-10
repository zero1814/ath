package org.module.model.db;

import org.module.model.BaseModel;

/**
 * 
 * 类: DmDatabase <br>
 * 描述: 数据库维护表 <br>
 * 作者: zhy<br>
 * 时间: 2017年4月27日 上午9:36:40
 */
public class DmDatabase extends BaseModel {

	private static final long serialVersionUID = -8642350631705283190L;

	private String name;

	private String enName;

	private String url;

	private String comment;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}