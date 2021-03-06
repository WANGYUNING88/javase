package com.wang.example;

import java.util.Scanner;

public class Yanghuisanjiao {
	public static void main(String[] args)

	{

		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.print("请输入行数：");
			int n = sc.nextInt();

			int[][] arr = new int[n][n];

			// 遍历数组，把第一列和最后一列的数改成1
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j <= i; j++) {
					if (j == 0 || j == i) {
						arr[i][j] = 1;
					} else {
						arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
					}
				}
			}

			// 遍历数组，输出杨辉三角形
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j <= i; j++) {
					System.out.print(arr[i][j] + "\t");
				}
				System.out.println();
			}
		}
	}

}
