package com.algorithm.java;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1012_silver2_dfs {

	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int COUNT = sc.nextInt();
			map = new int[N][M];
			for (int i = 0; i < COUNT; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				map[a][b] = 1;
			}

			int answer = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						map[i][j] = 2;
						dfs(N, M, i, j);
						answer++;
					}
				}
			}
			System.out.println(answer);
			answer = 0;
		}
	}

	static int Y[] = { -1, 1, 0, 0 };
	static int X[] = { 0, 0, -1, 1 };

	static void dfs(int N, int M, int y, int x) {
		for(int i=0; i<4; i++) {
			int ny = y + Y[i];
			int nx = x + X[i];
			
			if(ny<0 || nx<0 || ny>=N || nx>=M)
				continue;
			if(map[ny][nx]==1) {
				map[ny][nx] = 2;
				dfs(N, M, ny, nx);
			}
		}
	}

	private static String src = "2\r\n" + "10 8 17\r\n" + "0 0\r\n" + "1 0\r\n" + "1 1\r\n" + "4 2\r\n" + "4 3\r\n"
			+ "4 5\r\n" + "2 4\r\n" + "3 4\r\n" + "7 4\r\n" + "8 4\r\n" + "9 4\r\n" + "7 5\r\n" + "8 5\r\n" + "9 5\r\n"
			+ "7 6\r\n" + "8 6\r\n" + "9 6\r\n" + "10 10 1\r\n" + "5 5";
}
