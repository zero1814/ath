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
	 * 
	 * @param str
	 * @return
	 */
	public static boolean password(String str) {
		String pattern = PropHelper.getConfig("password");
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
		String pattern = "\\\\w[-\\\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\\\.)+[A-Za-z]{2,14}";
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
	 * 方法: isIdentificationCard <br>
	 * 描述: 身份证是否正确 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年10月13日 上午10:45:45
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isIdentificationCard(String str) {
		String pattern = "\\\\d{17}[\\\\d|x]|\\\\d{15}";
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
	 * 方法: isPhone <br>
	 * 描述: 手机号是否正确（国内） <br>
	 * 作者: zhy<br>
	 * 时间: 2017年10月13日 上午10:41:14
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isPhone(String str) {
		String pattern = "0?(13|14|15|18)[0-9]{9}";
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
	 * 方法: isUrl <br>
	 * 描述: url地址是否书写正确 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年10月13日 上午10:40:31
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isUrl(String str) {
		String pattern = "^((https|http|ftp|rtsp|mms)?:\\\\/\\\\/)[^\\\\s]+";
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
	 * 方法: isIP <br>
	 * 描述: ip地址是否正确 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年10月13日 上午10:47:58
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isIP(String str) {
		String pattern = "(25[0-5]|2[0-4]\\\\d|[0-1]\\\\d{2}|[1-9]?\\\\d)\\\\.(25[0-5]|2[0-4]\\\\d|[0-1]\\\\d{2}|[1-9]?\\\\d)\\\\.(25[0-5]|2[0-4]\\\\d|[0-1]\\\\d{2}|[1-9]?\\\\d)\\\\.(25[0-5]|2[0-4]\\\\d|[0-1]\\\\d{2}|[1-9]?\\\\d)";
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
	 * 方法: isDate <br>
	 * 描述: 时间格式是否正确 默认 2017-10-13 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年10月13日 上午10:38:59
	 * 
	 * @param str
	 * @return
	 */
	public static boolean dateFormat(String str) {
		String pattern = "\\d{4}(\\-|\\/|.)\\d{1,2}\\1\\d{1,2}";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(str);
		return m.matches();
	}

	public static void main(String args[]) {
		String str = "19880520";
		String pattern = "\\d{4}(\\-|\\/|.)\\d{1,2}\\1\\d{1,2}";

		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(str);
		System.out.println(m.matches());
	}
}
