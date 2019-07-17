import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int N = sc.nextInt();
		int n[] = new int[N];
		for (int i = 0; i < N; i++) {
			n[i] = sc.nextInt();
		}

		long[] three = new long[80001];
		long[] seven = new long[80001];

		long temp = 0;
		for (int i = 0; i < three.length; i++) {
			if (i % 3 == 0) {
				temp += i;
			}
			three[i] = temp;
		}
		temp = 0;
		for (int i = 0; i < seven.length; i++) {
			if (i % 7 == 0) {
				if (i % 3 != 0)
					temp += i;
			}
			seven[i] = temp;
		}

		for (int i = 0; i < N; i++) {
			long sum = seven[n[i]] + three[n[i]];
			System.out.println(sum);
		}
	}

	private static String src = "2\r\n" + "10 21";
}