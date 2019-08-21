package beiKe;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 举重大赛开始了，为了保证公平，要求比赛的双方体重较小值要大于等于较大值的90%，
 * 那么对于这N个人最多能进行多少场比赛呢，任意两人之间最多进行一场比赛。
 */
public class Question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String[] str = sc.nextLine().split(" ");
		double[] list = new double[str.length];
		for (int i = 0; i < str.length; i++) {
			list[i] = Double.parseDouble(str[i]);
		}
		if (list.length != n) { // 判断人数与数据个数是否相等
			System.out.println("数据不符！");
			sc.close();
		} else {
			Arrays.sort(list); // 两层循环，排序之后如果体重不合适，则跳出内层循环
			int result = 0;
			for (int i = 0; i < list.length - 1; i++) {
				for (int j = i + 1; j < list.length; j++) {
					if (check(list[i], list[j])) {
						result++;
					} else {
						break;
					}
				}
			}
			System.err.println(result);
			sc.close();
		}
	}

	// 判断两个人的体重是否合适
	public static boolean check(double a, double b) {
		double min = Math.min(a, b);
		double max = Math.max(a, b);
		double temp = 0.9 * max;
		if (min >= temp) {
			return true;
		} else {
			return false;
		}
	}

}
