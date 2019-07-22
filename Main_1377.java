import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt();
		List<Node> list = new ArrayList<>();
		
		//인덱스와 값을 list에 저장해주고,
		for(int i=0; i<N; i++) {
			list.add(new Node(sc.nextInt(), i));
		}
		
		Collections.sort(list);
		System.out.println(list);
		
		//그들의 차를 정답 배열에 저장
		int ans[] = new int[N];
		int idx=0;
		for(int i=0; i<N; i++) {
			if(idx< list.get(i).index-i) {
				idx = list.get(i).index-i;
			}
			
		}
		
//		System.out.println(Arrays.toString(ans));
		System.out.println(idx+1);
		
	}
	
	static class Node implements Comparable<Node>{
		int value, index;

		public Node(int value, int index) {
			super();
			this.value = value;
			this.index = index;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + ", index=" + index + "]";
		}

		@Override
		public int compareTo(Node o) {
			
			return this.value-o.value;
		}
		
		
	}

	private static String src = "5\r\n" + 
			"10\r\n" + 
			"1\r\n" + 
			"5\r\n" + 
			"2\r\n" + 
			"3";
}