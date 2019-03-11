package org.lot.lotfilter.util;

/**
 * Description:
 *
 * @Title: RandomNumber
 * @author moinros
 * @date 2019年1月31日 下午8:21:48
 */
public class RandomNumber {

	// 要求:从数组中随机获取5个不重复的字符串；并将这5个字符串拼接成一个新的字符串;每个子串以逗号隔开
	private final static String[] arrys = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11" };
	private static int[] code = { -1, -1, -1, -1, -1 };
	private static String[] issue = new String[5];

	/**
	 * Description:
	 *
	 * @Method 方法名 <getCode3>
	 * @return [String]
	 */
	public static String[] getIssueCode() {
		code[0] = (int) (Math.random() * 11);
		c: for (int i = 1; i < 5;) {
			code[i] = (int) (Math.random() * 11);
			for (int j = 0; j < i; j++) {
				if (code[j] == code[i]) {
					continue c;
				}
			}
			i++;
		}
		for (int i = 0; i < issue.length; i++) {
			issue[i] = arrys[code[i]];
		}
		return issue;
	}

}
