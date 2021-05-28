package com.algorithm.java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1174_silver1{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<String> q = new LinkedList<String>();
		if (N <= 10) {
			System.out.println(N - 1);
		} else {
			for (int i = 0; i < 10; i++) {
				StringBuilder sb = new StringBuilder();
				sb.append(i);
				q.add(sb.toString());
			}
			int cnt = 10;
			while(true) {
				String line = q.poll();
				if(line.equals("9876543210")) {
					System.out.println(-1);
					break;
				}
				for(int i=0; i<Integer.parseInt(line)%10; i++) {
					StringBuilder sb = new StringBuilder();
					sb.append(line).append(i);
					q.add(sb.toString());
					cnt++;
					if(cnt==N) {
						System.out.println(sb.toString());
						break;
					}
				}
				if(cnt==N) {
					break;
				}
			}
		}
	}
}
