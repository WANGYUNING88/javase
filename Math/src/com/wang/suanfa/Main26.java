package com.wang.suanfa;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import javax.print.attribute.standard.Fidelity;


public class Main26 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
//		Scanner scan = new Scanner(System.in);
//	
//        
//		while(scan.hasNext()){
//	       int n = scan.nextInt();
//	       int m = scan.nextInt();
//	       int[][] array = new int[n][m];
//	       for(int i=0;i<array.length;i++){
//	    	   for(int j=0;j<array[i].length;i++){
//	    		   array[i][j] = scan.nextInt();
//	    	   }
//	       }
//	       
//		}
		
		int [] nums = {2, 7, 11, 15};
		int target = 9;
		int [] ans = twoSum(nums,target);
		System.out.println(ans[0]+"||"+ans[1]);
		
	}
	public static int[] twoSum(int[] nums, int target) {
        
		int [] ans = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0;i<nums.length;i++){
		
			if(map.containsKey(target-nums[i])){
				ans[0] = i;
				ans[1] = (int) map.get(target-nums[i]);
				

				return ans;
			}
			map.put(nums[i], i);
		}
		return new int[] {-1,-1};
    }
	
}
		

