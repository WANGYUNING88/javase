package com.wang.suanfa;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Main29 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		 Scanner in = new Scanner(System.in);
	       
	            int n = in.nextInt();
	            List<Map<Integer,String>>  list = new ArrayList();
	            for(int i =0;i<n;i++){
	            	Map<Integer,String> map = new HashMap();
	            	int m = in.nextInt();
		            for(int j =0;i<m;i++){
		            	String str = in.nextLine();
		            	
		            	map.put(j, str);
		            }
		            list.add(map);

	            }
	            
	            getSum(list);
	            
	    
	
	}
	
	public static void getSum(List<Map<Integer,String>> list) {	
		Map<Integer,String> map = new HashMap();
		for(int i = 0;i<list.size();i++){
			boolean flag=true;
			map = list.get(i);
			
			String str1 =map.get(0);
			
			String array[] = getShuZu(str1);
			
			for(int j = 0;j<array.length;j++){
				StringBuilder sb = new StringBuilder();
				for(int k = j;i<array.length;j++){
					sb.append(array[k]);
				}
				for(int k=0;k<i;k++){
					sb.append(array[k]);
				}
				String newStr = sb.toString();
				if(newStr.equals(map.get(1))){
					flag = false;
					System.out.println("Yeah");
					break;
				}
			}
			if(flag){
				System.out.println("Sad");
			}
			
		}
		
	}
	public static String[] getShuZu(String str){
		String array[] = new String[str.length()];
    	for (int z = 0; z < array.length; z++) {
    	                array[z] = String.valueOf(str.charAt(z));
    	            }
    	return array;
	}

}
		

