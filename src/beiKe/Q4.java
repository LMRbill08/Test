package beiKe;

import java.util.Scanner;
import java.util.ArrayList;

public class Q4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String arr[] = str.split(",");

		int a = arr.length;
		int max = 0;
		int max_count = 0;
		ArrayList<Integer> collection = new ArrayList<>();
		for (int i = 0; i < a; i++) {
			int temp = Integer.parseInt(arr[i]);
			collection.add(temp);
			if (temp > max) {
				max = temp;
				max_count = 1;
			} else if (temp == max) {
				max_count++;
			}
		}
		int firstMaxIndex = collection.indexOf(max);
		int lastMaxIndex = collection.lastIndexOf(max);
		// System.out.println(firstBreak(collection, firstMaxIndex));
		// System.out.println(lastBreak(collection, lastMaxIndex));
		if (max_count == 1) {
			int first = firstBreak(collection, firstMaxIndex);
			int last = lastBreak(collection, lastMaxIndex);
			if (first != -1) {
				if (last == -1) {
					backwardUpdate(first, firstMaxIndex, collection);
				} else {
					firstMaxIndex = doubleBreaker(first, last, collection);
				}
			} else if (last != -1) {
				frontwardUpdate(last, lastMaxIndex, collection);
			}
			finalUpdate(firstMaxIndex, collection);
		} else {
			firstMaxIndex = doubleBreaker(firstMaxIndex, lastMaxIndex, collection);
			int first = firstBreak(collection, firstMaxIndex);
			int last = lastBreak(collection, firstMaxIndex);
			if (first != -1) {
				if (last == -1) {
					backwardUpdate(first, firstMaxIndex, collection);
				} else {
					firstMaxIndex = doubleBreaker(first, last, collection);
				}
			} else if (last != -1) {
				frontwardUpdate(last, firstMaxIndex, collection);
			}
			finalUpdate(firstMaxIndex, collection);
		}
		System.out.println(collection);
	}

	private static int firstBreak(ArrayList<Integer> collection, int firstIndex) {
		for (int i = 0; i < firstIndex; i++) {
			if ((collection.get(firstIndex) - collection.get(i)) < firstIndex - i) {
				return i;
			}
		}
		return -1;
	}

	private static int lastBreak(ArrayList<Integer> collection, int lastIndex) {
		for (int i = collection.size() - 1; i > lastIndex; i--) {
			if ((collection.get(lastIndex) - collection.get(i)) < i - lastIndex) {
				return i;
			}
		}
		return -1;
	}

	private static void backwardUpdate(int first, int firstIndex, ArrayList<Integer> collection) {
		int change = 0;
		for (int i = first + 1; i <= firstIndex; i++) {
			int newNumber = collection.get(i - 1) + 1;
			change = change + newNumber - collection.get(i);
			collection.set(i, newNumber);
		}
	}

	private static void frontwardUpdate(int last, int lastIndex, ArrayList<Integer> collecion) {
		int change = 0;
		for (int i = last - 1; i >= lastIndex; i--) {
			int newNumber = collecion.get(i + 1) + 1;
			change = change + newNumber - collecion.get(i);
			collecion.set(i, newNumber);
		}
	}

	private static int doubleBreaker(int first, int last, ArrayList<Integer> collection) {
		int m = collection.get(first);
		int n = collection.get(last);
		int temp = last - (first - (n - m));
		if (temp % 2 == 0) {
			collection.set(first + temp / 2, collection.get(first) + temp / 2);
			return first + temp / 2;
		} else {
			int o = (temp - 1) / 2;
			int p = collection.get(first);
			collection.set(first + o, p + o + 1);
			collection.set(first + o + 1, p + o);
			return first + o;
		}
	}

	private static void finalUpdate(int max_Index, ArrayList<Integer> collection) {
		for (int i = 0; i < max_Index; i++) {
			if (collection.get(i + 1) <= collection.get(i)) {
				collection.set(i + 1, collection.get(i) + 1);
			}
		}
		for (int i = collection.size() - 1; i > max_Index; i--) {
			if (collection.get(i - 1) <= collection.get(i)) {
				collection.set(i - 1, collection.get(i) + 1);
			}
		}
	}
}