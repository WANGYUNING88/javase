package com.wang.math;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
        int m = scan.nextInt();
        int n = scan.nextInt();     
        
        int[] num = new int[m];
        for (int i =0;i<num.length;i++){
        	num[i] = scan.nextInt();  
        }
        
        System.out.println(getMath(m,n));
	}
	
	public static int getMath(int m,int n){
		if(m == 1)
			return 1;

		else if((m-1)%(n-1)==0){
			return (m-1)/(n-1);
		}else{
			return (m-1)/(n-1)+1;
		}
		
	}

	
	
}
