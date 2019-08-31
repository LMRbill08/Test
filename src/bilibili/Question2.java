package bilibili;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(",");

		// Arrays.sort(result);
		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				String s1 = o1 + o2;
				String s2 = o2 + o1;
				return s1.compareTo(s2);
			}

		});
		for (int i = 0; i < str.length; i++) {
			System.out.print(str[i]);
		}
		sc.close();
	}

}
