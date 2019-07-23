import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt();

		int map[][] = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		bfs(map, N);
		System.out.println(cnt);

	}

	static int Y[] = { 1, 1, 0 };
	static int X[] = { 0, 1, 1 };
	static int cnt;

	static void bfs(int[][] map, int N) {
		q = new LinkedList<Main.Node>();

		q.add(new Node(0, 1, "Garo"));

		while (!q.isEmpty()) {
			Node n = q.poll();
			
			if(n.y==N-1 && n.x==N-1) {
				cnt++;
				continue;
			}

			if (n.str.equals("Garo")) {

				for (int i = 1; i < 3; i++) {
					int ny = Y[i] + n.y;
					int nx = X[i] + n.x;

					if (ny < 0 || nx < 0 || nx >= N || ny >= N)
						continue;
					if(map[ny][nx]==1)
						continue;
					if(map[ny][nx]==0) {
						if(i==1) {
							if(map[ny-1][nx] ==0 && map[ny][nx-1]==0) {
								q.add(new Node(ny,nx,"DaeGak"));
							}
						}else {
							q.add(new Node(ny, nx, "Garo"));
						}
					}
				}
			} else if (n.str.equals("Sero")) {

				for (int i = 0; i < 2; i++) {
					int ny = Y[i] + n.y;
					int nx = X[i] + n.x;

					if (ny < 0 || nx < 0 || nx >= N || ny >= N)
						continue;
					
					if(map[ny][nx]==1)
						continue;
					if(map[ny][nx]==0) {
						if(i==1) {
							if(map[ny-1][nx] ==0 && map[ny][nx-1]==0) {
								q.add(new Node(ny,nx,"DaeGak"));
							}
						}else {
							q.add(new Node(ny, nx, "Sero"));
						}
					}
				}
			} else if (n.str.equals("DaeGak")) {
				for (int i = 0; i < 3; i++) {
					int ny = Y[i] + n.y;
					int nx = X[i] + n.x;

					if (ny < 0 || nx < 0 || nx >= N || ny >= N)
						continue;
					if(map[ny][nx]==1)
						continue;
					if(map[ny][nx]==0) {
						if(i==1) {
							if(map[ny-1][nx] ==0 && map[ny][nx-1]==0) {
								q.add(new Node(ny,nx,"DaeGak"));
							}
						}else if(i==0){
							q.add(new Node(ny, nx, "Sero"));
						}else if(i==2) {
							q.add(new Node(ny,nx,"Garo"));
						}
					}
				}
			}
		}

	}

	static Queue<Node> q;

	static class Node {
		int y, x;
		String str;

		public Node(int y, int x, String str) {
			super();
			this.y = y;
			this.x = x;
			this.str = str;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", str=" + str + "]";
		}

	}

	private static String src = "4\r\n" + "0 0 0 0\r\n" + "0 0 0 0\r\n" + "0 0 0 0\r\n" + "0 0 0 0";
}