package Silver5;

import java.util.Scanner;

public class Main_1459 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		long x = sc.nextLong();
		long y = sc.nextLong();
		long w = sc.nextLong(); // 평행 이동
		long s = sc.nextLong(); // 대각선 이동
		long ans = 0;

		// 평행 이동
		long move1 = (x + y) * w;

		// 짝수, 홀수에 따른 이동
		long move2;
		if ((x + y) % 2 == 0) { // x + y가 짝수면
			move2 = Math.max(x, y) * s;
		} else { // x + y가 홀수면
			move2 = (Math.max(x, y) - 1) * s + w;
		}

		// 대각선 + 평행 이동
		long move3 = (Math.min(x, y) * s) + (Math.abs(x - y) * w);
		ans = Math.min(Math.min(move2, move1), move3);
		System.out.println(ans);
	}

	static String src = "4 2 3 10";
}
