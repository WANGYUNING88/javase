package com.wang.math;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int x = 0;
        int[] num1 = new int[n] ,num2 =new int[n];
        for(int i = 0; i < n; i++){
        	
        		x	= sc.nextInt();
        		num1[i] = x;
            
        } 
        for(int i = 0; i < n; i++){
        	x	= sc.nextInt();
    		num2[i] = x;
            
        } 
        int sum = 0;
        for(int i = 0; i < n; i++){
           if(num2[i]==1){
        	   sum = sum +num1[i]*k;
           }
        } 
        System.out.println(sum);
    }
}