package org.module.model.system.user;

import java.util.List;

import org.module.base.model.BaseModel;

/**
 * 
 * 类: SmUser <br>
 * 描述: 用户表 <br>
 * 作者: zhy<br>
 * 时间: 2017年10月23日 上午10:17:32
 */
public class SmUser extends BaseModel {

	private static final long serialVersionUID = -595306086465748400L;

	private String userName;

	private String password;

	private String realName;

	private String headPic;

	private String phone;

	private String eMail;

	private String qq;

	private String weChat;

	private String status;

	private List<SmRole> roles;

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
		this.status = user.getStatus();
		this.roles = user.getRoles();
	}

	public List<SmRole> getRoles() {
		return roles;
	}

	public void setRoles(List<SmRole> roles) {
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