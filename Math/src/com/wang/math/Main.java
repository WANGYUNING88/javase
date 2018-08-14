package com.wang.math;

import java.util.Scanner;

public class Main{
    
    public static int max(int a,int b){
        String aStr = String.valueOf(a);
        String bStr =  String.valueOf(b);
        int ab = Integer.valueOf(aStr+bStr);
        int ba = Integer.valueOf(bStr+aStr);
        if(ab>ba){
            return ab;
        }else{
            return ba;
        }
    }
    
    
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        System.out.println(n);
        Scanner sc1 = new Scanner(System.in);
        String[] temp = sc1.nextLine().split(" ");
//        		sc.nextString().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < temp.length; i++) {    
            nums[i] = Integer.parseInt(temp[i]);
        }
        int max = max(nums[0],nums[1]);
        for (int i=2; i< n;i++){
            max = max(max,nums[i]);
        }
        System.out.print(max);
        
    }
}