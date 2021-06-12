package com.algo.before;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_7569_silver1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int H = sc.nextInt();
		int[][][] map = new int[H][N][M];

		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[k][i][j] = sc.nextInt();
				}
			}
		}

		boolean check = false;
		out: for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[k][i][j] != -1) {
						check = true;
						break out;
					}
				}
			}
		}
		if (check) {
			check = false;
			out: for (int k = 0; k < H; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (map[k][i][j] == 0) {
							check = true;
							break out;
						}
					}
				}
			}
			if (!check)
				System.out.println(0);
			else
				bfs(map, N, M, H);
		} else {
			System.out.println(-1);
		}
	}

	static void bfs(int[][][] map, int N, int M, int H) {
		boolean[][][] visit = new boolean[H][N][M];
		Queue<Node> q = new LinkedList<>();
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[k][i][j] == 1) {
						q.add(new Node(i, j, 0, k));
						visit[k][i][j] = true;
					}
				}
			}
		}
		int Y[] = { -1, 1, 0, 0, 0, 0 };
		int X[] = { 0, 0, -1, 1, 0, 0 };
		int height[] = { 0, 0, 0, 0, -1, 1 };
		int answer = 0;
		while (!q.isEmpty()) {
			Node n = q.poll();
			for (int i = 0; i < 6; i++) {
				int ny = n.y + Y[i];
				int nx = n.x + X[i];
				int nh = n.h + height[i];

				if (ny < 0 || nx < 0 || ny >= N || nx >= M || nh<0 || nh>=H)
					continue;
				if (visit[nh][ny][nx])
					continue;
				if (map[nh][ny][nx] == -1)
					continue;
				q.add(new Node(ny, nx, n.cnt + 1, nh));
				visit[nh][ny][nx] = true;
				map[nh][ny][nx] = n.cnt + 1;
			}
		}
		out: for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[k][i][j] == 0) {
						answer = -1;
						break out;
					} else {
						answer = Math.max(answer, map[k][i][j]);
					}
				}
			}
		}
		System.out.println(answer);
	}

	static class Node {
		int y;
		int x;
		int cnt;
		int h;

		public Node(int y, int x, int cnt, int h) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.h = h;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", cnt=" + cnt + ", h=" + h + "]";
		}

	}

	private static String src = "5 3 2\r\n" + "0 0 0 0 0\r\n" + "0 0 0 0 0\r\n" + "0 0 0 0 0\r\n" + "0 0 0 0 0\r\n"
			+ "0 0 1 0 0\r\n" + "0 0 0 0 0";
}
