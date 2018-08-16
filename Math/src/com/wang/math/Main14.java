package com.wang.math;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		      
        
		while(scan.hasNext()){
			String a = scan.nextLine();
			String b = scan.nextLine();
			System.out.println(gatMath(a,b));
		}
	}
	public static int gatMath(String a,String b){
		int max = 0;
		if(a.length()==0){
			return a.length();
		}
		int cha = b.length()-a.length();
		String[] aStr = getStringShuZu(a);
		String[] bStr = getStringShuZu(b);
		
		for(int i = 0;i<cha+1;i++){
			int sum = 0;
			if(aStr[0].equals(bStr[i])){
				sum++;
				for(int j=1;j<aStr.length;j++){
					if(aStr[j].equals(bStr[i+j])){
						sum++;
					}
				}
			}
			max = Math.max(max, sum+cha);
		}
		
		
		return b.length()- max;
	}
	public static String[] getStringShuZu(String a){
		String[] s = new String[a.length()];
		for(int i =0;i<a.length();i++){
			s[i] = String.valueOf(a.charAt(i));
		}
		return s;

	
	}
	
	
}
