package com.wang.example;

import java.util.Scanner;

public class Main {

	private static Math math = new Math();
	private static Scanner scan = new Scanner(System.in);
	public static void ci(){
		
		System.out.println("请输入一个年份：");
		long year = scan.nextLong();
		String result  = math.isRunnian(year);
		System.out.println(result);
		ci();
	}
	
	public static void main(String[] args) {
		
		
		
//		String result = math.isSanjiaoxing(1, 1, 1);
//		System.out.println(result);
//		
		ci();
		
	}
}
