package wangYi;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 第一行输入用例数量n
 * 接下来n行每行输入一行用空格间隔的若干个整数
 * 判断每一行的数组能否组成一个环，环中每一个整数要小于两侧两个整数之和
 * 可以输出YES，否则输出NO
 */
public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String[] result = new String[n];
		for (int i = 0; i < n; i++) {
			String[] strArr = sc.nextLine().split(" ");
			int[] intArr = new int[strArr.length];
			for (int j = 0; j < intArr.length; j++) {
				intArr[j] = Integer.parseInt(strArr[j]);
			}
			result[i] = function(intArr);
		}
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		sc.close();
	}

	public static String function(int[] arr) {
		int len = arr.length;
		if (len <= 2) {
			return "NO";
		}
		Arrays.sort(arr);
		if (arr[len - 1] < arr[len - 2] + arr[len - 3]) {
			return "YES";
		} else {
			return "NO";
		}
	}
}
