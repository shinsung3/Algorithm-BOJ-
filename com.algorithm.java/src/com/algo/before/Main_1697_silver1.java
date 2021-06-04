package com.algo.before;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1697_silver1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 수빈이의 현재 위치
		int K = sc.nextInt(); // 동생의 위치

		int[] map = new int[100001];
		map[N] = 1; // 수빈의 위치 1
		map[K] = 2; // 동생의 위치 2
		
		System.out.println(BFS(N, K, map));
	}

	static int BFS(int N, int K, int[] map) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(N, 0));
		boolean[] visit = new boolean[100001];
		visit[N] = true;
		int INDEX[] = { -1, 1 };
		int answer = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			Node n = q.poll();

			if (n.idx == K) {
				if (answer > n.cnt) {
					answer = n.cnt;
				}
				continue;
			}

			for (int i = 0; i < 3; i++) {
				int nIdx = 0;
				if (i != 2) {
					nIdx = n.idx + INDEX[i];
				} else {
					nIdx = n.idx * 2;
				}
				if (nIdx < 0 || nIdx >= map.length)
					continue;
				if (visit[nIdx])
					continue;
				q.add(new Node(nIdx, n.cnt + 1));
				visit[nIdx] = true;
			}
		}
		return answer;
	}

	static class Node {
		int idx;
		int cnt;

		public Node(int idx, int cnt) {
			super();
			this.idx = idx;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Node [idx=" + idx + ", cnt=" + cnt + "]";
		}
	}
}
