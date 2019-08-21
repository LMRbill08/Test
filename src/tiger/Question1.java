package tiger;

import java.util.Scanner;

public class Question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] arr = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > '0' && arr[i] < '9') {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
		sc.close();
	}

}
