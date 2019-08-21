package bilibili;

import java.util.Arrays;
import java.util.Scanner;

public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(",");
		int[] result = new int[str.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = Integer.parseInt(str[i]);
		}
		Arrays.sort(result);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
		}

		sc.close();
	}

}
