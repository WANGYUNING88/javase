package com.wang.example;

import java.util.Scanner;

public class Yanghuisanjiao {
	public static void main(String[] args)

	{

		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.print("������������");
			int n = sc.nextInt();

			int[][] arr = new int[n][n];

			// �������飬�ѵ�һ�к����һ�е����ĳ�1
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j <= i; j++) {
					if (j == 0 || j == i) {
						arr[i][j] = 1;
					} else {
						arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
					}
				}
			}

			// �������飬������������
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j <= i; j++) {
					System.out.print(arr[i][j] + "\t");
				}
				System.out.println();
			}
		}
	}

}