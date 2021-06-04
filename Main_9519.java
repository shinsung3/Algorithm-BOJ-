package com.algo.before;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_9519 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt(); // ´«±ôºýÇÑ È½¼ö
		sc.nextLine();
		String line = sc.nextLine();
		List<String> list = new ArrayList<String>();
		int cnt = 0;

		while (true) {
			cnt++;
			char[] arr = line.toCharArray();
			StringBuilder start = new StringBuilder();
			StringBuilder end = new StringBuilder();

			for (int i = 0; i < arr.length; i++) {
				if (i % 2 == 0) {
					start.append(arr[i]);
				} else {
					end.append(arr[i]);
				}
			}
			start.append(end.reverse());
			line = start.toString();

			if (cnt == X) {
				System.out.println(line);
				break;
			}
			if (list.contains(start.toString())) {
				break;
			}
			list.add(line);
		}

//		System.out.println(list);
		if (cnt != X) {
			int len = X%list.size();
			if(len==0)
				len = list.size()-1;
			else
				len--;
			System.out.println(list.get(len));
		}
	}
}
