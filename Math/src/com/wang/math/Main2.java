package com.wang.math;

import java.util.Scanner;

public class Main2 {
	 
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int n = scan.nextInt();
			System.out.println(getSum(n));
		}
	}
 
	public static int getSum(int n) {
		int sum = -1;
		int a = 0;
		int b = 0;
		int m = n / 8;
		for (int i = m; i >= 0; i--) {
			if ((n - 8 * i) % 6 == 0) {
				b = (n - 8 * i) / 6;
				a = i;
				sum = a + b;
				break;
			}
		}
		return sum;
	}
}
