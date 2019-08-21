package byteDance;

import java.util.Scanner;

/*
 * 第一行员工数，第二行员工入职年数
 * 要求最低给100元薪资，每位员工会与左右两边的同事比较工资，入职年数多的要至少高100元薪资
 * 输出最低总工资
 */
public class Salary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String[] str = sc.nextLine().split(" ");
		int len = str.length;
		if (len != n) {
			System.out.println("数据错误！");
			sc.close();
		} else {
			int[] list = new int[len];
			for (int i = 0; i < len; i++) {
				list[i] = Integer.parseInt(str[i]);
			}
			int[] result = new int[len];
			result[0] = 100;
			int preSalary = 0;
			int minSalary = 100;
			for (int i = 1; i < result.length; i++) {
				preSalary = result[i - 1];
				if (list[i] < list[i - 1]) {
					result[i] = preSalary - 100;
					if (result[i] < minSalary) {
						minSalary = result[i];
					}
				} else if (list[i] == list[i - 1]) {
					result[i] = preSalary;
				} else {
					result[i] = preSalary + 100;
				}
			}
			int diff = 100 - minSalary;
			for (int i = 0; i < result.length; i++) {
				result[i] += diff;
				System.out.print(result[i] + " ");
			}
			sc.close();
		}
	}
}
