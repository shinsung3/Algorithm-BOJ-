package com.algorithm.java;

import java.util.Scanner;

public class Main_2630 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);

		int N = sc.nextInt();
		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		answer = new int[2];
		dfs(N, map, 0, 0);
		for(int a:answer)
			System.out.println(a);
	}

	static int[] answer;

	static void dfs(int N, int[][] map, int row, int col) {
		if (colorCheck(map, row, col, N)) {
			if (map[row][col] == 1) {
				answer[1]++;
			} else {
				answer[0]++;
			}
			return;
		}
		dfs(N / 2, map, row, col);
		dfs(N / 2, map, row + N / 2, col);
		dfs(N / 2, map, row, col + N / 2);
		dfs(N / 2, map, row + N / 2, col + N / 2);
	}

	static boolean colorCheck(int[][] map, int row, int col, int len) {
		int color = map[row][col];
		for (int i = row; i < len+row; i++) {
			for (int j = col; j < len+col; j++) {
				if (color != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	private static String src = "8\r\n" + "1 1 0 0 0 0 1 1\r\n" + "1 1 0 0 0 0 1 1\r\n" + "0 0 0 0 1 1 0 0\r\n"
			+ "0 0 0 0 1 1 0 0\r\n" + "1 0 0 0 1 1 1 1\r\n" + "0 1 0 0 1 1 1 1\r\n" + "0 0 1 1 1 1 1 1\r\n"
			+ "0 0 1 1 1 1 1 1";
}
