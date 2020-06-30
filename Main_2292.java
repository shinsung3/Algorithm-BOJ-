import java.util.Scanner;

public class Main_2292 {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(src);
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		if (n == 1) {
			System.out.println(1);
		} else {
			long sum = 1;
			long key = 1;
			while (true) {
				sum += 6 * key;
				if (sum >= n) {
					key++;
					System.out.println(key);
					break;
				} else {
					key++;
				}
			}
		}

	}

	private static String src = "13";
}