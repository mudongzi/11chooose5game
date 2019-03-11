package org.lot.lotfilter.util;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * Description:生成随机ID的工具类
 *
 * @author moinros
 * @Title: UidUtil
 * @date 2018年12月21日
 */
public class UidUtil {

	private static final String STR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	// 构造方法私有化
	private UidUtil() {

	}

	/**
	 * Description:返回處理過後的UUID(耗时较长)
	 * 
	 * @return String
	 */
	public static String getUUID() {
		StringBuffer sb = new StringBuffer(UUID.randomUUID().toString());
		for (byte i = 8; i <= 20; i += 4) {
			sb = sb.deleteCharAt(i);
		}
		return sb.toString();
	}

	/**
	 * Description:返回当前时间和一组随机字符串组成的ID
	 * 
	 * @return String
	 */
	public static String getId() {
		StringBuffer sb = new StringBuffer(getTimeId());
		Random random = new Random();
		for (byte i = 0; i < 3; i++) {
			sb.append('-');
			randomChar(random, sb);
		}
		return sb.toString();
	}

	/**
	 * Description: 返回指定长度的随机字符串
	 * 
	 * @param number 字符个数
	 * @return 随机字符串
	 */
	public static String getId(int number) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < number; i++) {
			int num = random.nextInt(STR.length());
			sb.append(STR.charAt(num));
		}
		return sb.toString();
	}

	/**
	 * Description: 返回指定格式的当前时间；和指定长度的随机字符组成的ID;
	 * 
	 * @param pattern 时间的字符串格式
	 * @param number  随机字符个数
	 * @return 随机ID
	 */
	public static String getId(String pattern, int number) {
		StringBuffer sb = new StringBuffer(DateFormatUtil.dateToString(new Date(), pattern));
		sb.append('-');
		Random random = new Random();
		for (int i = 0; i < number; i++) {
			int num = random.nextInt(STR.length());
			sb.append(STR.charAt(num));
		}
		return sb.toString();
	}

	/**
	 * Description: 返回当前时间的数字字符组成的字符串;精确到毫秒
	 * 
	 * @return 当前时间的数字组成的字符串
	 */
	public static String getTimeId() {
		return getTimeId("yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * Description: 返回以指定的时间格式的；当前时间的数字字符组成的字符串
	 * 
	 * @param pattern 时间的字符串格式
	 * @return 当前时间的数字组成的字符串
	 */
	public static String getTimeId(String pattern) {
		String str = DateFormatUtil.dateToString(new Date(), pattern);
		char[] num = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < num.length; i++) {
			if (Character.isDigit(num[i])) {
				sb.append(num[i]);
			}
		}
		return sb.toString();
	}

	/**
	 * Description: 返回一个由5个随机字符串组成的随机ID(速度最快)
	 * 
	 * @return 随机字符串
	 */
	public static String getRId() {
		return getRId(5, 5);
	}

	/**
	 * Description: 返回一个由指定个数的随机字符；指定组数的的随机字符串ID(速度最快)
	 * 
	 * @param max 每组字符串的字符个数
	 * @param number 字符串的组数
	 * @return 随机字符串
	 */
	public static String getRId(int max, int number) {
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (byte i = 0; i < number; i++) {
			if (i > 0) {
				sb.append('-');
			}
			randomChar(random, sb, max);
		}
		return sb.toString();
	}

	/**
	 * Description: 生成一组随机字符串
	 * 
	 * @param random Random对象
	 * @param sb     需要处理的StringBuffer字符串
	 * @return StringBuffer
	 */
	private static StringBuffer randomChar(Random random, StringBuffer sb) {
		randomChar(random, sb, 5);
		return sb;
	}

	/**
	 * Description: 生成一组随机字符串
	 * 
	 * @param random Random对象
	 * @param sb     需要处理的StringBuffer字符串
	 * @param max    字符串长度
	 * @return StringBuffer
	 */
	private static StringBuffer randomChar(Random random, StringBuffer sb, int max) {
		for (int i = 0; i < max; i++) {
			int num = random.nextInt(STR.length());
			sb.append(STR.charAt(num));
		}
		return sb;
	}

}
