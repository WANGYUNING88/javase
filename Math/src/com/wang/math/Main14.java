package com.wang.math;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		      
        
		while(scan.hasNext()){
			int a = scan.nextInt();
	        
	        int sum = getJinZhiShuSums(a);
	        int gongyueshu = getZuiGongYinShu(sum,a-2);
	        
	        System.out.println(sum/gongyueshu+"/"+(a-2)/gongyueshu);
		}
	}
	public static int getZuiGongYinShu(int a,int b){

		if(a<b){
			int temp = a;
			a=b;
			b=temp;
		}
		if(a%b==0){
			return b;
		}else{
			return getZuiGongYinShu(b,a%b);
		}
		
	}
	
	public static int getJinZhiShuSums(int n){
		int sum = 0;
		if(n==1||n==2)
			return 1;
		for(int i = 2;i <n;i++){
			sum+=getJinZhiSum(n,i);
		}
		return sum;
	}
	public static int getJinZhiSum(int num,int jinzhi){
		int sum = 0 ;
		while(num>0){
			sum += (num%jinzhi);
			num = num/jinzhi;
		}
		
		return sum;
	}
	
	
}