import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[][][] map;
	static final int N = 5;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		map = new int[N][N][N];
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j][k] = sc.nextInt();
				}
			}
		}
		
//		for (int k = 0; k < N; k++) {
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(map[i][j][k]);
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
		
//		bfs();
//		int sel[] = {0,0,0,0,2};
//		realTrun(sel, map);
		turnMap(0, new int[5], 0, map);
		if(ans==0)
			System.out.println(-1);
		else
			System.out.println(ans);
	}
	
	static int Y[] = {-1,1,0,0,0,0};
	static int X[] = {0,0,-1,1,0,0};
	static int Z[] = {0,0,0,0,-1,1};
	
	static int ans;
	
	static void turnMap(int idx, int[] sel, int cnt, int map[][][]) {
		if(cnt==5) {
			int copyMap[][][] = new int[N][N][N];
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						copyMap[i][j][k] = map[i][j][k];
					}
				}
			}
			
//			System.out.println(Arrays.toString(sel));
			realTrun(sel, copyMap);
			return;
		}
		
		for(int i=0; i<4; i++) {
			sel[idx] = i;
			turnMap(idx+1, sel, cnt+1,map);
		}
	}
	
	static void realTrun(int sel[], int copyMap[][][]) {
		for(int i=0; i<sel.length; i++) {
			if(sel[i]!=0) {
				int map2[][] = new int[N][N];
				if(sel[i]==1) {
					for(int j=0; j<N; j++) {
						for(int k=N-1; k>=0; k--) {
							int temp = Math.abs(k-(N-1));
							map2[j][temp] = copyMap[k][j][i];
						}
					}
					for(int j=0; j<N; j++) {
						for(int k=N-1; k>=0; k--) {
							copyMap[j][k][i] = map2[j][k];
						}
					}
				}else if(sel[i]==2) {
					for(int j=0; j<N; j++) {
						for(int k=0; k<N; k++) {
							map2[(N-1)-k][(N-1)-j] = copyMap[k][j][i];
						}
					}
					for(int j=0; j<N; j++) {
						for(int k=N-1; k>=0; k--) {
							copyMap[j][k][i] = map2[j][k];
						}
					}
				}else if(sel[i]==3) {
					for(int j=0; j<N; j++) {
						for(int k=N-1; k>=0; k--) {
							map2[j][k] = copyMap[k][j][i];
						}
					}
					for(int j=0; j<N; j++) {
						for(int k=N-1; k>=0; k--) {
							copyMap[j][k][i] = map2[j][k];
						}
					}
				}
			}
		}
//		for (int k = 0; k < N; k++) {
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(copyMap[i][j][k]);
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
		bfs(copyMap);
	}
	
	static int temp = Integer.MAX_VALUE;
	
	static void bfs(int[][][] copyMap) {
		boolean[][][] visit = new boolean[N][N][N];
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0,0,0,0));
		visit[0][0][0] = true;
		boolean flag = false;
		while(!q.isEmpty()) {
			Node n = q.poll();
			if(n.y == N-1 && n.x==N-1 && n.z==N-1) {
				temp = (temp>n.cnt) ? n.cnt:temp;
				flag = true;
				break;
			}
			
			for(int i=0; i<6; i++) {
				int ny = Y[i] + n.y;
				int nx = X[i] + n.x;
				int nz = Z[i] + n.z;
				
				
				if(ny<0 || nx<0 || nz<0 || ny>=N || nx>=N || nz>=N)
					continue;
				
				if(visit[ny][nx][nz])
					continue;
				
				if(copyMap[ny][nx][nz]==1) {
					q.add(new Node(ny,nx,nz, n.cnt+1));
					visit[ny][nx][nz] = true;
				}
			}
		}
		if(flag) {
			ans = temp;
		}
//		System.out.println(ans);
	}
	
	static class Node{
		int y, x, z, cnt;

		public Node(int y, int x, int z, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.z = z;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", z=" + z + ", cnt=" + cnt + "]";
		}
		
	}

	private static String src = "1 1 1 1 1\r\n" + "0 0 0 0 0\r\n" + "0 0 0 0 0\r\n" + "0 0 0 0 0\r\n" + "0 0 0 0 0\r\n"
			+ "1 1 1 1 1\r\n" + "0 0 0 0 0\r\n" + "0 0 0 0 0\r\n" + "0 0 0 0 0\r\n" + "0 0 0 0 0\r\n" + "1 1 1 1 1\r\n"
			+ "0 0 0 0 0\r\n" + "0 0 0 0 0\r\n" + "0 0 0 0 0\r\n" + "0 0 0 0 0\r\n" + "1 1 1 1 1\r\n" + "0 0 0 0 0\r\n"
			+ "0 0 0 0 0\r\n" + "0 0 0 0 0\r\n" + "0 0 0 0 0\r\n" + "1 1 1 1 1\r\n" + "0 0 0 0 0\r\n" + "0 0 0 0 0\r\n"
			+ "0 0 0 0 0\r\n" + "0 2 0 0 0";
}