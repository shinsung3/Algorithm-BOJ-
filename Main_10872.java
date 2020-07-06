import java.util.Scanner;

public class Main_10872 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(src);
		long n = sc.nextLong();
		if (n == 0) {
			System.out.println(1);
		} else {
			long ans = fibo(n);
			System.out.println(ans);
		}
	}

	static long fibo(long n) {
		if (n == 1) {
			return 1;
		} else {
			return n * fibo(n - 1);
		}
	}

	private static String src = "10";
}