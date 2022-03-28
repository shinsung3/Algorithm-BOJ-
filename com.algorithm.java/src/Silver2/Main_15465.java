package Silver2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main_15465 {
	public static void main(String[] args) {
//		1. Farmer John purchases three cows: Bessie, Elsie, and Mildred
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt();
		List<Cow> cows = new LinkedList<>();
		sc.nextLine();
		for (int i = 0; i < N; i++) {
			String line = sc.nextLine();
			String[] str = line.split(" ");
			cows.add(new Cow(Integer.parseInt(str[0]), str[1], Integer.parseInt(str[2])));
		}

		Collections.sort(cows, new Comparator<Cow>() {

			@Override
			public int compare(Cow o1, Cow o2) {
				return o1.day - o2.day;
			}
		});

//		2. each of whom initially produces 7 gallons of milk per day.
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("Bessie", 7);
		map.put("Elsie", 7);
		map.put("Mildred", 7);
		boolean isFirst = false;
		int cnt = 0;
		HashSet<String> before = new HashSet<String>();
//		List<String> before = new ArrayList<String>();
		for (Cow c : cows) {
			int gallons = map.get(c.name);
			int score = c.score;
			score += gallons;
			map.put(c.name, score);

			// max값 찾기
			int max = 0;
			for (String key : map.keySet()) {
				max = Math.max(map.get(key), max);
			}

			// display할 주인공 찾기 여러개면 여러명.
//			HashSet<String> current = new HashSet<String>();
			List<String> current = new ArrayList<String>();
			for (String key : map.keySet()) {
				if (map.get(key) == max) {
					if (!isFirst) {
						before.add(key);
					} else {
						current.add(key);
					}
				}
			}
			if (!isFirst) {
				isFirst = true;
				cnt++;
			} else {
				if (current.size() != before.size()) {
					cnt++;
				} else {
					for (String s : before) {
						boolean isSame = false;
						for (int i = 0; i < current.size(); i++) {
							if (s.contains(current.get(i))) {
								isSame = true;
								break;
							}
						}
						if (!isSame) {
							cnt++;
						}
					}
				}
				before.clear();
				for (int i = 0; i < current.size(); i++) {
					before.add(current.get(i));
				}
			}
		}
//		System.out.println(cows);
		System.out.println(cnt);
	}

	static class Cow {
		int day;
		String name;
		int score;

		public Cow(int day, String name, int score) {
			super();
			this.day = day;
			this.name = name;
			this.score = score;
		}

		@Override
		public String toString() {
			return "Cows [day=" + day + ", name=" + name + ", score=" + score + "]";
		}

	}

	private static String src = "4\r\n" + "7 Mildred +3\r\n" + "4 Elsie -1\r\n" + "9 Mildred -1\r\n" + "1 Bessie +2";
}
