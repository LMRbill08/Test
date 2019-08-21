package pinDuoDuo;
import java.util.HashMap;
import java.util.Scanner;

public class Question4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		int num = Integer.parseInt(scanner.nextLine());

		String str1 = scanner.nextLine();
		String[] lenArr = str1.split(" ");

		String str2 = scanner.nextLine();
		String[] weiArr = str2.split(" ");

		scanner.close();
		boolean res = function(lenArr, weiArr);

		System.out.println(res);
	}

	public static boolean function(String[] lenArr, String[] weiArr) {
		HashMap<Character, Integer> mapLen = new HashMap<>();
		HashMap<Character, Integer> mapWei = new HashMap<>();

		if (lenArr.length != weiArr.length) {
			return false;
		}

		int len, wei;
		for (int i = 0; i < weiArr.length; i++) {
			String s = i + "";
			Character ch = s.charAt(0);
			len = Integer.parseInt(lenArr[i]);
			wei = Integer.parseInt(weiArr[i]);
			mapLen.put(ch, len);
			mapWei.put(ch, wei);
		}

		return check(mapLen, mapWei);
	}

	public static boolean check(HashMap<Character, Integer> mapLen, HashMap<Character, Integer> mapWei) {

		return false;
	}

}
