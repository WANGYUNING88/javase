package com.wang.suanfa;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import javax.print.attribute.standard.Fidelity;


public class Main24 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	System.out.println(new Date().getTime());

	}
	
	 public int JumpFloorII(int target) {
         if(target==1||target==0){
           return target;
       }else{
           int sum = 1;
           for(int i =1;i<target;i++){
               sum = sum*2;
           }
           return sum;
       }
   }
}
		

