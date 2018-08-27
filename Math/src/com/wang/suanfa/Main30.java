package com.wang.suanfa;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class Main30 {
	

	public static void main(String[] args) {
		
		 Scanner in = new Scanner(System.in);
	        while (in.hasNextInt()) {
	            int n = in.nextInt();
	            int t = in.nextInt();
	            
	            int[] array = new int[n];
	            for(int i = 0;i<array.length;i++){
	            	array[i] = in.nextInt();
	            }
	            
	            System.out.println(getSum(array, t));
	        }
		
	}
	
	public static int getSum(int[] array ,int t){
		int len = array.length;
		int[] newArray = new int[t*len];
		for(int i = 0;i<t;i++){
			for(int j = 0;j<array.length;j++){
				newArray[i*len +j] = array[i];
			}
		}
		return longestConsecutive(newArray);
		
	}
	 public static int longestConsecutive(int[] nums) {
	      Set<Integer> set = new HashSet<>();
	      int max = 0;
	      for(int num : nums) set.add(num);
	      for(int num : nums) if (!set.contains(num-1)) {
	        int val = num;
	        while(set.remove(val++));
	        max = Math.max(max, val-num-1);
	      }
	      return max;
	    }
		

}
		

