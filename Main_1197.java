import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	static int unionfind[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int V = sc.nextInt(); //정점의 갯수
		int E = sc.nextInt(); //간선의 갯수.
		
		//1. 제일먼저, 자신의 Root를 자신으로 설정.
		unionfind = new int[V+1];
		for(int i=1; i<=V; i++)
			unionfind[i] = i;
		
		//2. 가중치가 작은 순서부터 고르기 위해서 오름차순 정렬을 위해 Arraylist에 담아줌.
		ArrayList<Node> list = new ArrayList<>();
		for(int i=0; i<E; i++)
			list.add(new Node(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		
		Collections.sort(list);
		
		long ans = 0;
		for(int i=0; i<E; i++) {
			int x = list.get(i).A;
			int y = list.get(i).B;
			
			if(findroot(y)!=findroot(x)) {
				unionfind[findroot(y)] = unionfind[x];
				ans += list.get(i).C;
			}
		}
		
		System.out.println(ans);
		
	}
	
	static int findroot(int num) {
		if(num != unionfind[num])
			return unionfind[num] = findroot(unionfind[num]);
		else
			return num;
	}
	
	static class Node implements Comparable<Node>{
		int A, B, C;

		public Node(int a, int b, int c) {
			super();
			A = a;
			B = b;
			C = c;
		}

		@Override
		public String toString() {
			return "Node [A=" + A + ", B=" + B + ", C=" + C + "]";
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.C-o.C;
		}
		
	}

	private static String src = "3 3\r\n" + 
			"1 2 1\r\n" + 
			"2 3 2\r\n" + 
			"1 3 3";
}