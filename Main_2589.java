import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt(); //세로
		int M = sc.nextInt(); //가로
		sc.nextLine();
		char map[][] = new char[N][M];
		
		for(int i=0; i<N; i++) {
			String line = sc.nextLine();
//			System.out.println(line);
			for(int j=0; j<M; j++) {
				map[i][j]= line.charAt(j);
			}
		}
		
//		for(char[] data: map)
//			System.out.println(Arrays.toString(data));
		bfs(map, N, M);
		
		System.out.println(ans);
		
	}
	
	static int Y[] = {-1,1,0,0};
	static int X[] = {0,0,-1,1};
	static int ans;
	
	static void bfs(char[][] map, int N, int M) {
		Queue<Node> q = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]=='L') {
					boolean visit[][] = new boolean[N][M];
					q.add(new Node(i,j,0));
					visit[i][j] = true;
					
					while(!q.isEmpty()) {
						Node n = q.poll();
//						System.out.println(n);
						if(n.cnt>ans)
							ans=n.cnt;
						
						for(int ii=0; ii<4; ii++) {
							int ny = Y[ii] + n.y;
							int nx = X[ii]+n.x;
							
							if(ny<0 || nx<0 || ny>=N || nx>=M)
								continue;
							if(visit[ny][nx])
								continue;
							if(map[ny][nx]=='L') {
								q.add(new Node(ny, nx, n.cnt+1));
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
		int cnt;
		public Node(int y, int x, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", cnt=" + cnt + "]";
		}
		
	}

	private static String src = "5 7\r\n" + 
			"WLLWWWL\r\n" + 
			"LLLWLLL\r\n" + 
			"LWLWLWW\r\n" + 
			"LWLWLLL\r\n" + 
			"WLLWLWW";
}