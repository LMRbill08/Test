package sina;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * LRU实现 
 */

public class Question2 {

	private static HashMap<Integer, Integer> map = new HashMap<>();
	private static int mapSize = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void initCapacity(int capacity) {
		mapSize = capacity;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			int temp = map.get(key) + 1;
			map.put(key, temp);
			return key;
		} else {
			return -1;
		}
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			return;
		} else {
			if (map.size() < mapSize) {
				map.put(key, value);
			} else {
				ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
				Collections.sort(list, new Comparator<Entry<Integer, Integer>>() {
					@Override
					public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
						// TODO Auto-generated method stub
						int s1 = o1.getValue();
						int s2 = o2.getValue();
						return (s1 - s2);
					}
				});
				int trashKey = list.get(0).getKey();
				map.remove(trashKey);
				map.put(key, value);
			}
		}
	}
}
