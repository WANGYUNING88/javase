package com.wang.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 递归算法实现汉诺塔
 * 
 * @author XIEHEJUN
 * 
 */
public class Hanoi {

	/**
	 * 定义移动次数
	 */
	private static int count;

	/**
	 * 设置移动次数的起始值
	 * 
	 * @param count
	 */
	public static void setCount() {
		Hanoi.count = 1;
	}

	/**
	 * 获取移动次数
	 * 
	 * @return
	 */
	public static int getCount() {
		return count - 1;
	}

	/**
	 * 移动递归
	 * 
	 * @param num
	 *            盘子数
	 * @param from
	 *            柱子A
	 * @param inner
	 *            柱子B
	 * @param to
	 *            柱子C
	 */
	public static void moveDish(int num, char from, char inner, char to) {

		if (num == 1) {
			System.out.println("\t\t**\t" + count++ + " " + num + "号盘子从" + from + "移动到" + to);
		} else {
			moveDish(num - 1, from,  to,inner);
			System.out.println("\t\t**\t" + count++ + " " + num + "号盘子从" + from + "移动到" + to);
			moveDish(num - 1, inner, from, to);
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		try {
			for (;;) {
				System.out.print("请输入盘子的个数：");
				int n = sc.nextInt();
				System.out.println("\t\t**********************************");
				System.out.println("\t\t**\t移动步骤为：");
				setCount();
				moveDish(n, 'A', 'B', 'C');
				System.out.println("\t\t**\t一共移动的步数为：" + getCount());
				System.out.println("\t\t**********************************");
			}
		} catch (Exception e) {
			System.out.println("输入数据不正确，请输入整数");
			main(null);
		}

	}

}