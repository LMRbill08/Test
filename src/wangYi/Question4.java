package wangYi;

import java.util.Arrays;
import java.util.Scanner;

public class Question4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] fstLine = sc.nextLine().split(" ");
		int n = Integer.parseInt(fstLine[0]);
		int queryTime = Integer.parseInt(fstLine[1]);
		String[] temp = sc.nextLine().split(" ");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}
		Arrays.sort(arr);
		int[] result = new int[queryTime];
		for (int i = 0; i < queryTime; i++) {
			int target = sc.nextInt();
			int index = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] < target) {
					continue;
				} else {
					index = j;
					break;
				}
			}
			result[i] = arr.length - index;
			for (int j = index; j < arr.length; j++) {
				arr[j] -= 1;
			}
		}
		sc.close();
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i] + "");
		}
	}
}
