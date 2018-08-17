package com.wang.math;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		      
        
		while(scan.hasNext()){
			int n = scan.nextInt();
			int[] stus = new int[n];
			for(int i =0;i<stus.length;i++){
				stus[i] = scan.nextInt();
			}
			int k = scan.nextInt();
			int d = scan.nextInt();
			System.out.println(getMath(stus,k,d));
		}
	}
	public static int getMath(int[] stus,int k,int d){
		int max = 0;

		if(k==1){
			for(int i = 0;i<stus.length-k;i++){
				max = Math.max(max, stus[i]);
			}
		
		
	}
		return max;
	
//	public static int getNum(int[] stus,int index,int d){
//		
//		
//		
//	}
	}
	
}
