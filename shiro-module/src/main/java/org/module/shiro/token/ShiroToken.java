package org.module.shiro.token;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 
 * 类: ShiroToken <br>
 * 描述: Shiro token <br>
 * 作者: zhy<br>
 * 时间: 2017年6月30日 下午2:10:47
 */
public class ShiroToken extends UsernamePasswordToken implements java.io.Serializable {

	private static final long serialVersionUID = 395706601274116170L;

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
