package com.wang.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;


public class Main22 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	


	}
	 Stack<Integer> stack1 = new Stack<Integer>();
	    Stack<Integer> stack2 = new Stack<Integer>();
	    
	    public void push(int node) {
			if (!stack1.isEmpty() && stack2.isEmpty()) {
				while (!stack1.isEmpty()) {
					// ��stack1�е�����ȡ������stack2��
					stack2.push(stack1.pop());
				}
				stack1.push(node);
				while (!stack2.isEmpty()) {
					// ��stack2�е�����ȡ������stack1��
					stack1.push(stack2.pop());
				}
	
			} else {
				stack1.push(node);// �洢����
			}
	         
	     }
	        

	    
	    public int pop() {
	    	  if(!stack1.isEmpty()){
	              return stack1.pop();
	           }else{
	               return 0;
	           }
	    }
}
