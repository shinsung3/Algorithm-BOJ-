package com.algo.before;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_8061 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N][M];

		sc.nextLine();
		for (int i = 0; i < N; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		map = BFS(map, N, M);

//		System.out.println();
//		for (int[] a : map)
//			System.out.println(Arrays.toString(a));
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

	static int[][] BFS(int[][] map, int N, int M) {
		Queue<Node> q = new LinkedList<>();
		boolean visit[][] = new boolean[N][M];
		int[] Y = { -1, 1, 0, 0 };
		int[] X = { 0, 0, -1, 1 };
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					q.add(new Node(i, j, 1));
					map[i][j] = 0;
					visit[i][j] = true;
				}
			}
		}
		while (!q.isEmpty()) {
			Node n = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = Y[i] + n.y;
				int nx = X[i] + n.x;

				if (ny < 0 || nx < 0 || ny >= N || nx >= M)
					continue;
				if (map[ny][nx] != 0)
					continue;
				if(visit[ny][nx])
					continue;
				q.add(new Node(ny, nx, n.cnt + 1));
				map[ny][nx] = n.cnt;
				visit[ny][nx] = true;
			}
		}
		return map;
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

	private static String src = "3 4\r\n" + "0001\r\n" + "0011\r\n" + "0110";
}
