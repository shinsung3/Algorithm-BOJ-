import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//      sc = new Scanner(src);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int T = sc.nextInt();

		q = new LinkedList<>();
		visit = new boolean[N][M];
		Cleaner = new ArrayList<>();
		int map[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] != -1 && map[i][j] != 0) {
					q.add(new Node(i, j));
					visit[i][j] = true;
				}
				if (map[i][j] == -1) {
					Cleaner.add(new Node(i, j));
				}
			}
		}

//      for (int[] data : map)
//         System.out.println(Arrays.toString(data));
//      System.out.println();

		bfs(map, N, M, T);
		System.out.println(ans);
	}

	static Queue<Node> q;
	static boolean visit[][];
	static int Y[] = { -1, 1, 0, 0 };
	static int X[] = { 0, 0, -1, 1 };
	static int Count;
	static List<Node> Cleaner;
	static int ans;

	// 1. 미세먼지 확산
	static void bfs(int[][] map, int N, int M, int T) {
		while (true) {
			int copyMap[][] = new int[N][M];
			copyMap[Cleaner.get(0).y][0] = -1;
			copyMap[Cleaner.get(1).y][0] = -1;

			while (!q.isEmpty()) {
				Node n = q.poll();
				int Arc = map[n.y][n.x] / 5;
				int cnt = 0;
				for (int i = 0; i < 4; i++) {
					int ny = Y[i] + n.y;
					int nx = X[i] + n.x;

					if (ny < 0 || nx < 0 || ny >= N || nx >= M)
						continue;
					if (map[ny][nx] != -1) {
						copyMap[ny][nx] += Arc;
						cnt++;
					}
				}
				int temp = map[n.y][n.x] - (Arc * cnt);
				if (temp != 0) {
					copyMap[n.y][n.x] += temp;
				} else {
					copyMap[n.y][n.x] = map[n.y][n.x];
				}
			}
			Count++;

			map = clean(copyMap, N, M);

			map[Cleaner.get(0).y][0] = -1;
			map[Cleaner.get(1).y][0] = -1;

			if (Count == T) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (map[i][j] != -1)
							ans += map[i][j];
					}
				}
				break;
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != -1 && map[i][j] != 0)
						q.add(new Node(i, j));
				}
			}
		}
	}

	// 2. 공기청정기 가동
	static int[][] clean(int[][] copyMap, int N, int M) {
		int upY = Cleaner.get(0).y;
		int downY = Cleaner.get(1).y;
		int[][] cleanCopyMap = new int[N][M];
		// 왼 -> 오
		for (int i = 0; i < M - 1; i++) {
			int temp = copyMap[upY][i];
			if (temp != -1) {
				cleanCopyMap[upY][i + 1] = temp;
			}
		}

		// 아래 -> 위
		for (int i = upY; i >= 1; i--) {
			int temp = copyMap[i][M - 1];
			if (temp != -1) {
				cleanCopyMap[i - 1][M - 1] = temp;
			}
		}

		// 오->왼
		for (int i = M - 1; i >= 1; i--) {
			int temp = copyMap[0][i];
			if (temp != -1) {
				cleanCopyMap[0][i - 1] = temp;
			}
		}

		// 위 -> 아래
		for (int i = 0; i < upY; i++) {
			int temp = copyMap[i][0];
			if (temp != -1) {
				cleanCopyMap[i + 1][0] = temp;
			}
		}
		///////////////////// Copy////////////////
		// 왼 -> 오
		for (int i = 0; i < M - 1; i++) {
			copyMap[upY][i] = cleanCopyMap[upY][i];
		}

		// 아래 -> 위
		for (int i = upY; i >= 1; i--) {
			copyMap[i][M - 1] = cleanCopyMap[i][M - 1];
		}

		// 오->왼
		for (int i = M - 1; i >= 1; i--) {
			copyMap[0][i] = cleanCopyMap[0][i];

		}

		// 위 -> 아래
		for (int i = 0; i < upY; i++) {
			copyMap[i][0] = cleanCopyMap[i][0];

		}

		///////////////// 아래방향
		// 왼->오
		for (int i = 0; i < M - 1; i++) {
			int temp = copyMap[downY][i];
			if (temp != -1) {
				cleanCopyMap[downY][i + 1] = temp;
			}
		}

		// 위-> 아래
		for (int i = downY; i < N - 1; i++) {
			int temp = copyMap[i][M - 1];
			if (temp != -1) {
				cleanCopyMap[i + 1][M - 1] = temp;
			}
		}

		// 오->왼
		for (int i = M - 1; i >= 1; i--) {
			int temp = copyMap[N - 1][i];
			if (temp != -1) {
				cleanCopyMap[N - 1][i - 1] = temp;
			}
		}

		// 아래 -> 위
		for (int i = N - 1; i > downY; i--) {
			int temp = copyMap[i][0];
			if (temp != -1) {
				cleanCopyMap[i - 1][0] = temp;
			}
		}
/////////////////////Copy////////////////
// 왼 -> 오
		for (int i = 0; i < M - 1; i++) {
			copyMap[downY][i] = cleanCopyMap[downY][i];
		}

		// 위 -> 아래
		for (int i = downY; i < N - 1; i++) {
			copyMap[i][M - 1] = cleanCopyMap[i][M - 1];

		}

// 오->왼
		for (int i = M - 1; i >= 1; i--) {
			copyMap[N - 1][i] = cleanCopyMap[N - 1][i];

		}
		// 아래 -> 위
		for (int i = N - 1; i > downY; i--) {
			copyMap[i][0] = cleanCopyMap[i][0];
		}

//		System.out.println("2. 청소기로 전체 밀었을때 map");
//		for (int i[] : cleanCopyMap)
//			System.out.println(Arrays.toString(i));
//		System.out.println();
		return copyMap;
	}

	static class Node {
		int y, x;

		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + "]";
		}

	}

	private static String src = "7 8 1\r\n" + "0 0 0 0 0 0 0 9\r\n" + "0 0 0 0 3 0 0 8\r\n" + "-1 0 5 0 0 0 22 0\r\n"
			+ "-1 8 0 0 0 0 0 0\r\n" + "0 0 0 0 0 10 43 0\r\n" + "0 0 5 0 15 0 0 0\r\n" + "0 0 40 0 0 0 20 0";
}