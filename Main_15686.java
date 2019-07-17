import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int map[][] = new int[N][N];
		List<Node> chicken = new LinkedList<>();
		int idx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 2) {
					chicken.add(new Node(i, j, idx));
					idx++;
				} else if (map[i][j] == 1) {
					home++;
				}
			}
		}

		ans = Integer.MAX_VALUE;
		powerSet(map, N, chicken, 0, M, 0, new boolean[idx]);
		System.out.println(ans);

	}

	static int home;

	// 1. 가장 먼저 조합으로 어디 치킨 집을 찾을 건지 선택
	static void powerSet(int[][] map, int N, List<Node> chicken, int idx, int M, int cnt, boolean[] visit) {
		if (cnt == M) {
			// 2. bfs 불러와서 찾은 조합으로 찾기!
//			System.out.println(Arrays.toString(visit));
			bfs(chicken, visit, N, M, map);
			return;
		}
		if (idx == visit.length)
			return;
		visit[idx] = true;
		powerSet(map, N, chicken, idx + 1, M, cnt + 1, visit);
		visit[idx] = false;
		powerSet(map, N, chicken, idx + 1, M, cnt, visit);

	}

	static int Y[] = { -1, 1, 0, 0 };
	static int X[] = { 0, 0, -1, 1 };
	static int ans;

	static void bfs(List<Node> chicken, boolean[] visit, int N, int M, int[][] map) {
		boolean visited[][] = new boolean[N][N];
		Queue<Node> q = new LinkedList<>();
		int copyMap[][] = new int[N][N];
		int sum=0;
		int house = home;
		
//		for(int i=0; i<N; i++) {
//			for(int j=0; j>M; j++) {
//				if(map[i][j]!=2)
//					copyMap[i][j]=map[i][j];
//				else {
//					copyMap[i][j]=0;
//				}
//			}
//		}
		
		//2는 조합에서 선택된부분만 넣어주고.
		for(int i=0; i<visit.length; i++) {
			if(visit[i]) {
				int Y = chicken.get(i).y;
				int X = chicken.get(i).x;
				q.add(new Node(Y,X,0));
//				copyMap[Y][X]=2;
				visited[Y][X]=true;
			}
		}
//		System.out.println(q);

		while (!q.isEmpty()) {
			Node n = q.poll();

//			System.out.println(n);
			for (int i = 0; i < 4; i++) {
				int ny = Y[i] + n.y;
				int nx = X[i] + n.x;
				
				if(ny<0 || nx<0 || ny>=N || nx>=N)
					continue;
				if(visited[ny][nx])
					continue;
				if(map[ny][nx]==0) {
					copyMap[ny][nx]=n.who+1;
					q.add(new Node(ny,nx,n.who+1));
					visited[ny][nx]=true;
				}else if(map[ny][nx]==1) {
					copyMap[ny][nx]=n.who+1;
					sum += n.who+1;
					visited[ny][nx]=true;
					q.add(new Node(ny,nx,n.who+1));
					house-=1;
				}else if(map[ny][nx]==2) {
					copyMap[ny][nx]=n.who+1;
					visited[ny][nx]=true;
					q.add(new Node(ny,nx,n.who+1));
				}
				
				if(house==0) {
//					for(int[] data: copyMap)
//						System.out.println(Arrays.toString(data));
//					System.out.println(sum);
					if(sum<ans) {
						ans = sum;
//						System.out.println(ans);
					}
					return;
				}
				
			}
		}
	}

	static class Node {
		int y, x, who;

		public Node(int y, int x, int who) {
			super();
			this.y = y;
			this.x = x;
			this.who = who;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", who=" + who + "]";
		}

		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}

	private static String src = "5 3\r\n" + "0 0 1 0 0\r\n" + "0 0 2 0 1\r\n" + "0 1 2 0 0\r\n" + "0 0 1 0 0\r\n"
			+ "0 0 0 0 2";
}