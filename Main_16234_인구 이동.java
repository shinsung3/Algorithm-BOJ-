import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int map[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt();
		int L = sc.nextInt();
		int R = sc.nextInt();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
//
//		for (int[] data : map)
//			System.out.println(Arrays.toString(data));
//		System.out.println();

		bfs(N, L, R);
		System.out.println(ans);

	}

	static int Y[] = { -1, 1, 0, 0 };
	static int X[] = { 0, 0, -1, 1 };
	static int ans;

	static void bfs(int N, int L, int R) {
		while (true) {
			boolean visit[][] = new boolean[N][N];
			int check[][] = new int[N][N];
			Queue<Node> q = new LinkedList<Main.Node>();
			int idx = 1;
			int value = 0;
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visit[i][j]) {
						visit[i][j] = true;
						q.add(new Node(i, j, map[i][j]));
						while (!q.isEmpty()) {
							Node n = q.poll();

							for (int ii = 0; ii < 4; ii++) {
								int ny = Y[ii] + n.y;
								int nx = X[ii] + n.x;

								if (ny < 0 || nx < 0 || ny >= N || nx >= N)
									continue;
								if (visit[ny][nx])
									continue;
								int temp = Math.abs(map[n.y][n.x] - map[ny][nx]);
								if (temp >= L && temp <= R) {
									flag = true;
									q.add(new Node(ny, nx, map[ny][nx]));
									visit[ny][nx] = true;
									check[n.y][n.x] = idx;
									check[ny][nx] = idx;
									value = idx;
								}
							}
						}
						idx++;
					}
				}
			}
			if(!flag)
				break;
//			for (int[] a : check)
//				System.out.println(Arrays.toString(a));
//			System.out.println();
			findTrue(N, check, value+1);
			ans++;
			System.out.println(ans);
			for (int[] a : map)
				System.out.println(Arrays.toString(a));
			System.out.println();
		}

	}

	static void changeMap(int check, int value, int N, int[][] visit) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j] == check) {
					map[i][j] = value;
				}
			}
		}
	}

	static void findTrue(int N, int[][] visit, int idx) {
		int check = 1;
		while (true) {
			int cnt = 0;
			int sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visit[i][j] == check) {
						cnt++;
						sum += map[i][j];
					}
				}
			}
			check++;
			if(cnt==0)
				continue;
			changeMap(check-1, sum/cnt, N, visit);
			if(check>=idx)
				break;
		}
	}

	static class Node {
		int y, x, value;

		public Node(int y, int x, int value) {
			super();
			this.y = y;
			this.x = x;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", value=" + value + "]";
		}

	}

	private static String src = "2 20 50\r\n" + "50 30\r\n" + "20 40";
}
