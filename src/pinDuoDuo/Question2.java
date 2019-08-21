package pinDuoDuo;
import java.util.HashMap;
import java.util.Scanner;

public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		String[] strArr = str.split(" ");
		scanner.close();

		boolean res = function(strArr);
		System.out.println(res);
	}

	public static boolean function(String[] str) {
		HashMap<Character, Integer> mapFirst = new HashMap<>();
		HashMap<Character, Integer> mapLast = new HashMap<>();

		for (int i = 0; i < str.length; i++) {
			char first = str[i].charAt(0);
			char last = str[i].charAt(str[i].length() - 1);

			if (!mapFirst.containsKey(first)) {
				mapFirst.put(first, 1);
			} else {
				mapFirst.put(first, mapFirst.get(first) + 1);
			}

			if (!mapLast.containsKey(last)) {
				mapLast.put(last, 1);
			} else {
				mapLast.put(first, mapLast.get(first) + 1);
			}

		}

		for (Character ch : mapFirst.keySet()) {
			if (!mapLast.containsKey(ch) || mapFirst.get(ch) != mapLast.get(ch)) {
				return false;
			}
		}

		return true;
	}

}
