package org.module.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * 类: DateUtil <br>
 * 描述: 时间处理公共类 <br>
 * 作者: zhy<br>
 * 时间: 2016年7月27日 上午9:47:29
 */
public class DateUtil {

	public static final String DATE_FORMAT_DATEONLY = "yyyy-MM-dd"; // 年/月/日

	public static final String DATE_FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss"; // 年/月/日

	public static final SimpleDateFormat sdfDateOnly = new SimpleDateFormat(DateUtil.DATE_FORMAT_DATEONLY);

	public static final SimpleDateFormat sdfDateTime = new SimpleDateFormat(DateUtil.DATE_FORMAT_DATETIME);

	/**
	 * 
	 * 方法: getSysDate <br>
	 * 描述: 获取当前系统日期 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年8月1日 上午7:26:21
	 * 
	 * @return
	 */
	public static String getSysDate() {
		return sdfDateOnly.format(new Date());
	}

	/**
	 * 
	 * 方法: getSysDateTime <br>
	 * 描述: 获取当前系统时间 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年8月1日 上午7:26:54
	 * 
	 * @return
	 */
	public static String getSysDateTime() {
		return sdfDateTime.format(new Date());
	}

	/**
	 * 
	 * 方法: dateToString <br>
	 * 描述: 将日期转换为字符串 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年8月1日 上午7:29:44
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date) {
		return sdfDateOnly.format(date);
	}

	/**
	 * 
	 * 方法: dateToString <br>
	 * 描述: 将时间转换为字符串 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年8月1日 上午7:27:33
	 * 
	 * @param date
	 * @return
	 */
	public static String dateTimeToString(Date dateTime) {
		return sdfDateTime.format(dateTime);
	}

	/**
	 * 
	 * 方法: strToDate <br>
	 * 描述: 将字符串转换为日期 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年8月1日 上午7:30:13
	 * 
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	public static Date strToDate(String str) throws ParseException {
		return sdfDateOnly.parse(str);
	}

	/**
	 * 
	 * 方法: strToDateTime <br>
	 * 描述: 将字符串转换为时间 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年8月1日 上午7:31:15
	 * 
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	public static Date strToDateTime(String str) throws ParseException {
		return sdfDateTime.parse(str);
	}
}
