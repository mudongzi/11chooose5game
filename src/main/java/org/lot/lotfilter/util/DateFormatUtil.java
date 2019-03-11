package org.lot.lotfilter.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description:操作时间日期的工具类
 *
 * @author moinros
 * @Title: DateFormatUtil
 * @date 2018年12月21日
 */
public class DateFormatUtil {

	/** TIME_Y_M_D 年月日 的字符串格式 */
	public static final String TIME_Y_M_D = "yyyy-MM-dd";

	/** TIME_Y_M_D_H_M_S 年月日+时分秒 的字符串格式 */
	public static final String TIME_Y_M_D_H_M_S = "yyyy-MM-dd HH:mm:ss";

	/** TIME_H_M_S 时分秒 的字符串格式 */
	public static final String TIME_H_M_S = "HH:mm:ss";

	private DateFormatUtil() {
		// 构造方法私有化
	}

	public static void main(String[] args) {
		System.out.println(stringToDate("2019-01-16 15:50:58", TIME_Y_M_D_H_M_S));
	}

	/**
	 * Description: 获取当前时间(年+月+日,时+分+秒)；以字符串形式。
	 *
	 * @Method getCurrentTime
	 *
	 * @return String 当前时间（年月日+时分秒 的字符串格式）
	 */
	public static String getCurrentTime() {
		return dateToString(new Date(), TIME_Y_M_D_H_M_S);
	}

	/**
	 * Description: 获取当前时间(时+分+秒)；以字符串形式。
	 * 
	 * @return 当前时间（时分秒 的字符串格式）
	 */
	public static String getNowTime() {
		return dateToString(new Date(), TIME_H_M_S);
	}

	/**
	 * Description: 获取当前日期(年+月+日)；以字符串形式。
	 * 
	 * @return 当前日期间（年月日 的字符串格式）
	 */
	public static String getCurrentDate() {
		return dateToString(new Date(), TIME_Y_M_D);
	}

	/**
	 * Description: 把时间转换成指定的字符串格式
	 * 
	 * @param date    要转换的时间
	 * @param pattern 转换的格式
	 * @return 转换后的时间字符串
	 */
	public static String dateToString(Date date, String pattern) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(date);
	}

	/**
	 * Description: 把字符串转换成指定的时间格式
	 * 
	 * @param dateString 要转换的字符串格式时间
	 * @param pattern    转换的格式
	 * @return 转换后的时间
	 */
	public static Date stringToDate(String dateString, String pattern) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		try {
			return simpleDateFormat.parse(dateString);
		} catch (ParseException e) {

			throw new RuntimeException("转换时间失败，请检查转换参数是否正确。");
		}
	}

	/**
	 * Description: 传入一个指定时间；获取指定间隔时间的后的一个时间 (如:获取下一天 的时间)
	 * 
	 * @param date 需要操作的时间
	 * @param time 间隔时间
	 * @return 新的时间
	 */
	public static Date dateOperation(Date date, long time) {
		long oldTime = date.getTime();
		long newTime = oldTime + time;
		return new Date(newTime);
	}

	/**
	 * Description: 计算两个时间的时间差
	 * 
	 * @param minDate 小的时间
	 * @param maxDate 大的时间
	 * @return 时间差
	 */
	public static long getDateDifference(Date minDate, Date maxDate) {
		return maxDate.getTime() - minDate.getTime();
	}

}
