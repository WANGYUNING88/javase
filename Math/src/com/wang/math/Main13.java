package com.wang.math;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		      
        
		while(scan.hasNext()){
	        String ab = scan.nextLine();  
	        String[] abc = ab.split(" ");
	        String a = abc[0];
	        String b = abc[1];
	        String c = abc[2];
	        
	        System.out.println(getMath(a,b,c));
		}
	}
	
	public static String getMath(String a,String b,String c){
		String a1 = String.valueOf(a.charAt(a.length()-1));
		String a2 = String.valueOf(b.charAt(0));
		String b1 = String.valueOf(b.charAt(b.length()-1));
		String b2 = String.valueOf(c.charAt(0));
		
		if(a1.equals(a2)&&b1.equals(b2))
			return "YES";
		else
			return "NO";
				
		
	}

	
	
}