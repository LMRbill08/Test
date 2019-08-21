package beiKe;

import java.util.Scanner;

/*
 * 给出n个正整数，要求找出相邻两个数字中差的绝对值最小的一对数字
 * 如果有差的绝对值相同的，则输出最前面的一对数。
 */
public class Question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String[] arr = sc.nextLine().split(" ");
		int[] list = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			list[i] = Integer.parseInt(arr[i]);
		}
		if (list.length != n) {
			System.out.println("数据个数不符！");
			sc.close();
		} else {
			int res = Math.abs(list[0] - list[1]);
			int cur = 0;
			int index = 0;
			for (int i = 1; i < n - 1; i++) {
				cur = Math.abs(list[i] - list[i + 1]);
				if (cur < res) {
					res = cur;
					index = i;
				}
			}
			int[] result = new int[2];
			result[0] = list[index];
			result[1] = list[index + 1];
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i] + " ");
			}
			sc.close();
		}

	}

}
