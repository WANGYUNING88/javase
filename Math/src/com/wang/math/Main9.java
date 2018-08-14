package com.wang.math;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();;
        String[] strings = str.split(" ");
        int[] num = new int[strings.length];
        for (int i=0;i<strings.length ;i++ )
        {
            num[i]=Integer.valueOf(strings[i]);
        }
        System.out.println(getString(num));
	}
	public static int getString(int[] n){
		int sum = 0;
		HashMap<Integer,Integer> map = new HashMap();
		for(int i = 0;i<n.length;i++){
			if(n[i]==0){
				sum++;
			}else{
				if(map.containsKey(n[i])&&map.get(n[i])<=n[i]+1){
					map.put(n[i], map.get(n[i]++));
					
				}else{
					map.put(n[i], 0);
					sum=sum+n[i]+1;
				}
				
			}
		}
		
		
		return sum;
		
	}
	
}
