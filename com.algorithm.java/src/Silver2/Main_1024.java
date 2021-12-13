package Silver2;

import java.util.Scanner;

public class Main_1024 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);

		int N = sc.nextInt();
		int L = sc.nextInt();

		solve(L, N);
	}
	
	static void solve(int L, int N) {
		boolean check = false;
		for (int i = L; i <= 100; i++) {
			int t = ((i - 1) * i) / 2;
			int x = (N - t) / i;
			int y = (N - t) % i;
			if (x >= 0 && y == 0) {
				for (int ii = x; ii < x + i; ii++) {
					check = true;
					System.out.print(ii + " ");
				}
				break;
			}
		}
		if(!check) {
			System.out.println(-1);
		}
	}

	static String src = "1000000000 2";
}
