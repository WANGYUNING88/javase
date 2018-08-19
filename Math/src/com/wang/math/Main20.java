package com.wang.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		      
        
		int a[][]=new int[100][100];
		int n;
		Scanner in=new Scanner(System.in);
		n=in.nextInt();
		//跳过这行换行符  
		in.nextLine();	
		for(int i=0;i<n;i++){
		String strLine = in.nextLine();   
		Scanner s = new Scanner(strLine); 
		int j=0;
		while(s.hasNextInt()){
			a[i][j++]=s.nextInt();		
				}
		}	
		//输出
		for( int i=0;i<n;i++){
			int j=0;
			while(a[i][j]!=0)
			System.out.print(a[i][j++]+"  ");
			System.out.println();
		}

	}
	 public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
	        ArrayList<Integer> list = new ArrayList<Integer>();
			ArrayList<Integer> listResult = new ArrayList<Integer>();
			ListNode tempListNode = listNode;
			while ( tempListNode != null ) {
				list.add( tempListNode.val );
				tempListNode = tempListNode.next;
			}
			for ( int i = list.size()-1; i>=0; i-- ) {
				listResult.add( list.get(i) );
			}
			return listResult;

	    }
}
