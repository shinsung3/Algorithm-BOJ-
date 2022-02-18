package Gold5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_13549 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);

		int N = sc.nextInt();
		int K = sc.nextInt();

		bfs(N, K);
	}

	static int Y[] = { 2, -1, 1 };

	static void bfs(int N, int K) {
		boolean visit[] = new boolean[100001];
		Queue<Node> q = new LinkedList<Node>();
		int[] map = new int[100001];
		map[N] = 1;
		map[K] = 2;
		visit[N] = true;

		q.add(new Node(N, 0));

		int min = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			Node n = q.poll();
//			System.out.println(n);
			for (int i = 0; i < 3; i++) {
				int ny = 0;
				if (i == 0) {
					ny = Y[i] * n.pos;
				} else {
					ny = Y[i] + n.pos;
				}
				if (ny < 0 || ny >= 100001)
					continue;
				if (visit[ny])
					continue;
				if (map[ny] == 0) {
					if (i == 0) {
						q.add(new Node(ny, n.cnt));
					} else {
						q.add(new Node(ny, n.cnt + 1));
					}
					visit[ny] = true;
				}
				if (map[ny] == 2) {
					int cnt = n.cnt;
					if (i != 0) {
						cnt++;
					}
					if (min > cnt) {
						min = cnt;
					}
				}
			}
		}
		if (min == Integer.MAX_VALUE) {
			min = 0;
		}
		System.out.println(min);
	}

	static class Node {
		int pos;
		int cnt;

		public Node(int pos, int cnt) {
			super();
			this.pos = pos;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Node [pos=" + pos + ", cnt=" + cnt + "]";
		}
	}

	static String src = "5 17";
}
