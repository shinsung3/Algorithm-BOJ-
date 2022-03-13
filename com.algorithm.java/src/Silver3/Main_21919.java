package Silver3;

import java.util.Scanner;

public class Main_21919 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt();
		long answer = 1;
		for (int i = 0; i < N; i++) {
			long a = sc.nextLong();
			if (isPrimeNumber(a)) {
				answer = lcm(answer, a);
			}
		}

		if(answer == 1)
			System.out.println(-1);
		else
			System.out.println(answer);
	}

	static boolean isPrimeNumber(long x) {
		for (int i = 2; i <= Math.sqrt(x); i++) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}

	static long gcd(long x, long y) {
		while (y != 0) {
			long temp = x % y;
			x = y;
			y = temp;
		}
		return x;
	}

	static long lcm(long x, long y) {
		return x / gcd(x, y) * y;
	}

	static String src = "4\r\n" + "4 16 64 256";
}
