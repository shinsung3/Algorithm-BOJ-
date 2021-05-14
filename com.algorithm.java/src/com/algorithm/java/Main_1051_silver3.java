package com.algorithm.java;

import java.util.Scanner;

public class Main_1051_silver3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);

		int N = sc.nextInt();
		int M = sc.nextInt();

		sc.nextLine();
		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		int minPoint = 0;

		if (N >= M) {
			minPoint = M;
		} else {
			minPoint = N;
		}

//		for (char[] a : map)
//			System.out.println(Arrays.toString(a));

		boolean flag = false;
		for (int k = minPoint; k >= 0; k--) {
			flag = false;
			for (int i = 0; i <= N - k; i++) {
				for (int j = 0; j <= M - k; j++) {
					if (map[i][j] == map[i + k - 1][j] && map[i][j] == map[i][j + k - 1]
							&& map[i][j] == map[i + k - 1][j + k - 1]) {
						flag = true;
					}
				}
			}
			if (flag) {
				System.out.println((k) * (k));
				break;
			}
		}
		if (!flag)
			System.out.println(1);
	}

	static int sum(int a, int sum) {
		// Á¾·áÁ¶°Ç
		if (a > 100) {
			return sum;
		} else {
			return sum(a + 1, sum + a);
		}
	}

	static int multi(int a, int answer) {
		System.out.println(a);
		if (a < 1) {
			System.out.println(answer);
			return answer;
		}
		if (a % 2 == 0) {
			System.out.println("Â¦¼ö>> " + answer);
			return multi(a - 1, answer + a);
		} else {
			System.out.println("È¦¼ö >> " + answer);
			return multi(a - 1, answer * a);
		}
	}

	private static String src = "3 5\r\n" + "42101\r\n" + "22100\r\n" + "22101";
}
