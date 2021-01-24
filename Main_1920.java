import java.util.HashSet;
import java.util.Scanner;

public class Main_1920 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt();
		HashSet<Long> set = new HashSet<Long>();
		for (int i = 0; i < N; i++) {
			set.add(sc.nextLong());
		}
		int M = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			long key = sc.nextLong();
			if(set.contains(key)) {
				sb.append(1);
			}else {
				sb.append(0);
			}
			if(i!=M-1) {
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
		
	}
	private static String src = "5\r\n" + 
			"4 1 5 2 3\r\n" + 
			"5\r\n" + 
			"1 3 7 9 5";
}