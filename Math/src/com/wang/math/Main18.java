package com.wang.math;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		      
        
		int a[][]=new int[100][100];
		int n;
		Scanner in=new Scanner(System.in);
		n=in.nextInt();
		//跳过这行换行符  
		in.nextLine();	
		for(int i=0;i<n;i++){
		String strLine = in.nextLine();   
		Scanner s = new Scanner(strLine); 
		int j=0;
		while(s.hasNextInt()){
			a[i][j++]=s.nextInt();		
				}
		}	
		//输出
		for( int i=0;i<n;i++){
			int j=0;
			while(a[i][j]!=0)
			System.out.print(a[i][j++]+"  ");
			System.out.println();
		}

	}
	 public String replaceSpace(StringBuffer str) {
	        String yuan = str.toString();
	        String[] yuanStr = yuan.split("");
	        String xin = "";
	        for(int i =0;i<yuanStr.length;i++){
	            if(yuanStr[i].equals(" "))
	            	xin = xin +"%20";
	            else
	            	xin = xin + yuanStr[i];
	        }
	    	return xin;
	    }
	
}
