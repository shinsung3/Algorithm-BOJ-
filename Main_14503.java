import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		N = sc.nextInt();
		M = sc.nextInt();

		int I = sc.nextInt(); // y좌표
		int J = sc.nextInt(); // x좌표
		int dir = sc.nextInt(); // 방향
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		BFS(I, J, dir);
		System.out.println(ans);
	}

	static int Y[] = { -1, 1, 0, 0 };
	static int X[] = { 0, 0, -1, 1 };
	static int ans;

	static void BFS(int y, int x, int dir) {
		Queue<Node> q = new LinkedList<>();
		boolean visit[][] = new boolean[N][M];
		q.add(new Node(y, x, dir, 1));
		visit[y][x] = true;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] ==1)
					visit[i][j] = true;
			}
		}

		map[y][x] = 2;
		while (!q.isEmpty()) {
			Node n = q.poll();
			ans = n.cnt;
//			System.out.println(ans);
//			for(int[] data: map)
//				System.out.println(Arrays.toString(data));
//			System.out.println();
			if (n.dir == 0) {
				// 북 -> 서
				dir = 3;
				int ii = 2;
				solve(n, dir, visit, ii, q);
			} else if (n.dir == 1) {
				// 동 -> 북
				dir = 0;
				int ii = 0;
				solve(n, dir, visit, ii, q);
			} else if (n.dir == 2) {
				// 남 -> 동
				dir = 1;
				int ii = 3;
				solve(n, dir, visit, ii, q);
			} else if (n.dir == 3) {
				// 서 -> 남
				dir = 2;
				int ii = 1;
				solve(n, dir, visit, ii, q);
			}
			
			if(!flag) {
				//후진 할 예정.
				if (n.dir == 0) {
					// 북 -> 남
					dir = 0;
					int ii = 1;
					solve_back(n, dir, visit, ii, q);
				} else if (n.dir == 1) {
					// 동 -> 서
					dir = 1;
					int ii = 2;
					solve_back(n, dir, visit, ii, q);
				} else if (n.dir == 2) {
					// 남 -> 북
					dir = 2;
					int ii = 0;
					solve_back(n, dir, visit, ii, q);
				} else if (n.dir == 3) {
					// 서 -> 동
					dir = 3;
					int ii = 3;
					solve_back(n, dir, visit, ii, q);
				}
				if(!flag) {
					break;
				}
			}
		}
	}

	static void solve_back(Node n, int dir, boolean[][] visit, int ii, Queue<Node> q) {
		flag = true;
		int ny = Y[ii] + n.y;
		int nx = X[ii] + n.x;
		if (ny < 0 || nx < 0 || ny >= N || nx >= M)
			return;
		if (map[ny][nx]==1) {
			flag = false;
			return;
		}
		q.add(new Node(ny, nx, dir, n.cnt));
		visit[ny][nx] = true;
	}
	
	static boolean flag;
	
	static void solve(Node n, int dir, boolean[][] visit, int ii, Queue<Node> q) {
		flag = false;
		for (int i = 0; i < 4; i++) {
			int nny = Y[i] + n.y;
			int nnx = X[i] + n.x;

			if (!visit[nny][nnx]) {
				flag = true;
				break;
			}
		}
		if (flag) {

			int ny = Y[ii] + n.y;
			int nx = X[ii] + n.x;
			if (ny < 0 || nx < 0 || ny >= N || nx >= M)
				return;
			if (visit[ny][nx]) {
				// 왼쪽으로 못 갈때는 방향만 돌립니다.
				q.add(new Node(n.y, n.x, dir, n.cnt));
				return;
			}
			q.add(new Node(ny, nx, dir, n.cnt + 1));
			map[ny][nx] = 2;
			visit[ny][nx] = true;
		}
	}

	static class Node {
		int y, x, dir, cnt;

		public Node(int y, int x, int dir, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", dir=" + dir + ", cnt=" + cnt + "]";
		}

	}

	private static String src = "3 3\r\n" + "1 1 0\r\n" + "1 1 1\r\n" + "1 0 1\r\n" + "1 1 1";
}
