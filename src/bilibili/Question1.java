package bilibili;

import java.util.Scanner;

public class Question1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(" ");
		int len = str.length;
		String[] result = new String[len];
		int index = len - 1;
		for (int i = 0; i < str.length; i++) {
			result[index] = str[i];
			index--;
		}
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		sc.close();
	}
}
