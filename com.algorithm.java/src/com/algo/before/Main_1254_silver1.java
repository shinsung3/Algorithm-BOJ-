package com.algo.before;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_1254_silver1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		
		boolean check = false;
		for(int i=0; i<line.length(); i++) {
			if(line.charAt(i)!=line.charAt(line.length()-1-i)) {
				check = true;
			}
		}
		if(check) {
			List<Character> list = new ArrayList<Character>();
			for(int i=0; i<line.length(); i++) {
				list.add(line.charAt(i));
			}
			int idx = list.size();
			int append = 0;
			while(true) {
				list.add(idx, list.get(append));
				boolean isFinish = true;
				for(int i=0; i<list.size(); i++) {
					if(list.get(i)!=list.get(list.size()-1-i)) {
						isFinish = false;
					}
				}
				if(isFinish) {
					break;
				}
				append++;
			}
			System.out.println(list.size());
		}else {
			System.out.println(line.length());
		}
	}
}
