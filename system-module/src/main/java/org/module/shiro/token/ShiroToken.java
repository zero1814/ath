package org.module.shiro.token;

import org.apache.shiro.authc.UsernamePasswordToken;
/**
 * 
 * 类: ShiroToken <br>
 * 描述: Shiro token <br>
 * 作者: zhy<br>
 * 时间: 2017年7月3日 上午10:34:55
 */
public class ShiroToken extends UsernamePasswordToken implements java.io.Serializable {

	private static final long serialVersionUID = -6451794657814516274L;

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
