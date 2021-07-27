package com.algorithm.java;

import java.util.Scanner;

public class Main_17626 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt();
		
		int[] dp = new int[N+1];
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i=2; i<=N; i++) {
			int min = Integer.MAX_VALUE;
			for(int j=1; j*j<=i; j++) {
				min = Math.min(min, dp[i- j*j]);
			}
			dp[i] = min + 1;//dp[j*j]=1
		}
		System.out.println(dp[N]);
		
	}
	private static String src = "26";
}