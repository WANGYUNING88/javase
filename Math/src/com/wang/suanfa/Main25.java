package com.wang.suanfa;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import javax.print.attribute.standard.Fidelity;


public class Main25 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
//	System.out.println(new Date().getTime());
		int [] a = {4,5,6,1,2,3};
		System.out.println(minNumberInRotateArray(a));
	}
	
	 public static int minNumberInRotateArray(int [] array) {
		 
		 if(array.length==0){
			 return 0;
		 }else if(array.length==1){
			 return array[0];
		 }
		 for(int i =1;i<array.length;i++){
			 if(array[i-1]>array[i]){
				 return array[i];
			 }
		 }
		 return 0;
	}
}
		

