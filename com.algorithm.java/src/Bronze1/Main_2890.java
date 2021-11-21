package Bronze1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main_2890 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int R = sc.nextInt();
		int C = sc.nextInt();
		sc.nextLine();
		List<Node> list = new ArrayList<Main_2890.Node>();
		int min = Integer.MAX_VALUE;
		for(int i=0; i<R; i++) {
			String line = sc.nextLine();
			int cnt = 0;
			for(int j=C-2; j>=0; j--) {
				cnt++;
				if(line.charAt(j)=='S') {
					break;
				}else if(line.charAt(j)!='.') {
					list.add(new Node(cnt, line.charAt(j)-'0'));
					min = Math.min(line.charAt(j)-'0', min);
					break;
				}
			}
		}
		
		Collections.sort(list, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.rank - o2.rank;
			}
		});
		
//		for(Node node: list)
//			System.out.println(node);
//		System.out.println();
		
		int rank = 1;
		int before = list.get(0).rank;
		Node nodeFirst = list.get(0);
		nodeFirst.rank = 1;
		list.remove(0);
		list.add(0, nodeFirst);
		for(int i=1; i<list.size(); i++) {
			Node n = list.get(i);
			if(before == n.rank) {
				n.rank = rank;
			}else {
				rank++;
				before = n.rank;
				n.rank = rank;
			}
			list.remove(i);
			list.add(i, n);
		}
		

//		for(Node node: list)
//			System.out.println(node);
//		System.out.println();
		
		Collections.sort(list, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.who - o2.who;
			}
		});
		
//		for(Node node: list)
//			System.out.println(node);
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).rank);
		}
	}
	
	static class Node{
		int rank;
		int who;
		public Node(int rank, int who) {
			super();
			this.rank = rank;
			this.who = who;
		}
		@Override
		public String toString() {
			return "Node [rank=" + rank + ", who=" + who + "]";
		}
	}
	static String src = "10 15\r\n"
			+ "S..........222F\r\n"
			+ "S.....111.....F\r\n"
			+ "S........333..F\r\n"
			+ "S........555..F\r\n"
			+ "S........444..F\r\n"
			+ "S.............F\r\n"
			+ "S........777..F\r\n"
			+ "S........888..F\r\n"
			+ "S........999..F\r\n"
			+ "S........666..F";
}
