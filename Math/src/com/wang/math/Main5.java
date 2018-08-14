package com.wang.math;

import java.util.Scanner;

public class Main5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int m = scan.nextInt();
			System.out.println(getString(m));
			

		}
	}
	public static int getString(int n){
		int sum = 1;
		if(n==1){
			return sum;
		}
		for(int i = 0;i<n-1;i++){
			sum = sum*2 ;
		}
		
		return sum;
	}
	
}
