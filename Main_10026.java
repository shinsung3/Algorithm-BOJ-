import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int N = sc.nextInt();
		sc.nextLine();
		char[][] map = new char[N][N];
		
		for(int i=0; i<N; i++) {
			String line = sc.nextLine();
			for(int j=0; j<N; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		BFS(map, N);
		System.out.print(cnt+" ");
		cnt=0;
		BFSExceptGreen(map, N);
		System.out.println(cnt);
		
	}
	
	static int Y[] = {-1,1,0,0};
	static int X[] = {0,0,-1,1};
	static int cnt;
	
	static void BFSExceptGreen(char[][] map, int N) {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visit = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visit[i][j]) {
					cnt++;
					visit[i][j] = true;
					q.add(new Node(i,j,map[i][j]));
					while(!q.isEmpty()) {
						Node n = q.poll();
						
						for(int jj=0; jj<4; jj++) {
							int ny = Y[jj] + n.y;
							int nx = X[jj] + n.x;
							
							if(ny<0 || nx<0 || ny>=N || nx>=N)
								continue;
							if(visit[ny][nx])
								continue;
							
							if(map[ny][nx]==n.who) {
								q.add(new Node(ny,nx,n.who));
								visit[ny][nx]=true;
							}else {
								if(map[ny][nx]=='G' && n.who=='R') {
									q.add(new Node(ny,nx,n.who));
									visit[ny][nx]=true;
								}else if(map[ny][nx]=='R' && n.who=='G') {
									q.add(new Node(ny,nx,n.who));
									visit[ny][nx]=true;
								}
							}
						}
					}
				}
			}
		}
	}
	
	static void BFS(char[][] map, int N) {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visit = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visit[i][j]) {
					cnt++;
					visit[i][j] = true;
					q.add(new Node(i,j,map[i][j]));
					while(!q.isEmpty()) {
						Node n = q.poll();
						
						for(int jj=0; jj<4; jj++) {
							int ny = Y[jj] + n.y;
							int nx = X[jj] + n.x;
							
							if(ny<0 || nx<0 || ny>=N || nx>=N)
								continue;
							if(visit[ny][nx])
								continue;
							
							if(map[ny][nx]==n.who) {
								q.add(new Node(ny,nx,n.who));
								visit[ny][nx]=true;
							}
						}
					}
				}
			}
		}
	}
	
	static class Node{
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

	private static String src = "5\r\n" + 
			"RRRBB\r\n" + 
			"GGBBB\r\n" + 
			"BBBRR\r\n" + 
			"BBRRR\r\n" + 
			"RRRRR";
}