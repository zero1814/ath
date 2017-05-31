package org.module.model.system.user;

import java.util.List;

import org.module.commons.annotation.db.Column;
import org.module.commons.annotation.db.Table;
import org.module.commons.annotation.obj.Attribute;
import org.module.model.BaseModel;

@Table(name = "sm_user", database = "systemmodule", comment = "用户表")
public class SmUser extends BaseModel {

	@Column(name = "user_name", isNull = false, comment = "用户名")
	private String userName;

	@Column(name = "password", isNull = false, comment = "密码")
	private String password;

	@Column(name = "real_name", isNull = false, comment = "真实姓名")
	private String realName;

	@Column(name = "head_pic", isNull = false, comment = "头像")
	private String headPic;

	@Column(name = "phone", isNull = false, comment = "手机号")
	private String phone;

	@Column(name = "mail", isNull = false, comment = "电子邮箱")
	private String mail;

	@Column(name = "qq", comment = "qq号码")
	private String qq;

	@Column(name = "weixin", comment = "微信号")
	private String weixin;

	/**
	 * 用户角色
	 */
	@Attribute(name = "roles", description = "用户角色列表")
	private List<SmUserRole> roles;

	public List<SmUserRole> getRoles() {
		return roles;
	}

	public void setRoles(List<SmUserRole> roles) {
		this.roles = roles;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getHeadPic() {
		return headPic;
	}

	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

}