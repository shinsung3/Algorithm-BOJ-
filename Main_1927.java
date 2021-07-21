import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_1927 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt();

		PriorityQueue<Long> pq = new PriorityQueue<Long>();
		for (int i = 0; i < N; i++) {
			long value = sc.nextInt();
			if(value==0) {
				if(pq.isEmpty()) {
					System.out.println(0);
				}else {
					System.out.println(pq.poll());
				}
			}else {
				pq.add(value);
			}
		}
	}

	private static String src = "9\r\n" + "0\r\n" + "12345678\r\n" + "1\r\n" + "2\r\n" + "0\r\n" + "0\r\n" + "0\r\n"
			+ "0\r\n" + "32";
}
