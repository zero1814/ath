package org.module.model.system.user;

import java.util.List;

import org.module.commons.annotation.db.Column;
import org.module.commons.annotation.db.Table;
import org.module.commons.annotation.obj.Attribute;
import org.module.model.BaseModel;

@Table(name = "sm_user", database = "systemmodule", comment = "用户表")
public class SmUser extends BaseModel {

	public static final String SUCCESS_STATUS="0";
	
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

	@Column(name = "e_mail", isNull = false, comment = "电子邮箱")
	private String eMail;

	@Column(name = "qq", comment = "qq号码")
	private String qq;

	@Column(name = "we_chat", comment = "微信号")
	private String weChat;
	
	@Column(name = "status", comment = "用户状态")
	private String status;

	public SmUser() {
	}

	public SmUser(SmUser user) {
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.realName = user.getRealName();
		this.headPic = user.getHeadPic();
		this.phone = user.getPhone();
		this.eMail = user.geteMail();
		this.qq = user.getQq();
		this.weChat = user.getWeChat();
		this.status=user.getStatus();
	}

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

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWeChat() {
		return weChat;
	}

	public void setWeChat(String weChat) {
		this.weChat = weChat;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}