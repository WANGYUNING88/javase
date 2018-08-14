package com.wang.math;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
       
        int[] num = new int[n];
        for (int i=0;i<num.length ;i++ )
        {
            num[i]= scan.nextInt();
        }
        System.out.println(getMath(num));
	}
	public static int getMath(int[] n){
		int sum = 1;
		boolean flag = false;
		for(int i = 0;i<n.length;i++){
				
			if(flag==false&&n[i]%2==0){
				n[i] = n[i]/2;
				flag = true;
			}else{
				n[i] = n[i]*3;
			}
			
		}

		if(flag==true){
			return sum+getMath(n);
		}else{
			return 0;
		}
	}
	
}
