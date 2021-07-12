package com.algorithm.java;

import java.util.Scanner;

public class Main_2798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		ans = 0;
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		combi(3, arr, 0, 0, new boolean[N], N, M);
		System.out.println(ans);
	}
	
	static int ans;
	static void combi(int goal, int[] arr, int idx, int cnt, boolean[] visit, int N, int M) {
		if(cnt==goal) {
			int sum=0;
			for(int i=0; i<N; i++) {
				if(visit[i]) {
					sum += arr[i];
				}
			}
			if(sum<=M) {
				if(ans<sum) {
					ans = sum;
				}
			}
			return;
		}
		if(idx==N) {
			return;
		}
		
		visit[idx] = true;
		combi(goal, arr, idx+1, cnt+1, visit, N, M);
		visit[idx] = false;
		combi(goal, arr, idx+1, cnt, visit, N, M);
	}
	
	private static String src = "10 500\r\n"
			+ "93 181 245 214 315 36 185 138 216 295";
}
