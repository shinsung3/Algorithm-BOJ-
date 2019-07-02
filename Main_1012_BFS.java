import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_유기농배추_BFS_신성 {
	
	static int map[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int T = sc.nextInt();
		
		for(int ts=1; ts<=T; ts++) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			map = new int[N][M];
			
			for(int i=0; i<K; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				map[b][a]=1;
			}
			
			
			bfs(N, M);
			
			System.out.println(ans);
			ans=0;
		}
		
	}
	
	static int Y[] = {-1,1,0,0};
	static int X[] = {0,0,-1,1};
	static int ans;
	static void bfs(int N, int M) {
		Queue<Node> q = new LinkedList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==1) {
					q.add(new Node(i,j));
					map[i][j]=2;
					while(!q.isEmpty()) {
						Node n = q.poll();
						
						for(int ii=0; ii<4; ii++) {
							int ny = Y[ii]+n.y;
							int nx = X[ii]+n.x;
							
							if(ny<0 || nx<0 || ny>=N || nx>=M)
								continue;

							if(map[ny][nx]==1) {
								q.add(new Node(ny, nx));
								map[ny][nx]=2;
							}
							
							
						}
					}
					ans++;
//					for(int[] data: map)
//						System.out.println(Arrays.toString(data));
//					System.out.println();
				}
			}
		}
	}
	
	static class Node{
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

	private static String src = "2\r\n" + 
			"10 8 17\r\n" + 
			"0 0\r\n" + 
			"1 0\r\n" + 
			"1 1\r\n" + 
			"4 2\r\n" + 
			"4 3\r\n" + 
			"4 5\r\n" + 
			"2 4\r\n" + 
			"3 4\r\n" + 
			"7 4\r\n" + 
			"8 4\r\n" + 
			"9 4\r\n" + 
			"7 5\r\n" + 
			"8 5\r\n" + 
			"9 5\r\n" + 
			"7 6\r\n" + 
			"8 6\r\n" + 
			"9 6\r\n" + 
			"10 10 1\r\n" + 
			"5 5";
}
