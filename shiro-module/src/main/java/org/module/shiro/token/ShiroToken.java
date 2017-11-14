package org.module.shiro.token;

import java.io.Serializable;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 
 * 类: ShiroToken <br>
 * 描述: Shiro token <br>
 * 作者: zhy<br>
 * 时间: 2017年11月13日 下午4:00:56
 */
public class ShiroToken extends UsernamePasswordToken implements Serializable {

	private static final long serialVersionUID = -6189747116637921672L;

	public ShiroToken(String username, String pswd) {
		super(username, pswd);
		this.pswd = pswd;
	}

	/** 登录密码[字符串类型] 因为父类是char[] ] **/
	private String pswd;

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
}
