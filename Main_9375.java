//package com.algorithm.java;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Main_9375 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			int N = sc.nextInt();
			if (N == 0) {
				System.out.println(0);
			} else {
				for (int i = 0; i < N; i++) {
					String str = sc.next();
					String category = sc.next();
					if (map.containsKey(category)) {
						map.put(category, map.get(category) + 1);
					} else {
						map.put(category, 1);
					}
				}
				Set<String> set = map.keySet();
				int answer = 1;
				for (String key : set) {
					answer *= (map.get(key) + 1);
				}

				answer -= 1;
				System.out.println(answer);
			}
		}
	}

	private static String src = "1\r\n" + "3\r\n" + "hat headgear\r\n" + "sunglasses eyewear\r\n"
//			+ "turban headgear\r\n" 
			+ "mask face\r\n";
}
