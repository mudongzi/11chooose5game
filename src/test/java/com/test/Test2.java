package com.test;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Math.random() * 100);

		String str = "02,04,11,10,08";
		String[] arr = str.split(",");
		for (String string : arr) {
			System.out.println(string);
		}

	}

}
