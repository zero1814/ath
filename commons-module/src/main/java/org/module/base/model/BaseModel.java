package org.module.base.model;

import java.io.Serializable;

import org.module.annotation.validation.Insert;
import org.module.annotation.validation.Update;

/**
 * 
 * 类: BaseModel <br>
 * 描述: 持久化对象基类 <br>
 * 作者: zhy<br>
 * 时间: 2016年7月27日 上午9:32:32
 */
public class BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String uid;

	@Insert(alert = "编码不能为空", notNull = true)
	private String code;

	@Insert(alert = "创建人不能为空", notNull = true)
	private String createUser;

	@Insert(alert = "创建时间不能为空", notNull = true)
	private String createTime;

	@Insert(alert = "修改人不能为空", notNull = true)
	@Update(alert = "修改人不能为空", notNull = true)
	private String updateUser;

	@Insert(alert = "修改时间不能为空", notNull = true)
	@Update(alert = "修改时间不能为空", notNull = true)
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
