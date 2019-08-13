import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static int K;
	static char map[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int T = sc.nextInt();
		for (int ts = 1; ts <= T; ts++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();

			map = new char[N][M];
			fire = new LinkedList<>();
			scott = new LinkedList<>();
			devil = new LinkedList<>();
			scottBool = new boolean[N][M];
			fireBool = new boolean[N][M];
			devilBool = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				String line = sc.next();
				for (int j = 0; j < line.length(); j++) {
					map[i][j] = line.charAt(j);
					if (map[i][j] == 'S') {
						scott.add(new Node(i, j, 0, 0, map[i][j]));
						scottBool[i][j] = true;
					}
					if (map[i][j] == 'F') {
						fire.add(new Node(i, j));
						fireBool[i][j] = true;
					}
					if (map[i][j] == 'V') {
						devil.add(new Node(i, j, 0, map[i][j]));
						devilBool[i][j] = true;
					}
				}
			}

//			for (char[] data : map)
//				System.out.println(Arrays.toString(data));
//			System.out.println();

			BFS();
			System.out.println("#"+ts+" "+ans);
		}
	}

	static int Y[] = { -1, 1, 0, 0 };
	static int X[] = { 0, 0, -1, 1 };
	static boolean[][] fireBool;
	static boolean[][] scottBool;
	static boolean[][] devilBool;

	static void BFS() {
		char map2[][] = new char[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map2[i][j] = map[i][j];
			}
		}

		Queue<Node> fireBefore = new LinkedList<>();
		Queue<Node> scottBefore = new LinkedList<>();
		Queue<Node> devilBefore = new LinkedList<>();
		boolean[][] last = new boolean[N][M];

		while (true) {
//			for(char[] data:map2)
//				System.out.println(Arrays.toString(data));
//			System.out.println();

			// 2. 두번째로 scott이 1초마다 지나갈 수 있는 곳을 설정해줌.
			boolean flag = false;
			while (!scott.isEmpty()) {
				Node n = scott.poll();
				if (map2[n.y][n.x] == 'F')
					continue;
				if (n.who == 'S') {

					map2[n.y][n.x] = 'A';
				} else {
					map2[n.y][n.x] = n.who;
				}

				for (int i = 0; i < 4; i++) {
					int ny = Y[i] + n.y;
					int nx = X[i] + n.x;

					if (ny < 0 || nx < 0 || ny >= N || nx >= M)
						continue;
					if (scottBool[ny][nx] && map2[ny][nx] == 'A')
						continue;
					if (map2[ny][nx] == 'X' || map2[ny][nx] == 'F')
						continue;
					if (map2[ny][nx] == 'W') {
						if (n.timeCnt < K) {
							if (scottBool[ny][nx]) {
								if (last[ny][ny]) {
									continue;
								} else {
									if (n.timeCnt >= K) {
										continue;
									} else {
										scottBefore.add(new Node(ny, nx, n.timeCnt + 1, n.cnt + 1, map2[ny][nx]));
										last[ny][nx] = true;
										map2[ny][nx] = 'S';
									}
								}
							} else {
								scottBefore.add(new Node(ny, nx, n.timeCnt + 1, n.cnt + 1, map2[ny][nx]));
								scottBool[ny][nx] = true;
								map2[ny][nx] = 'S';
							}
						}
					}
					if (map2[ny][nx] == 'A' || map2[ny][nx] == 'V') {
						scottBefore.add(new Node(ny, nx, 0, n.cnt + 1, map2[ny][nx]));
						fireBool[ny][nx] = true;
						map2[ny][nx] = 'S';
					}
					if (map2[ny][nx] == 'E') {
						ans = n.cnt + 1;
						flag = true;
						return;
					}
				}
			}
//			for(char[] data:map2)
//				System.out.println(Arrays.toString(data));
//			System.out.println();
			if (flag)
				break;

			// 1. 가장 먼저 'fire'이 1초 지났을 때, 이동할 거리를 bfs로 저장.
			while (!fire.isEmpty()) {
				Node n = fire.poll();

				for (int i = 0; i < 4; i++) {
					int ny = Y[i] + n.y;
					int nx = X[i] + n.x;

					if (ny < 0 || nx < 0 || ny >= N || nx >= M)
						continue;
					if (fireBool[ny][nx])
						continue;
					if (map2[ny][nx] == 'W' || map2[ny][nx] == 'X')
						continue;

					if (map2[ny][nx] == 'A' || map2[ny][nx] == 'S' || map2[ny][nx] == 'V') {
						fireBefore.add(new Node(ny, nx));
						fireBool[ny][nx] = true;
						map2[ny][nx] = 'F';
					}
				}
			}

			// 3. 악마가 1초동안 이동할 곳, 불을 자유자재로 다룰 수 있음.
			while (!devil.isEmpty()) {
				Node n = devil.poll();
				if (n.who == 'V') {

					map2[n.y][n.x] = 'A';
				} else {
					map2[n.y][n.x] = n.who;
				}

				for (int i = 0; i < 4; i++) {
					int ny = Y[i] + n.y;
					int nx = X[i] + n.x;

					if (ny < 0 || nx < 0 || ny >= N || nx >= M)
						continue;
					if (devilBool[ny][nx])
						continue;
					if (map2[ny][nx] == 'W' || map2[ny][nx] == 'X')
						continue;

					if (map2[ny][nx] == 'A' || map2[ny][nx] == 'S' || map2[ny][nx] == 'F') {
						devilBefore.add(new Node(ny, nx, n.cnt + 1, map2[ny][nx]));
						devilBool[ny][nx] = true;
						map2[ny][nx] = 'V';
					}
					if (map2[ny][nx] == 'E') {
						ans = -1;
						flag = true;
						return;
					}
				}
			}
//			for(char[] data:map2)
//				System.out.println(Arrays.toString(data));
//			System.out.println();

			if (flag)
				break;

			while (!fireBefore.isEmpty()) {
				Node n = fireBefore.poll();
				fire.add(new Node(n.y, n.x));
			}
			while (!scottBefore.isEmpty()) {
				Node n = scottBefore.poll();
				scott.add(new Node(n.y, n.x, n.timeCnt, n.cnt, n.who));
			}
			while (!devilBefore.isEmpty()) {
				Node n = devilBefore.poll();
				devil.add(new Node(n.y, n.x, n.cnt, n.who));
			}

//			for (char[] data : map2)
//				System.out.println(Arrays.toString(data));
//			System.out.println();
		}
	}

	static int ans;
	static Queue<Node> scott;
	static Queue<Node> fire;
	static Queue<Node> devil;

	static class Node {
		int y, x, timeCnt, cnt;
		char who;

		public Node(int y, int x, int cnt, char who) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.who = who;
		}

		public Node(int y, int x, int timeCnt, int cnt, char who) {
			super();
			this.y = y;
			this.x = x;
			this.timeCnt = timeCnt;
			this.cnt = cnt;
			this.who = who;
		}

		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", timeCnt=" + timeCnt + ", cnt=" + cnt + "]";
		}

	}

	private static String src = "1\r\n" + "5 5 2\r\n" + "SAAAV\r\n" + "AAWXA\r\n" + "WXAFA\r\n" + "WAAAF\r\n"
			+ "AEAAA\r\n" + "5 5 3\r\n" + "WWXSX\r\n" + "WWXWX\r\n" + "WWXWX\r\n" + "EWWWA\r\n" + "XXXXX";
}