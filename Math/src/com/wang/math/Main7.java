package com.wang.math;

import java.util.Scanner;

public class Main7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int m = scan.nextInt();
		int[] num = new int[m];
		for(int i = 0;i<num.length;i++){
			num[i] = scan.nextInt();
		}
		System.out.println(getString(num));
			

	}
	public static int getString(int[] n){
		int min = 0;
		int max = 0;
		
		for(int i = 0;i<n.length;i++){
			min = n[i];
			for(int j =1;j<n.length-i;j++){
				min = Math.min(min, n[i+j-1]);
				max = Math.max(max, j*min);
			}
		}
		
		return max;
	}
	
}
