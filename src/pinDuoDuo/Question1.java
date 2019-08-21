package pinDuoDuo;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 给出两个数组。第一个数组为严格递增，除了一个元素。要求在数组B中找到能让数组A为严格递增的最大的元素来替换数组A中的元素
 */
public class Question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> listA = new ArrayList<>();
		ArrayList<Integer> listB = new ArrayList<>();
		String str1 = scanner.nextLine();
		String[] numStr = str1.split(" ");

		for (int j = 0; j < numStr.length; j++) {
			listA.add(Integer.parseInt(numStr[j]));
		}

		String str2 = scanner.nextLine();
		String[] numStr2 = str2.split(" ");
		for (int j = 0; j < numStr2.length; j++) {
			listB.add(Integer.parseInt(numStr2[j]));
		}

		scanner.close();

		ArrayList<Integer> res = function(listA, listB);
		if (res == null) {
			System.out.println("NO");
		} else {
			for (int i = 0; i < res.size(); i++) {
				System.out.print(res.get(i) + " ");
			}
		}
	}

	public static ArrayList<Integer> function(ArrayList<Integer> listA, ArrayList<Integer> listB) {
		int targetIndex = 0;
		int min = 0;
		int max = 0;
		for (int i = 0; i < listA.size() - 1; i++) {
			if (listA.get(i) > listA.get(i + 1)) {
				min = listA.get(i);
				targetIndex = i + 1;
				if (targetIndex < listA.size() - 1) {
					max = listA.get(targetIndex + 1);
				} else {
					max = -9999;
				}
				break;
			}
		}

		int target = -9999;
		int cur;
		for (int i = 0; i < listB.size(); i++) {
			cur = listB.get(i);
			if (cur < min)
				continue;
			if (cur > min) {
				if (max == -9999) {
					if (cur > target) {
						target = cur;
						continue;
					} else {
						continue;
					}
				}
				if (max != -9999) {
					if (cur > max) {
						continue;
					} else if (cur > target) {
						target = cur;
						continue;
					} else {
						continue;
					}
				}
			}
		}
		if (target == -9999) {
			return null;
		} else {
			listA.set(targetIndex, target);
			return listA;
		}
	}

}
