package org.module.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * 类: BaseModel <br>
 * 描述: 持久化对象基类 <br>
 * 作者: zhy<br>
 * 时间: 2016年7月27日 上午9:32:32
 */
public class BaseModel {

	@JSONField(name = "id")
	private Integer id;

	@JSONField(name = "uid")
	private String uid;

	@JSONField(name = "create_user")
	private String createUser;

	@JSONField(name = "create_time")
	private String createTime;

	@JSONField(name = "update_user")
	private String updateUser;

	@JSONField(name = "update_time")
	private String updateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

}
