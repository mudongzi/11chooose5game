package com.test;

public class Demo {

	public static void main(String[] args) {

		long min = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			// System.out.println(getIssue());
			getis();
			// System.out.println(getis());
		}
		long max = System.currentTimeMillis();

		System.out.println(max - min);
	}

	public static String getIssue() {
		String[] arr = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11" };
		StringBuffer sb = new StringBuffer();
		int x = 0;
		do {
			int num = (int) (Math.random() * 11);
			if (arr[num] != null) {
				sb.append(arr[num]);
				if (x < 4) {
					sb.append(',');
				}
				arr[num] = null;
				x++;
			}
		} while (x < 5);
		return sb.toString();
	}

	private final static String[] arrys = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11" };
	private final static String[] arr = new String[5];

	public static String getis() {
		int x = 0;
		boolean flag = true;
		do {
			int num = (int) (Math.random() * 11);
			for (int i = 0; i < arr.length; i++) {
				if (arrys[num].equals(arr[i])) {
					flag = false;
					break;
				}
			}
			if (flag) {
				arr[x] = arrys[num];
				x++;
			}
			flag = true;
		} while (x < 5);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
			arr[i] = null;
			if (i < 4) {
				sb.append(',');
			}
		}
		return sb.toString();
	}
}
