package com.algo.before;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_7576 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		boolean check = false;
		out: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != -1) {
					check = true;
					break out;
				}
			}
		}
		if (check) {
			check = false;
			out: for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) {
						check = true;
						break out;
					}
				}
			}
			if (!check)
				System.out.println(0);
			else
				bfs(map, N, M);
		}else {
			System.out.println(-1);
		}
	}

	static void bfs(int[][] map, int N, int M) {
		boolean[][] visit = new boolean[N][M];
		Queue<Node> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					q.add(new Node(i, j, 0));
					visit[i][j] = true;
				}
			}
		}

		int Y[] = { -1, 1, 0, 0 };
		int X[] = { 0, 0, -1, 1 };
		int answer = 0;
		while (!q.isEmpty()) {
			Node n = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = n.y + Y[i];
				int nx = n.x + X[i];

				if (ny < 0 || nx < 0 || ny >= N || nx >= M)
					continue;
				if (visit[ny][nx])
					continue;
				if (map[ny][nx] == -1)
					continue;
				q.add(new Node(ny, nx, n.cnt + 1));
				visit[ny][nx] = true;
				map[ny][nx] = n.cnt + 1;
			}
		}

		out: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					answer = -1;
					break out;
				} else {
					answer = Math.max(answer, map[i][j]);
				}
			}
		}
		System.out.println(answer);
	}

	static class Node {
		int y;
		int x;
		int cnt;

		public Node(int y, int x, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", cnt=" + cnt + "]";
		}
	}

	private static String src = "6 4\r\n" + "0 0 0 0 0 0\r\n" + "0 0 0 0 0 0\r\n" + "0 0 0 0 0 0\r\n" + "0 0 0 0 0 1";
}
