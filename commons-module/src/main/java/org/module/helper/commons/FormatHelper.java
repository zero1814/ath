package org.module.helper.commons;

/**
 * 
 * 类: FormatHelper <br>
 * 描述: 转换帮助类 <br>
 * 作者: zhy<br>
 * 时间: 2016年10月24日 上午11:34:34
 */
public class FormatHelper {

	/**
	 * 
	 * 方法: formatString <br>
	 * 描述: 格式化字符串 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年10月24日 上午11:34:04
	 * 
	 * @param sBaseString
	 *            输入字符串
	 * @param sFromStrings
	 *            替换字符串组
	 * @return 返回替换后结果
	 */
	public static String formatString(String str, Object... params) {
		for (int i = 0, j = str.length(); i < j; i++) {
			str = str.replace("{" + (i) + "}", params[i].toString());
		}
		return str;
	}
}
