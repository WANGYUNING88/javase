package com.wang.suanfa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import javax.print.attribute.standard.Fidelity;


public class Main23 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	System.out.println();

	}
	
	 public int JumpFloor(int target) {
		 if(target==0||target==1||target==2)
					         {return target;}
					          
					         int jumpFib=0;
					         int NumberMinusOne=2;
					         int NumberMinusTwo=1;
					         for(int i=3;i<=target;i++){
					             jumpFib = NumberMinusOne+NumberMinusTwo;
					             NumberMinusTwo = NumberMinusOne;
					             NumberMinusOne = jumpFib;
					              
					         }
					             return jumpFib;
					              
					          
					          
					     }
		    }


