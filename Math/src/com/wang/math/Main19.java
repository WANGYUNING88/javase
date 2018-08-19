package com.wang.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
public class Main19 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] pre= {1,2,4,7,3,5,6,8};
		int[] in= {4,7,2,1,5,3,8,6};
		TreeNode treeNode=reConstructBinaryTree(pre,in);
		System.out.println(treeNode.toString());


	}
	 public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
	        TreeNode  treeNode = new TreeNode(pre[0]);
	        int rootIndex = 0;
	        for(int i = 0;i<in.length;i++){
	        	if(in[i]==pre[0]){
	        		rootIndex = i;
	        	}
	        }
	        
	        int[] preLeft=new int[rootIndex];
			 int[] preRight=new int[pre.length-rootIndex-1];
			 
			 for(int i=0;i<rootIndex;i++) {
				 preLeft[i]=pre[i+1];
			 }
			 for(int i=0;i<pre.length-rootIndex-1;i++) {
				 preRight[i]=pre[rootIndex+1+i];
			 }

	        
	        int[] inLeft = new int[rootIndex];
	        int[] inRight = new int[in.length-rootIndex-1];
	       
	        
	        for(int i=0;i<rootIndex;i++) {
	        	inLeft[i]=in[i];
	        	
			 }
			 for(int i=0;i<pre.length-rootIndex-1;i++) {
				 inRight[i]=in[rootIndex+1+i];
			 }
			 if(in.length>0&pre.length>0) {
				 if(preLeft.length>0) {
					 treeNode.left=reConstructBinaryTree(preLeft,inLeft);
				 }
				 if(preRight.length>0) {
					 treeNode.right= reConstructBinaryTree(preRight,inRight);
				 }
			 }
			 
			 
			 
			 return treeNode;    

	        
	    }
}
