package beiKe;

import java.util.Scanner;

/*
 * 小C在做一种特殊的服务器负载测试，
 * 对于一个请求队列中的请求，每一个请求都有一个负荷值，
 * 为了保证服务器稳定，请求队列中的请求负荷必须按照先递增后递减的规律(仅递增，仅递减也可以)，
 * 比如[ 1，2，8，4，3 ]，[ 1，3，5 ]和[ 10 ]这些是满足规律的，
 * 还有一些不满足的，比如[ 1，2，2，1 ]，[ 2，1，2 ]和[ 10，10 ]。
 * 现在给你一个请求队列，你可以对请求的负荷值进行增加，
 * 要求你调整队列中请求的负荷值，使数组满足条件。最后输出使队列满足条件最小的增加总和。
 */
public class Question4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String[] str = sc.nextLine().split(" ");
		int[] list = new int[n];
		for (int i = 0; i < str.length; i++) {
			list[i] = Integer.parseInt(str[i]);
		}
		if (check(list)) {
			System.out.println(0);
		} else {
			System.out.println(updateArr(list));
		}
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		sc.close();
	}

	// 检查数组是否已经符合要求
	public static boolean check(int[] arr) {
		int index = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] < arr[i + 1]) {
				continue;
			} else {
				index = i;
			}
		}
		for (int i = index; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	// 调整数组
	public static int updateArr(int[] arr) {
		int max = arr[0];
		int maxIndex = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i + 1] > max) {
				max = arr[i + 1];
				maxIndex = i + 1;
			}
		}
		int res = removeFlat(arr, maxIndex) + removeSink(arr, maxIndex);
		return res;
	}

	public static int removeFlat(int[] arr, int peakIndex) {
		int opCount = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1] && i < peakIndex) {
				arr[i + 1]++;
				opCount++;
				i++;
			}
			if (arr[i] == arr[i + 1] && i > peakIndex) {
				arr[i] += 1;
				opCount++;
				i++;
			}
		}
		return opCount;
	}

	public static int removeSink(int[] arr, int peakIndex) {
		int opCount = 0;
		for (int i = 0; i < arr.length - 2; i++) {
			if (arr[i + 1] < arr[i] && arr[i + 1] < arr[i + 2]) {
				if (arr[i] <= arr[peakIndex] && arr[i] >= arr[i + 2]) {
					if (arr[i + 2] <= arr[i] - 2) {
						opCount += arr[i + 2] + 1 - arr[i + 1];
						arr[i + 1] = arr[i + 2] + 1;
					} else if (arr[i + 2] == arr[i] - 1) {
						opCount += arr[i] - arr[i + 1] + 1;
						arr[i + 1] = arr[i];
						arr[i] += 1;
					} else {
						opCount += arr[i] - arr[i + 1] + 3;
						arr[i + 1] = arr[i] + 1;
						arr[i] += 2;
					}
				}
				if (arr[i + 2] <= arr[peakIndex] && arr[i + 2] >= arr[i]) {
					if (arr[i] <= arr[i + 2] - 2) {
						opCount += arr[i] + 1 - arr[i + 1];
						arr[i + 1] = arr[i] + 1;
					} else if (arr[i] == arr[i + 2] - 1) {
						opCount += arr[i + 2] - arr[i + 1] + 1;
						arr[i + 1] = arr[i + 2];
						arr[i + 2] += 1;
					} else {
						opCount += arr[i + 2] - arr[i + 1] + 3;
						arr[i + 1] = arr[i + 2] + 1;
						arr[i + 2] += 2;
					}
				}
			}
		}
		if (opCount == 0) {
			return 0;
		} else {
			return opCount + removeSink(arr, peakIndex);
		}
	}
}
