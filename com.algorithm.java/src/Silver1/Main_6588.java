package Silver1;

import java.util.Scanner;

public class Main_6588 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);

		boolean[] sosu = new boolean[1000001];
		sosu[0] = true;
		sosu[1] = true;

		for (int i = 2; i * i < 1000001; i++) {
			if (!sosu[i]) {
				if (i == 2) {
					sosu[2] = true;
				}
				for (int j = i * i; j < 1000001; j += i) {
					sosu[j] = true;
				}
			}
		}
//		System.out.println(Arrays.toString(sosu));

		while (true) {
			int N = sc.nextInt();
			if (N == 0) {
				break;
			}
			int ans = 0;
			int ansA = 0;
			int ansB = 0;
			boolean check = false;
			for (int i = 3; i <= N; i++) {
				if (!sosu[i]) {
					int a = i;
					int b = N - i;
					if (!sosu[a] && !sosu[b]) {
						check = true;
						int temp = b - a;
						ansA = a;
						ansB = b;
						ans = temp;
						break;
					}
				}
			}
			if (check) {
				System.out.println(N + " = " + ansA + " + " + ansB);
			} else {
				System.out.println("Goldbach's conjecture is wrong.");
			}
		}
	}

	static String src = "8\r\n" + "20\r\n" + "42\r\n" + "0";
}
