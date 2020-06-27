import java.util.Scanner;

public class Main_2869 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(src);
//		Scanner sc = new Scanner(System.in);

		long a = sc.nextLong(); // 낮에 올라갈 수 있는 높이
		long b = sc.nextLong(); // 밤에 미끄러져 내려오는 높이
		long v = sc.nextLong(); // 총 높이.

		if (a >= v) {
			System.out.println(1);
		} else {
			v -= a;
			long key = a - b;
			long ans = v / key;
			System.out.println(ans);
			if (v % key != 0) {
				ans++;
			}
			System.out.println(ans + 1);
		}
	}

	private static String src = "2 1 5";
}
