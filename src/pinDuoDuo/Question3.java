package pinDuoDuo;
import java.util.ArrayList;
import java.util.Scanner;

public class Question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String[] firstLine = scanner.nextLine().split(" ");
		int n = Integer.parseInt(firstLine[0]);
		int m = Integer.parseInt(firstLine[1]);
		String[] secondLine = scanner.nextLine().split(" ");
		Integer[] taskNumber = new Integer[n];
		for (int i = 0; i < n; i++) {
			taskNumber[i] = i + 1;
		}
		ArrayList<Integer[]> relationship = new ArrayList<>();
		String nextLine = scanner.nextLine();
		while (nextLine != null && !nextLine.equals("")) {
			String[] temp = scanner.nextLine().split(" ");
			Integer[] tempRelation = stringToInt(temp);
			relationship.add(tempRelation);
			nextLine = scanner.nextLine();
		}

		for (int i = 0; i < taskNumber.length; i++) {
			for (int j = 0; j < taskNumber.length - i - 1; ++j) {
				if (bigger(taskNumber[j], taskNumber[j + 1], relationship)) {
					int temp = taskNumber[j];
					taskNumber[j] = taskNumber[j + 1];
					taskNumber[j + 1] = temp;
				}
			}
		}
		scanner.close();
		String str = "";
		for (int i = 0; i < taskNumber.length - 1; i++) {
			str = str + taskNumber[i] + "";
		}
		str += taskNumber[taskNumber.length - 1];
		System.out.println(str);
		System.out.println(outcomeLine(taskNumber));

	}

	private static Integer[] stringToInt(String[] arrs) {
		Integer[] ints = new Integer[arrs.length];
		for (int i = 0; i < arrs.length; i++) {
			ints[i] = Integer.parseInt(arrs[i]);
		}
		return ints;
	}

	private static boolean bigger(int a, int b, ArrayList<Integer[]> relationship) {
		for (int i = 0; i < relationship.size(); i++) {
			if (a == relationship.get(i)[1] && b == relationship.get(i)[0]) {
				return true;
			}
		}
		return false;
	}

	private static String outcomeLine(Integer[] a) {
		String temp = "";
		for (int i = 0; i < a.length - 1; i++) {
			temp = a[i] + " ";
		}
		temp += a[a.length - 1];
		return temp;
	}
}
