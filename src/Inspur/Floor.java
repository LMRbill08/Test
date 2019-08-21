package Inspur;

import java.util.Scanner;

/*
 * 铺地砖问题。给出广场的长宽，要求用边长为a的正方形铺设地砖。给出需要用到的地砖块数
 * 地砖必须用整块，不能打碎。地砖的边必须对齐
 * 浪潮笔试，60%通过率
 */
public class Floor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testNum = Integer.parseInt(sc.nextLine());
		String[] str;
		int length = 0, width = 0, a = 0;
		for (int j = 0; j < testNum; j++) {
			str = sc.nextLine().split(" ");
			for (int i = 0; i < str.length; i++) {
				length = Integer.parseInt(str[0]);
				width = Integer.parseInt(str[1]);
				a = Integer.parseInt(str[2]);
			}
			System.out.println(function(length, width, a));
		}
		sc.close();
	}

	public static String function(int len, int wid, int a) {
		int row, col;
		if (len % a == 0)
			col = len / a;
		else
			col = len / a + 1;
		if (wid % a == 0)
			row = wid / a;
		else
			row = wid / a + 1;
		return row * col + "";
	}

}
