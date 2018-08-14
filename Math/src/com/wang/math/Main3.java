package com.wang.math;

import java.util.Scanner;

public class Main3 {
	 
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int N = scan.nextInt();
			int M = scan.nextInt();
			int[] time = new int[N*2];
			for(int i = 0;i<N*2;i++){
				time[i] = scan.nextInt();				
			}
			System.out.println(getSum(N,M,time));
		}
		
	}
 
	public static int getSum(int n,int m,int[] arr) {
		int sum = 1;
		for(int i = 1; i<n;i++){
			int j= i;
			boolean flag = true;
			
			while(flag){
				if(arr[2*i]<arr[2*j-1]){
					
					i++;
				}else{
					sum++;
					flag = false;
				}
			}
		}
		return sum;
	}
}