package sina;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/* 
 * 版本号判断
 */
public class Question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] data = sc.nextLine().split(",");
		function(data);
		sc.close();
	}

	public static void function(String[] data) {
		if (data.length == 0) {
			System.out.println("没有测试用例");
			return;
		}
		if (data.length == 1) {
			System.out.println(data[0]);
			return;
		}
		// Arrays.sort(data);
		Arrays.sort(data, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				String[] s1 = o1.split(".");
				String[] s2 = o2.split(".");
				int i = Math.min(s1.length, s2.length) - 1;
				for (int j = 0; j <= i; j++) {
					if (Integer.parseInt(s1[j]) < Integer.parseInt(s2[j])) {
						return -1;
					}
				}
				if (s1.length > s2.length) {
					return 1;
				} else {
					return -1;
				}
			}
		});
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		// System.out.println(data[0]);
	}
}
