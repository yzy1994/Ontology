package com.shu.sil.eo.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;



public class DateUtil {

	private final static DateFormat timeFormat = new SimpleDateFormat("HH:mm");
	private final static DateFormat timeFormatSecond = new SimpleDateFormat(
			"HH:mm:ss");
	private final static int oneMinute = 60000;

	public static enum DateUnit {
		DATE_HOUR, DATE_MINUTE, DATE_SECOND
	}

	public static Date getDayEnd(Date date) {
		if (date == null)
			return null;
		Calendar calendar = DateUtils.toCalendar(date);
		calendar.set(Calendar.HOUR_OF_DAY,
				calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE,
				calendar.getActualMaximum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND,
				calendar.getActualMaximum(Calendar.SECOND));
		// 因为当前项目使用的是SqlServer，在处理999毫秒时，数据库会把日期变为后面一天，所以需要使用998毫秒做为结束
		calendar.set(Calendar.MILLISECOND,
				calendar.getActualMaximum(Calendar.MILLISECOND) - 1);
		return calendar.getTime();
	}

	/**
	 * 判断日期字符串是否为正确的字符串
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
//	public static boolean isValidDateStr(String date, String pattern) {
//		try {
//			Date d = DateUtils.parseDate(date, pattern);
//			String date2 = com.philips.ci.core.util.DateUtils.formatDate(d,
//					pattern);
//			return StringUtils.equals(date, date2);
//		} catch (Exception ex) {
//			return false;
//		}
//	}

	/**
	 * Merge time part into target date.
	 * 
	 * @param targetDate
	 *            the date to be merged
	 * @param targetTime
	 *            the time to be merged into date
	 * @return merged date
	 */
	public static Date mergeTimeToDate(Date targetDate, String targetTime) {
		if (targetDate == null) {
			return targetDate;
		}

		if (StringUtils.isNotBlank(targetTime)) {
			Date time = null;
			try {
				time = timeFormat.parse(targetTime);
			} catch (ParseException e) {
				// if cannot parse the string to date, return original target
				// date
				return targetDate;
			}
			// merge hour and minute
			targetDate.setHours(time.getHours());
			targetDate.setMinutes(time.getMinutes());
		}

		return targetDate;
	}

	public static Date mergeSecondTimeToDate(Date targetDate, String targetTime) {
		if (targetDate == null) {
			return targetDate;
		}
		if (targetTime == null) {
			targetTime = "00:00:00";
		}
		if (StringUtils.isNotBlank(targetTime.trim())) {
			Date time = null;
			try {
				time = timeFormatSecond.parse(targetTime.replaceAll(" ", ""));
			} catch (ParseException e) {
				// if cannot parse the string to date, return original target
				// date
				return targetDate;
			}
			// merge hour and minute
			targetDate.setHours(time.getHours());
			targetDate.setMinutes(time.getMinutes());
			targetDate.setSeconds(time.getSeconds());
		}

		return targetDate;
	}

	/**
	 * Split time part from date and return time as String format.
	 * 
	 * @param targetDate
	 *            the date to be split time part
	 * @return String format of time; return Empty string if target date is null
	 */
	public static String splitTimeFromDate(Date targetDate) {
		String time = StringUtils.EMPTY;
		if (targetDate == null) {
			return time;
		}

		time = timeFormat.format(targetDate);
		return time;
	}

	public static String splitSecondTimeFromDate(Date targetDate) {
		String time = StringUtils.EMPTY;
		if (targetDate == null) {
			return time;
		}

		time = timeFormatSecond.format(targetDate);
		return time;
	}

	public static DateFormat getTimeformatsecond() {
		return timeFormatSecond;
	}

	public static Double getTimeSpanValueString(Date startTime, Date endTime,
			DateUnit dateUnit, String format) throws Exception {
		if (null == startTime || null == endTime)
			throw new Exception("Parameter is null");
		Double timeSpanDouble;
		switch (dateUnit) {
		case DATE_HOUR:
			timeSpanDouble = (endTime.getTime() - startTime.getTime()) / 1000.0 / 60.0 / 60.0;
			break;
		case DATE_MINUTE:
			timeSpanDouble = (endTime.getTime() - startTime.getTime()) / 1000.0 / 60.0;
			break;
		case DATE_SECOND:
		default:
			timeSpanDouble = (endTime.getTime() - startTime.getTime()) / 1000.0;
		}
		DecimalFormat fm = new DecimalFormat(format);
		String parsedDoubleValue = fm.format(timeSpanDouble);
		Double doubleValue = fm.parse((String) parsedDoubleValue).doubleValue();
		return doubleValue;
	}

	/**
	 * 将长时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param dateDate
	 * @return
	 */
	public static String dateToStrLong(Date dateDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(dateDate);
		return dateString;
	}
	public static String dateToYearMonthDay(Date dateDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd ");
		String dateString = formatter.format(dateDate);
		return dateString;
	}
    
	/**
	 * Date转String
	 * 
	 * @param count
	 * @return
	 */
	public static Date StringToDate(String dateStr) {
		DateFormat dd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = dd.parse(dateStr);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	public static Date StringToDateNosecond(String dateStr) {
		DateFormat dd = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = null;
		try {
			date = dd.parse(dateStr);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	public static Date StringToDateAddMinute(String dateStr) {
		Date date = DateUtil.StringToDateNosecond(dateStr);
		Date newDate = new Date(date.getTime() + oneMinute);
		return newDate;
	}

	public static String getEndTimeStr() {

		Calendar calendar = DateUtil.getNextDayBeginTime();

		String endTimeStr = dateFormatSpecial.format(calendar.getTime());

		return endTimeStr;

	}

	static SimpleDateFormat dateFormatSpecial = new SimpleDateFormat(
			"yyyy-MM-dd 00:00:00");

	public static String getBeginTimeStr(String timeSectionType) {

		Calendar calendar = DateUtil.getNextDayBeginTime();
		String beginTimeStr = "";
		if (timeSectionType.equals("101")) {
			calendar.add(Calendar.DATE, -1);

		} else if (timeSectionType.equals("102")) {
			calendar.add(Calendar.DATE, -3);

		} else if (timeSectionType.equals("103")) {
			calendar.add(Calendar.WEEK_OF_YEAR, -1);
		} else if (timeSectionType.equals("104")) {
			calendar.add(Calendar.WEEK_OF_YEAR, -4);
		} else if (timeSectionType.equals("105")) {
			calendar.add(Calendar.YEAR, -1);
		}

		beginTimeStr = dateFormatSpecial.format(calendar.getTime());

		return beginTimeStr;

	}

	public static Calendar getNextDayBeginTime() {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, +1);

		return calendar;

	}

}
