package com.wang.math;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
        int m = scan.nextInt();
        int n = scan.nextInt();     
        
        
        System.out.println(getMath(m,n));
	}
	
	public static String getMath(int m,int n){

		if( m*Math.log(n)>m*Math.log(n))
			return ">";
		else if( m*Math.log(n)==m*Math.log(n))
			return "=";
		
		else
			return "<";
		
	}

	
	
}