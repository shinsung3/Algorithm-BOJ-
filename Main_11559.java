import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static char map[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		map = new char[12][6];

		for (int i = 0; i < 12; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < 6; j++) {
				map[i][j] = line.charAt(j);
			}
		}
//		for (char[] data : map)
//			System.out.println(Arrays.toString(data));
		while (true) {
			BFS_1();
			// 2.다 끝나면 내리기?
			down_2();
			if(!flag) {
				break;
			}else {
				flag = false;
			}
		}
		System.out.println(ans);
	}

	static int ans;
	static int Y[] = { -1, 1, 0, 0 };
	static int X[] = { 0, 0, -1, 1 };
	static boolean flag;

	// 1. 먼저 bfs로 확인을 한다
	static void BFS_1() {
		Queue<Node> q = new LinkedList<>();
		Queue<Node> remove = new LinkedList<>();
		boolean isCheck = false;
		for (int j = 11; j >= 0; j--) {
			for (int i = 0; i < 6; i++) {
				if (map[j][i] != '.') {
					boolean visit[][] = new boolean[12][6];
					char who = map[j][i];
					q.add(new Node(j, i, who));
					remove.add(new Node(j, i, who));
					visit[j][i] = true;
					int cnt = 1;
					// 갯수가 4개 이상인지 판단.
					while (!q.isEmpty()) {
						Node n = q.poll();
						for (int dir = 0; dir < 4; dir++) {
							int ny = Y[dir] + n.y;
							int nx = X[dir] + n.x;

							if (ny < 0 || nx < 0 || ny >= 12 || nx >= 6)
								continue;
							if (visit[ny][nx])
								continue;
							if (map[ny][nx] == who) {
								visit[ny][nx] = true;
								q.add(new Node(ny, nx, who));
								remove.add(new Node(ny, nx, who));
								cnt++;
							}
						}
					}
					if (cnt >= 4) {
						isCheck = true;
						// 갯수가 4개 이상이면 지워주기.
						while (!remove.isEmpty()) {
							Node n = remove.poll();
							map[n.y][n.x] = '.';
						}
					} else {
						remove.clear();
					}
				}
			}
		}
		if(isCheck) {
			ans++;
		}
	}

	static void down_2() {
		for (int i = 11; i >= 0; i--) {
			for (int j = 0; j < 6; j++) {
				if (map[i][j] == '.') {
					for (int y = i; y >= 0; y--) {
						if (map[y][j] != '.') {
							flag = true;
							map[i][j] = map[y][j];
							map[y][j] = '.';
							break;
						}
					}
				}
			}
		}
//		for (char[] data : map)
//			System.out.println(Arrays.toString(data));
	}

	static class Node {
		int y, x;
		char who;

		public Node(int y, int x, char who) {
			super();
			this.y = y;
			this.x = x;
			this.who = who;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", who=" + who + "]";
		}

	}

	private static String src = "......\r\n" + "......\r\n" + "......\r\n" + "......\r\n" + "......\r\n" + "......\r\n"
			+ "......\r\n" + "......\r\n" + ".Y....\r\n" + ".YG...\r\n" + "RRYG..\r\n" + "RRYGG.";
}