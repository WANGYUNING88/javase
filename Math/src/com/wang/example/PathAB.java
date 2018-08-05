package com.wang.example;

import java.util.Scanner;

public class PathAB {
	
	public static int path(int a,int b){
		if(a==0&&b==0){
			return 0;
		}else if(a==0||b==0){
			return 1;
		}else{
			return (path(a-1,b)+path(a,b-1));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("请输入X坐标：");
			int a = sc.nextInt();
			System.out.println("请输入Y坐标：");
			int b = sc.nextInt();

			System.out.println(path(a,b));
		}
	}

}
