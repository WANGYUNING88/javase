package com.wang.math;

import java.util.Scanner;

public class Main8 {

	public static void main(String[] args) {
		Scanner sca2 = new Scanner(System.in);
		int[] c = new int[26];
		for (int i = 0; i < c.length; i++) {

			c[i] = sca2.nextInt();
		}
		Scanner sca1 = new Scanner(System.in);
		String str = sca1.nextLine();

		int sum = 0;
		int cout = 1;
		char[] s = str.toCharArray();
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < 26; j++) {
				if (s[i] == j + 97) {
					sum += c[j];
                    if (sum > 100) {
                        sum = sum-100;
                        cout++;
                    }
				}
			}

			

		}

		System.out.print(cout+" ");
		System.out.print(sum);
	}

}