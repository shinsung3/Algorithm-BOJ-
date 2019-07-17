import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt();
		sc.nextLine();
		List<Node> list = new ArrayList<>();
		HashSet<String> set = new HashSet<>();
		for(int i=0; i<N; i++) {
			String line = sc.nextLine();
			
			if(set.contains(line)) {
				for(int ii=0; ii<list.size(); ii++) {
					if(list.get(ii).line.equals(line)) {
						Node nn = list.remove(ii);
						String a = nn.line;
						int b = nn.idx+1;
						list.add(new Node(a,b));
					}
				}
			}else {
				list.add(new Node(line, 1));
				set.add(line);
			}
		}
		
		int max=0;
		int index = 0;
		
		PriorityQueue<String> q = new PriorityQueue<>();

		for(int i=0; i<list.size(); i++) {
			if(list.get(i).idx>max) {
				max = list.get(i).idx;
				index = i;
			}
		}
		
//		System.out.println(max);
		for(int i=0; i<list.size(); i++){
			if(list.get(i).idx==max) {
				q.add(list.get(i).line);
			}
		}
		
		System.out.println(q.remove());
	}
	
	static class Node{
		String line;
		int idx;
		public Node(String line, int idx) {
			super();
			this.line = line;
			this.idx = idx;
		}
		@Override
		public String toString() {
			return "Node [line=" + line + ", idx=" + idx + "]";
		}
	}

	private static String src = "5\r\n" + 
			"top\r\n" + 
			"top\r\n" + 
			"top\r\n" + 
			"top\r\n" + 
			"kimtop";
}