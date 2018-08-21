package com.wang.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import javax.print.attribute.standard.Fidelity;


public class Main21 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		System.out.println(Fibonacci(2));

	}
	 public  static int Fibonacci(int n) {
		 	if(n==0)
		          
		 		return 0;
		     else if(n==1){
		    	 return 1;     
			        }else{
			            return Fibonacci(n-1)+Fibonacci(n-2);
			        }
	    }
}
