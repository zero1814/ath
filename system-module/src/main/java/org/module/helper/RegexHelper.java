package org.module.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * 类: RegexHelper <br>
 * 描述: 正则表达式验证 <br>
 * 作者: zhy<br>
 * 时间: 2017年10月11日 上午9:10:48
 */
public class RegexHelper {

	/**
	 * 
	 * 方法: password <br>
	 * 描述: 判断密码组成是否符合规则 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年10月13日 上午8:51:03
	 * @param str
	 * @return
	 */
	public static boolean password(String str) {
		String pattern = PropHelper.getConfig("");
		boolean flag = false;
		try {
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(str);
			flag = m.matches();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 
	 * 方法: isNumber <br>
	 * 描述: 判断字符串是否为数字 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年10月13日 上午8:50:01
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {
		String pattern = "";
		boolean flag = false;
		try {
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(str);
			flag = m.matches();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 
	 * 方法: isEmail <br>
	 * 描述: 验证是否是有效url地址 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年10月11日 上午9:12:22
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String str) {
		String pattern = "^((https|http|ftp|rtsp|mms)?:\\/\\/)[^\\s]+";
		boolean flag = false;
		try {
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(str);
			flag = m.matches();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
