import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt();
		List<Node> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			list.add(new Node(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		int cnt=0;
		for(int i=100; i<=987; i++) {
			if(i/100==0 || (i%100)/10==0 || (i%100)%10 == 0)
				continue;
			if(i/100==(i%100)/10 || (i%100)%10==i/100 || (i%100)/10==(i%100)%10)
				continue;
			
			boolean flag = false;
			for(int j=0; j<N; j++) {
				int s=0;
				int b=0;
				int temp = list.get(j).yagu;
				int A = temp/100;
				int B = (temp%100)/10;
				int C = (temp%100)%10;
				if(i/100==A) {
					s++;
				}else if(i/100==C || i/100==B) {
					b++;
				}
				if((i%100)/10 == B) {
					s++;
				}else if((i%100)/10==A ||(i%100)/10==C) {
					b++;
				}
				if((i%100)%10 == C) {
					s++;
				}else if((i%100)%10 == A || (i%100)%10 == B) {
					b++;
				}
				if(list.get(j).s==s && list.get(j).b==b) {
					continue;
				}else {
					flag = true;
					break;
				}
			}
			if(!flag) {
//				System.out.println(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	static class Node {
		int yagu, s, b;

		public Node(int yagu, int s, int b) {
			super();
			this.yagu = yagu;
			this.s = s;
			this.b = b;
		}

		@Override
		public String toString() {
			return "Node [yagu=" + yagu + ", s=" + s + ", b=" + b + "]";
		}
		
		
	}

	private static String src = "4\r\n" + 
			"123 1 1\r\n" + 
			"356 1 0\r\n" + 
			"327 2 0\r\n" + 
			"489 0 1";
}