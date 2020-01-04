import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_5014_스타트링크 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int F = sc.nextInt(); // 스타트링크 전체 건물 층수
		int S = sc.nextInt(); // 강호가 있는 층수
		int G = sc.nextInt(); // 가야하는 층
		int U = sc.nextInt(); // 올라갈 수 있는 층 수
		int D = sc.nextInt(); // 내려갈 수 있는 층수
		
		bfs(F, S, G, U, D);
		if(ans==Integer.MAX_VALUE) {
			System.out.println("use the stairs");
		}else
			System.out.println(ans);
	}
	
	static int ans = Integer.MAX_VALUE;
	static void bfs(int F, int S, int G, int U, int D) {
		int idx[] = new int[2];
		idx[0] = U;
		idx[1] = -D;
		boolean[] visit = new boolean[F+1];
		Queue<Node> q = new LinkedList<>();
		
		visit[S] = true;
		q.add(new Node(0,S));
		
		while(!q.isEmpty()) {
			
			Node n = q.poll();
			if(n.idx==G) {
				ans = Math.min(ans, n.cnt);
				continue;
			}
			
			for(int i=0; i<2; i++) {
				int ny = idx[i]+n.idx;
				
				if(ny<0 || ny>=F+1)
					continue;
				if(visit[ny])
					continue;
				q.add(new Node(n.cnt+1, ny));
				visit[ny] = true;
			}
		}
	}
	
	static class Node{
		int cnt;
		int idx;

		public Node(int cnt, int idx) {
			super();
			this.cnt = cnt;
			this.idx = idx;
		}

		@Override
		public String toString() {
			return "Node [cnt=" + cnt + ", idx=" + idx + "]";
		}
		
	}
	private static String src = "10 1 10 2 1";
}