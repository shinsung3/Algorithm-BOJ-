package Bronze1;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2828 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt(); // 사과가 떨어지는 칸의 개수

		boolean[] apple = new boolean[N + 1];
		for (int i = 1; i <= M; i++) {
			apple[i] = true;
		}
		int before = M;
		int cnt = 0;
		for (int i = 0; i < K; i++) {
			int num = sc.nextInt(); // 몇번째 칸에 사과가 떨어졌는지 확인
//			System.out.println(num + " " + before);
			if (!apple[num]) {
				boolean isFinish = false;
				if (num < before) {
					for (int j = apple.length - 1; j >= 1; j--) {
						if (apple[j]) {
							isFinish = true;
							before = j;
						} else {
							if (isFinish) {
								break;
							}
						}
					}
					apple = new boolean[N + 1];
					for (int j = num; j < num + M; j++) {
						apple[j] = true;
					}
				} else {
					for (int j = 1; j < apple.length; j++) {
						if (apple[j]) {
							isFinish = true;
							before = j;
						} else {
							if (isFinish) {
								break;
							}
						}
					}
					apple = new boolean[N + 1];
					for (int j = num - M + 1; j <= num; j++) {
						apple[j] = true;
					}
				}
				cnt += Math.abs(num - before);
				before = num;
			}
//			System.out.println(Arrays.toString(apple));
		}
		System.out.println(cnt);
	}

	private static String src = "5 2\r\n" + "3\r\n" + "1\r\n" + "5\r\n" + "3";
}
