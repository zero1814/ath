package org.module.util;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.module.helper.LoggerHelper;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class StringUtils extends org.apache.commons.lang3.StringUtils {

	/**
	 * 
	 * 方法: isBlank <br>
	 * 描述: 一次性判断多个或单个对象为空。 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月21日 下午5:55:50
	 * 
	 * @param objects
	 * @return 只要有一个元素为Blank，则返回true
	 */
	public static boolean isBlank(Object... objects) {
		Boolean result = false;
		for (Object object : objects) {
			if (null == object || "".equals(object.toString().trim()) || "null".equals(object.toString().trim())) {
				result = true;
				break;
			}
		}
		return result;
	}

	public static String getRandom(int length) {
		String val = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			// 输出字母还是数字
			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			// 字符串
			if ("char".equalsIgnoreCase(charOrNum)) {
				// 取得大写字母还是小写字母
				int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
				val += (char) (choice + random.nextInt(26));
			} else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val.toLowerCase();
	}

	/**
	 * 
	 * 方法: isNotBlank <br>
	 * 描述: 一次性判断多个或单个对象不为空。 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月21日 下午5:56:04
	 * 
	 * @param objects
	 * @return 只要有一个元素不为Blank，则返回true
	 */
	public static boolean isNotBlank(Object... objects) {
		return !isBlank(objects);
	}

	public static boolean isBlank(String... objects) {
		Object[] object = objects;
		return isBlank(object);
	}

	public static boolean isNotBlank(String... objects) {
		Object[] object = objects;
		return !isBlank(object);
	}

	public static boolean isBlank(String str) {
		Object object = str;
		return isBlank(object);
	}

	public static boolean isNotBlank(String str) {
		Object object = str;
		return !isBlank(object);
	}

	/**
	 * 
	 * 方法: indexOf <br>
	 * 描述: 判断一个字符串在数组中存在几个 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月21日 下午5:56:18
	 * 
	 * @param baseStr
	 * @param strings
	 * @return
	 */
	public static int indexOf(String baseStr, String[] strings) {

		if (null == baseStr || baseStr.length() == 0 || null == strings)
			return 0;

		int i = 0;
		for (String string : strings) {
			boolean result = baseStr.equals(string);
			i = result ? ++i : i;
		}
		return i;
	}

	/**
	 * 
	 * 方法: isJSONObject <br>
	 * 描述: 判断一个字符串是否为JSONObject,是返回JSONObject,不是返回null <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月21日 下午5:56:27
	 * 
	 * @param args
	 * @return
	 */
	public static net.sf.json.JSONObject isJSONObject(String args) {
		net.sf.json.JSONObject result = null;
		if (isBlank(args)) {
			return result;
		}
		try {
			return net.sf.json.JSONObject.fromObject(args.trim());
		} catch (Exception e) {
			return result;
		}
	}

	/**
	 * 
	 * 方法: isJSONArray <br>
	 * 描述: 判断一个字符串是否为JSONArray,是返回JSONArray,不是返回null <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月21日 下午5:56:35
	 * 
	 * @param args
	 * @return
	 */
	public static net.sf.json.JSONArray isJSONArray(Object args) {
		JSONArray result = new JSONArray();
		if (isBlank(args)) {
			return null;
		}
		if (args instanceof net.sf.json.JSONArray) {

			net.sf.json.JSONArray arr = (net.sf.json.JSONArray) args;
			for (Object json : arr) {
				if (json != null && json instanceof net.sf.json.JSONObject) {
					result.add(json);
					continue;
				} else {
					result.add(JSONObject.fromObject(json));
				}
			}
			return result;
		} else {
			return null;
		}

	}

	public static String trimToEmpty(Object str) {
		return (isBlank(str) ? "" : str.toString().trim());
	}

	/**
	 * 
	 * 方法: getBASE64 <br>
	 * 描述: 将 Strig 进行 BASE64 编码 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月21日 下午5:56:44
	 * 
	 * @param str
	 * @param bf
	 * @return
	 */
	@SuppressWarnings("restriction")
	public static String getBASE64(String str, boolean... bf) {
		if (StringUtils.isBlank(str))
			return null;
		String base64 = new sun.misc.BASE64Encoder().encode(str.getBytes());
		// 去掉 '='
		if (isBlank(bf) && bf[0]) {
			base64 = base64.replaceAll("=", "");
		}
		return base64;
	}

	/**
	 * 
	 * 方法: mapToGet <br>
	 * 描述: 把Map转换成get请求参数类型,如 {"name"=20,"age"=30} 转换后变成 name=20&age=30 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月21日 下午5:56:52
	 * 
	 * @param map
	 * @return
	 */
	public static String mapToGet(Map<? extends Object, ? extends Object> map) {
		String result = "";
		if (map == null || map.size() == 0) {
			return result;
		}
		Set<? extends Object> keys = map.keySet();
		for (Object key : keys) {
			result += ((String) key + "=" + (String) map.get(key) + "&");
		}

		return isBlank(result) ? result : result.substring(0, result.length() - 1);
	}

	/**
	 * 
	 * 方法: getToMap <br>
	 * 描述: 把一串参数字符串,转换成Map 如"?a=3&b=4" 转换为Map{a=3,b=4} <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月21日 下午5:56:59
	 * 
	 * @param args
	 * @return
	 */
	public static Map<String, ? extends Object> getToMap(String args) {
		if (isBlank(args)) {
			return null;
		}
		args = args.trim();
		// 如果是?开头,把?去掉
		if (args.startsWith("?")) {
			args = args.substring(1, args.length());
		}
		String[] argsArray = args.split("&");

		Map<String, Object> result = new HashMap<String, Object>();
		for (String ag : argsArray) {
			if (!isBlank(ag) && ag.indexOf("=") > 0) {

				String[] keyValue = ag.split("=");
				// 如果value或者key值里包含 "="号,以第一个"="号为主 ,如 name=0=3
				// 转换后,{"name":"0=3"}, 如果不满足需求,请勿修改,自行解决.

				String key = keyValue[0];
				String value = "";
				for (int i = 1; i < keyValue.length; i++) {
					value += keyValue[i] + "=";
				}
				value = value.length() > 0 ? value.substring(0, value.length() - 1) : value;
				result.put(key, value);

			}
		}

		return result;
	}

	/**
	 * 
	 * 方法: toUnicode <br>
	 * 描述: 转换成Unicode <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月21日 下午5:57:07
	 * 
	 * @param str
	 * @return
	 */
	public static String toUnicode(String str) {
		String as[] = new String[str.length()];
		String s1 = "";
		for (int i = 0; i < str.length(); i++) {
			int v = str.charAt(i);
			if (v >= 19968 && v <= 171941) {
				as[i] = Integer.toHexString(str.charAt(i) & 0xffff);
				s1 = s1 + "\\u" + as[i];
			} else {
				s1 = s1 + str.charAt(i);
			}
		}
		return s1;
	}

	/**
	 * 
	 * 方法: merge <br>
	 * 描述: 合并数据 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月21日 下午5:57:13
	 * 
	 * @param v
	 * @return
	 */
	public static String merge(Object... v) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < v.length; i++) {
			sb.append(v[i]);
		}
		return sb.toString();
	}

	/**
	 * 
	 * 方法: strToUrlcode <br>
	 * 描述: 字符串转urlcode <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月21日 下午5:57:21
	 * 
	 * @param value
	 * @return
	 */
	public static String strToUrlcode(String value) {
		try {
			value = java.net.URLEncoder.encode(value, "utf-8");
			return value;
		} catch (UnsupportedEncodingException e) {
			LoggerHelper.error(StringUtils.class, "字符串转换为URLCode失败,value:" + value);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * 方法: urlcodeToStr <br>
	 * 描述: urlcode转字符串 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月21日 下午5:57:27
	 * 
	 * @param value
	 * @return
	 */
	public static String urlcodeToStr(String value) {
		try {
			value = java.net.URLDecoder.decode(value, "utf-8");
			return value;
		} catch (UnsupportedEncodingException e) {
			LoggerHelper.error(StringUtils.class, "URLCode转换为字符串失败;value:" + value);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * 方法: containsCN <br>
	 * 描述: 判断字符串是否包含汉字 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月21日 下午5:57:35
	 * 
	 * @param txt
	 * @return
	 */
	public static Boolean containsCN(String txt) {
		if (isBlank(txt)) {
			return false;
		}
		for (int i = 0; i < txt.length(); i++) {

			String bb = txt.substring(i, i + 1);

			boolean cc = java.util.regex.Pattern.matches("[\u4E00-\u9FA5]", bb);
			if (cc)
				return cc;
		}
		return false;
	}

	/**
	 * 
	 * 方法: removeHtml <br>
	 * 描述: 去掉HTML代码 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月21日 下午5:57:44
	 * 
	 * @param news
	 * @return
	 */
	public static String removeHtml(String news) {
		String s = news.replaceAll("amp;", "").replaceAll("<", "<").replaceAll(">", ">");

		Pattern pattern = Pattern.compile("<(span)?\\sstyle.*?style>|(span)?\\sstyle=.*?>", Pattern.DOTALL);
		Matcher matcher = pattern.matcher(s);
		String str = matcher.replaceAll("");

		Pattern pattern2 = Pattern.compile("(<[^>]+>)", Pattern.DOTALL);
		Matcher matcher2 = pattern2.matcher(str);
		String strhttp = matcher2.replaceAll(" ");

		String regEx = "(((http|https|ftp)(\\s)*((\\:)|：))(\\s)*(//|//)(\\s)*)?"
				+ "([\\sa-zA-Z0-9(\\.|．)(\\s)*\\-]+((\\:)|(:)[\\sa-zA-Z0-9(\\.|．)&%\\$\\-]+)*@(\\s)*)?" + "("
				+ "(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])"
				+ "(\\.|．)(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)"
				+ "(\\.|．)(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)"
				+ "(\\.|．)(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])"
				+ "|([\\sa-zA-Z0-9\\-]+(\\.|．)(\\s)*)*[\\sa-zA-Z0-9\\-]+(\\.|．)(\\s)*[\\sa-zA-Z]*" + ")"
				+ "((\\s)*(\\:)|(：)(\\s)*[0-9]+)?" + "(/(\\s)*[^/][\\sa-zA-Z0-9\\.\\,\\?\\'\\\\/\\+&%\\$\\=~_\\-@]*)*";
		Pattern p1 = Pattern.compile(regEx, Pattern.DOTALL);
		Matcher matchhttp = p1.matcher(strhttp);
		String strnew = matchhttp.replaceAll("").replaceAll("(if[\\s]*\\(|else|elseif[\\s]*\\().*?;", " ");

		Pattern patterncomma = Pattern.compile("(&[^;]+;)", Pattern.DOTALL);
		Matcher matchercomma = patterncomma.matcher(strnew);
		String strout = matchercomma.replaceAll(" ");
		String answer = strout.replaceAll("[\\pP‘’“”]", " ").replaceAll("\r", " ").replaceAll("\n", " ")
				.replaceAll("\\s", " ").replaceAll("　", "");

		return answer;
	}

	/**
	 * 
	 * 方法: array2Empty <br>
	 * 描述: 把数组的空数据去掉 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月21日 下午5:57:53
	 * 
	 * @param array
	 * @return
	 */
	public static List<String> array2Empty(String[] array) {
		List<String> list = new ArrayList<String>();
		for (String string : array) {
			if (StringUtils.isNotBlank(string)) {
				list.add(string);
			}
		}
		return list;
	}

	/**
	 * 
	 * 方法: array2Set <br>
	 * 描述: 把数组转换成set <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月21日 下午5:57:59
	 * 
	 * @param array
	 * @return
	 */
	public static Set<?> array2Set(Object[] array) {
		Set<Object> set = new TreeSet<Object>();
		for (Object id : array) {
			if (null != id) {
				set.add(id);
			}
		}
		return set;
	}

	public static String toString(Serializable serializable) {
		if (null == serializable) {
			return null;
		}
		try {
			return (String) serializable;
		} catch (Exception e) {
			return serializable.toString();
		}
	}

}