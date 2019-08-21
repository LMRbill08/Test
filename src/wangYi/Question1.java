package wangYi;

import java.util.*;
import java.util.Map.Entry;

/*
 * 第一行输入班级人数n
 * 第二行输入n个整数，用空格间隔，第i个整数表示第i个学生的成绩
 * 第三行输入查询次数t
 * 接下来t行每行输入一个整数，代表班里某同学，顺序对应第二行的i
 * 输出t行整数，每行对应查询的学生的班级排名
 */
public class Question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine()); // 学生人数
		String[] res = sc.nextLine().split(" ");
		int queryTime = Integer.parseInt(sc.nextLine());

		HashMap<Integer, Integer> map = new HashMap<>(n); // 用HashMap存储学生成绩
		for (int i = 0; i < res.length; i++) {
			map.put(i + 1, Integer.parseInt(res[i]));
		}
		// 用ArrayList存储排名后的键值对
		List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		// printList(list);

		int[] result = new int[queryTime];
		// java.text.DecimalFormat dFormat = new java.text.DecimalFormat("#.000000");
		int curID = 0;
		int curGrade = 0;
		int rank = 0;
		for (int i = 0; i < queryTime; i++) {
			curID = sc.nextInt();
			curGrade = map.get(curID);
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).getValue() == curGrade) {
					rank = j + 1;
				}
			}
			result[i] = rank;
			// result[i] = Double.parseDouble(dFormat.format(rank / n));
		}
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		sc.close();
	}

	public static void printList(List<Map.Entry<Integer, Integer>> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println("(" + list.get(i).getKey() + ", " + list.get(i).getValue() + ")");
		}
	}
}
