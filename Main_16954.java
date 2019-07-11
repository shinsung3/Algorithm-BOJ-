import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);

		char[][] map = new char[8][8];

		star = new LinkedList<>();
		for (int i = 0; i < 8; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < 8; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == '#') {
					star.add(new Node(i, j));
				}
			}
		}
		q = new LinkedList<>();
		q.add(new Node(7, 0));
		bfs(map);
	}

	static Queue<Node> q;
	static Queue<Node> star;

	static int Y[] = { -1, -1, -1, 0, 0, 0, 1, 1, 1 };
	static int X[] = { 0, 1, -1, 0, 1, -1, 0, 1, -1 };

	// 먼저 욱제가 이동하는 경우
	static void bfs(char[][] map) {
		boolean visit[][] = new boolean[8][8];
		Queue<Node> before = new LinkedList<>();

		while (true) {
			while (!q.isEmpty()) {
				Node n = q.poll();

				if (n.y == 0 && n.x == 7) {
					System.out.println(1);
					return;
				}

				if (map[n.y][n.x] == '#')
					continue;

				for (int i = 0; i < 9; i++) {
					int ny = n.y + Y[i];
					int nx = n.x + X[i];

					if (ny < 0 || nx < 0 || ny >= 8 || nx >= 8)
						continue;
					if (visit[ny][nx]) {
						if (ny == n.y && nx == n.x)
//							before.add(new Node(ny, nx));
							map[ny][nx] = 'L';
						else
							continue;
					}
					if (map[ny][nx] == '.') {
						// before.add(new Node(ny, nx));
						map[ny][nx] = 'L';
					}
				}
			}

//			for(char[] data:map)
//				System.out.println(Arrays.toString(data));
//			System.out.println();
//			if(before.size()==0) {
//				System.out.println(0);
//				return;
//			}

//			while (!before.isEmpty()) {
//				Node n = before.poll();
//				q.add(n);
//			}
			// 전체 한칸 행으로 내리기.
			if (star.size() == 0) {
				System.out.println(1);
				break;
			}
			
			Queue<Node> starBefore = new LinkedList<>();
			while (!star.isEmpty()) {
				Node n = star.poll();

				if (n.y + 1 != 8) {
					starBefore.add(new Node(n.y + 1, n.x));
					map[n.y][n.x] = '.';
					map[n.y + 1][n.x] = '#';
				}
			}


			while (!starBefore.isEmpty()) {
				Node n = starBefore.poll();
				star.add(new Node(n.y, n.x));
			}
			

//			for(char[] data:map)
//				System.out.println(Arrays.toString(data));
//			System.out.println();

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (map[i][j] == 'L') {
						q.add(new Node(i, j));
					}
				}
			}

			if (q.size() == 0) {
				System.out.println(0);
				return;
			}
		}
	}

	static void Down() {

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

	private static String src = "........\r\n" + "........\r\n" + "........\r\n" + "........\r\n" + "........\r\n"
			+ "........\r\n" + "##......\r\n" + "........";
}