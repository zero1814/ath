package org.module.model.education;

import org.module.model.BaseModel;

/**
 * 
 * 类: EmUserExtend <br>
 * 描述: 用户扩展表 <br>
 * 作者: zhy<br>
 * 时间: 2017年3月23日 下午5:54:07
 */
public class EmUserExtend extends BaseModel {

	/**
	 * 真实姓名
	 */
	private String realName;

	/**
	 * 微信
	 */
	private String wechat;

	/**
	 * 微博
	 */
	private String microblog;

	/**
	 * qq
	 */
	private String qq;

	/**
	 * 头像
	 */
	private String headPic;

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getMicroblog() {
		return microblog;
	}

	public void setMicroblog(String microblog) {
		this.microblog = microblog;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getHeadPic() {
		return headPic;
	}

	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}

}