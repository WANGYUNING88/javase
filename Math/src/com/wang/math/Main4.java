package com.wang.math;

import java.util.Scanner;

public class Main4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int m = scan.nextInt();
			int[][] num = new int[m][2];
			for(int i = 0;i<m;i++){
				for(int j=0;j<2;j++){
					num[i][j] = scan.nextInt();
				}
			}
			

		}
	}
	public static String[] getString(String str){
		String[] numStr = str.split(";");
		return numStr;
	}
	public static int[][] getInt(String str){
		String[] numStr = str.split(",");
		return null;
	}
}
