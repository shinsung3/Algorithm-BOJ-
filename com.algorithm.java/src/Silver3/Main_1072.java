package Silver3;

import java.util.Scanner;

public class Main_1072 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);

		int x = sc.nextInt(); // 게임 횟수
		int y = sc.nextInt(); // 이긴 횟수

		int key = solve(x, y);
		int ans = -1;
		// 이분 탐색
		int left = 0;
		int right = (int) 1e9;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (solve(x + mid, y + mid) != key) {
				ans = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(ans);
	}

	static int solve(int x, int y) {
		return (int) ((long) y * 100 / x);
	}

	static String src = "1000000000 470000000";
}
