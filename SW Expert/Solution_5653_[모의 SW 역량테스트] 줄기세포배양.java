import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int T = sc.nextInt();

		for (int ts = 1; ts <= T; ts++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int time = sc.nextInt();

			map = new int[time + N][time + M];

			int i = ((time + N) / 2 - (N / 2));
			int j = ((time + M) / 2 - (M / 2));
			int idx = 0;
			int jdx = 0;
			q = new LinkedList<>();
			visit = new boolean[time + N][time + M];
			while (true) {
				map[i][j] = sc.nextInt();
				if (map[i][j] != 0) {
					q.add(new Node(i, j, map[i][j], map[i][j], 1));
					visit[i][j] = true;
				}
				j++;
				jdx++;
				if (jdx == M) {
					jdx = 0;
					i++;
					j = ((time + M) / 2 - (M / 2));
					idx++;
					if (idx == N)
						break;
				}
			}

//			for (int[] data : map)
//				System.out.println(Arrays.toString(data));
//			System.out.println(q);
			bfs(time + N, time + M, time);
			System.out.println("#" + ts + " " + sum);
			sum = 0;
		}
	}

	static List<Node> q;
	static boolean visit[][];
	static int Y[] = { -1, 1, 0, 0 };
	static int X[] = { 0, 0, -1, 1 };

	static void bfs(int N, int M, int time) {
		List<Node> before = new LinkedList<Main.Node>();
		int cnt = 0;
		while (true) {
//			System.out.println(cnt);
			while (!q.isEmpty()) {
				Node n = q.remove(0);
//				System.out.println(n);
				if (n.cnt != -1) {
					before.add(new Node(n.y, n.x, n.cnt - 1, n.value, n.life));
					continue;
				}
				if (n.life != n.value) {
					before.add(new Node(n.y, n.x, n.cnt, n.value, n.life + 1));
				}

				for (int i = 0; i < 4; i++) {
					int ny = Y[i] + n.y;
					int nx = X[i] + n.x;

					if (ny < 0 || nx < 0 || ny >= N || nx >= M)
						continue;
					if (visit[ny][nx])
						continue;

					if (map[ny][nx] == 0) {
						before.add(new Node(ny, nx, n.value - 1, n.value, 1));
						visit[ny][nx] = true;
						map[ny][nx] = n.value;
					}
				}
			}

//			System.out.println(before);
//			for (int[] data : map)
//				System.out.println(Arrays.toString(data));
//			System.out.println();
			cnt++;
			if (cnt > time) {
				sum = before.size();
				break;
			}
			while (!before.isEmpty()) {
				Node n = before.remove(0);
				if (n.cnt == -1 && n.value >= n.life)
					q.add(0, new Node(n.y, n.x, n.cnt, n.value, n.life));
				else
					q.add(new Node(n.y, n.x, n.cnt, n.value, n.life));
			}
		}
	}

	static int sum;

	static class Node {
		int y, x, cnt, value, life;

		public Node(int y, int x, int cnt, int value, int life) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.value = value;
			this.life = life;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", cnt=" + cnt + ", value=" + value + ", life=" + life + "]";
		}

	}

	private static String src = "1\r\n" + "2 2 10\r\n" + "1 1\r\n" + "0 2\r\n" + "5 5 19\r\n" + "3 2 0 3 0 \r\n"
			+ "0 3 0 0 0 \r\n" + "0 0 0 0 0 \r\n" + "0 0 1 0 0 \r\n" + "0 0 0 0 2";
}
