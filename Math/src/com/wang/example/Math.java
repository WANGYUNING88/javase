package com.wang.example;

public class Math {

	public static String isSanjiaoxing(float a, float b, float c) {

		String result = "不是";

		if (a != 0 || b != 0 || c != 0) {

			if (a + b > c && a + c > b && b + c > a) {
				result = "是";
				return result;

			}

			return result;
		}

		return result;

	}

	public static String isRunnian(Long year) {
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			return (year + "年是闰年！");
		} else {
			return (year + "年是平年！");
		}

	}

	public static double toRadians(double angle) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static double cos(double radian) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static double sin(double radian) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static int min(int wid, int hei) {
		// TODO Auto-generated method stub
		return 0;
	}

}
