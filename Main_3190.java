import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);

		int N = sc.nextInt();
		int map[][] = new int[N][N];

		int appleCount = sc.nextInt();

		for (int i = 0; i < appleCount; i++) {
			int y = sc.nextInt()-1;
			int x = sc.nextInt()-1;

			map[y][x] = 1;
		}

		int dirCount = sc.nextInt();
		List<Time> list = new ArrayList<Main.Time>();
		for (int i = 0; i < dirCount; i++) {
			int time = sc.nextInt();
			char dir = sc.next().charAt(0);
			list.add(new Time(time, dir));
		}

//		System.out.println(list);
		moveSnake(map, list, N);
		System.out.println(ans);

	}

	static int Y[] = { -1, 1, 0, 0 };
	static int X[] = { 0, 0, -1, 1 };
	static int ans;

	static void moveSnake(int[][] map, List<Time> list, int N) {
		Queue<Node> q = new LinkedList<Main.Node>();
		List<Node> snake = new ArrayList<Main.Node>();
		q.add(new Node(0,0, 1, 0, 3));
		snake.add(new Node(1, 1));

		while (!q.isEmpty()) {
			Node n = q.poll();
			System.out.println(n);
			int ny = 0;
			int nx = 0;
			int dir = 0;
			if (!list.isEmpty()) {
				if (list.get(0).time == n.time) {
					Time t = list.remove(0);
					if (t.dir == 'D') {
						if (n.dir == 0) {
							ny = Y[3] + n.y;
							nx = X[3] + n.x;
							dir = 3;
						} else if (n.dir == 1) {
							ny = Y[2] + n.y;
							nx = X[2] + n.x;
							dir = 2;
						} else if (n.dir == 2) {
							ny = Y[0] + n.y;
							nx = X[0] + n.x;
							dir = 0;
						} else if (n.dir == 3) {
							ny = Y[1] + n.y;
							nx = X[1] + n.x;
							dir = 1;
						}
					} else if (t.dir == 'L') {
						if (n.dir == 0) {
							ny = Y[2] + n.y;
							nx = X[2] + n.x;
							dir = 2;
						} else if (n.dir == 1) {
							ny = Y[3] + n.y;
							nx = X[3] + n.x;
							dir = 3;
						} else if (n.dir == 2) {
							ny = Y[1] + n.y;
							nx = X[1] + n.x;
							dir = 1;
						} else if (n.dir == 3) {
							ny = Y[0] + n.y;
							nx = X[0] + n.x;
							dir = 0;
						}
					}
					if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
						ans = n.time + 1;
						return;
					}

					for (int s = 0; s < snake.size(); s++) {
						if (snake.get(s).y == ny && snake.get(s).x == nx) {
							ans = n.time + 1;
							return;
						}
					}

					if (map[ny][nx] == 1) {
						q.add(new Node(ny, nx, n.length + 1, n.time + 1, dir));
						snake.add(new Node(ny, nx));
						map[ny][nx] =0;
					} else {
						q.add(new Node(ny, nx, n.length, n.time + 1, dir));
						snake.remove(0);
						snake.add(new Node(ny, nx));
					}
				} else {
					myNyNx(n, ny, nx, N, snake, map, q);
				}
			}else {
				myNyNx(n, ny, nx, N, snake, map, q);
			}
//			System.out.println("¿©±ä ¹ì ¸öÀÇ À§Ä¡ : ");
//			for(Node node : snake)
//				System.out.println(node);
//			System.out.println();
		}
	}
	
	static void myNyNx(Node n, int ny, int nx, int N, List<Node> snake, int[][] map, Queue<Node> q) {
		if (n.dir == 0) {
			ny = Y[0] + n.y;
			nx = X[0] + n.x;
		} else if (n.dir == 1) {
			ny = Y[1] + n.y;
			nx = X[1] + n.x;
		} else if (n.dir == 2) {
			ny = Y[2] + n.y;
			nx = X[2] + n.x;
		} else if (n.dir == 3) {
			ny = Y[3] + n.y;
			nx = X[3] + n.x;
		}
		if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
			ans = n.time + 1;
			return;
		}

		for (int s = 0; s < snake.size(); s++) {
			if (snake.get(s).y == ny && snake.get(s).x == nx) {
				ans = n.time + 1;
				return;
			}
		}

		if (map[ny][nx] == 1) {
			q.add(new Node(ny, nx, n.length + 1, n.time + 1, n.dir));
			snake.add(new Node(ny, nx));
			map[ny][nx] =0;
		} else {
			q.add(new Node(ny, nx, n.length, n.time + 1, n.dir));
			snake.remove(0);
			snake.add(new Node(ny, nx));
		}
	}

	static class Node {
		int y, x, length, time, dir;

		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		public Node(int y, int x, int length, int time, int dir) {
			super();
			this.y = y;
			this.x = x;
			this.length = length;
			this.time = time;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", length=" + length + ", time=" + time + ", dir=" + dir + "]";
		}

	}

	static class Time {
		int time;
		char dir;

		public Time(int time, char dir) {
			super();
			this.time = time;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Time [time=" + time + ", dir=" + dir + "]";
		}

	}

	private static String src = "6\r\n" + "3\r\n" + "3 4\r\n" + "2 5\r\n" + "5 3\r\n" + "3\r\n" + "3 D\r\n" + "15 L\r\n"
			+ "17 D";
}