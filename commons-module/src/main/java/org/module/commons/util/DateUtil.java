package org.module.commons.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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

	/**
	 * ================= 周计算及转换 =============
	 */

	/**
	 * 
	 * 方法: getWeekOfYear <br>
	 * 描述: 获取当前时间所在年的周数 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年10月16日 上午11:23:37
	 * 
	 * @param date
	 * @return
	 */
	public static int getWeekOfYear(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setMinimalDaysInFirstWeek(7);
		c.setTime(date);
		return c.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * 
	 * 方法: getMaxWeekNumOfYear <br>
	 * 描述: 获取当前时间所在年的最大周数 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年10月16日 上午11:23:59
	 * 
	 * @param year
	 * @return
	 */
	public static int getMaxWeekNumOfYear(int year) {
		Calendar c = new GregorianCalendar();
		c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);
		return getWeekOfYear(c.getTime());
	}

	/**
	 * 
	 * 方法: getFirstDayOfWeek <br>
	 * 描述: 获取某年的第几周的开始日期 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年10月16日 上午11:24:19
	 * 
	 * @param year
	 * @param week
	 * @return
	 */
	public static Date getFirstDayOfWeek(int year, int week) {
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, Calendar.JANUARY);
		c.set(Calendar.DATE, 1);
		Calendar cal = (GregorianCalendar) c.clone();
		cal.add(Calendar.DATE, week * 7);
		return getFirstDayOfWeek(cal.getTime());
	}

	/**
	 * 
	 * 方法: getLastDayOfWeek <br>
	 * 描述: 获取某年的第几周的结束日期 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年10月16日 上午11:24:55
	 * @param year
	 * @param week
	 * @return
	 */
	public static Date getLastDayOfWeek(int year, int week) {
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, Calendar.JANUARY);
		c.set(Calendar.DATE, 1);
		Calendar cal = (GregorianCalendar) c.clone();
		cal.add(Calendar.DATE, week * 7);
		return getLastDayOfWeek(cal.getTime());
	}

	/**
	 * 
	 * 方法: getFirstDayOfWeek <br>
	 * 描述: 获取当前时间所在周的开始日期 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年10月16日 上午11:24:47
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDayOfWeek(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
		return c.getTime();
	}

	/**
	 * 
	 * 方法: getLastDayOfWeek <br>
	 * 描述: 获取当前时间所在周的结束日期 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年10月16日 上午11:24:41
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfWeek(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
		return c.getTime();
	}
}
