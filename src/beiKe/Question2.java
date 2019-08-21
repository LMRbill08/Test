package beiKe;

import java.util.*;

/*
 * 小希偶然得到了传说中的月光宝盒,然而打开月光宝盒需要一串密码。
 * 虽然小希并不知道密码具体是什么，
 * 但是月光宝盒的说明书上有着一个长度为 n (2 <= N <= 50000)的序列 a (-10^9 <= a[i] <= 10^9)的范围内。
 * 下面写着一段话：密码是这个序列的最长的严格上升子序列的长度(严格上升子序列是指，子序列的元素是严格递增的，
 * 例如: [5,1,6,2,4]的最长严格上升子序列为[1,2,4])
 * 请你帮小希找到这个密码。
 */
public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String[] str = sc.nextLine().split(" ");
		int[] list = new int[n];
		for (int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(str[i]);
		}

		int res = 0;
		int cur = 0;
		for (int i = 0; i < list.length; i++) {
			cur = getLen(list, i);
			if (cur > res) {
				res = cur;
			}
		}

		System.out.println(res);
		sc.close();

//		HashMap<Integer, Integer> map = new HashMap<>();
//		map.put(list[0], 1);
//		int min = list[0];
//		for (int i = 1; i < n; i++) {
//			if (list[i] < min) {
//				map.put(list[i], 1);
//				min = list[i];
//			}
//		}
//		Set<Integer> keys = map.keySet();
//		Iterator<Integer> it = keys.iterator();
//		while (it.hasNext()) {
//			System.out.print(it.next() + " ");
//		}

	}

	public static int getLen(int[] array, int index) {
		int cur = array[index];
		int len = 1;
		for (int i = index + 1; i < array.length; i++) {
			if (array[i] > cur) {
				len += 1;
				cur = array[i];
			}
		}
		return len;
	}

}
