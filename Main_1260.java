package com.algo.before;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1260 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int startV = sc.nextInt();

		int[][] map = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = 1;
			map[b][a] = 1;
		}

//		for (int[] a : map)
//			System.out.println(Arrays.toString(a));
		boolean[] visit = new boolean[N + 1];
		dfs(map, visit, startV);
		bfs(map, startV, N + 1);
		System.out.println(sbDFS.toString().substring(0, sbDFS.length()-1));
		System.out.println(sb.toString().substring(0, sb.length()-1));
	}

	static StringBuilder sbDFS = new StringBuilder();
	static void dfs(int[][] map, boolean[] visit, int startV) {
		visit[startV] = true;
		sbDFS.append(startV).append(" ");
		for(int i=1; i<map[startV].length; i++) {
			if(map[startV][i] == 1 && !visit[i]) {
				dfs(map, visit, i);
			}
		}
	}

	static StringBuilder sb = new StringBuilder();
	static void bfs(int[][] map, int startV, int len) {
		Queue<Integer> q = new LinkedList<>();
		boolean visit[] = new boolean[len];
		q.add(startV);
		while (!q.isEmpty()) {
			int K = q.poll();
			visit[K] = true;
			sb.append(K).append(" ");
			for (int i = 1; i < map.length; i++) {
				if (map[K][i] == 1 && !visit[i]) {
					q.add(i);
					visit[i] = true;
				}
			}
		}
	}

	private static String src = "4 5 1\r\n" + "1 2\r\n" + "1 3\r\n" + "1 4\r\n" + "2 4\r\n" + "3 4";
}
