package Silver2;

import java.util.Scanner;

public class Main_1455 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt(); // 세로 크기
		int M = sc.nextInt(); // 가로 크기
//		N개의 줄에 M개의 동전 상태
//		세준이는 모든 동전을 뒤집어서 앞면으로 만들려고 한다
		sc.nextLine();
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		int cnt = 0;
		for (int i = N - 1; i >= 0; i--) {
			for (int j = M - 1; j >= 0; j--) {
				if (map[i][j] == 1) {
					cnt++;
					for (int k = i; k >= 0; k--) {
						for (int l = j; l >= 0; l--) {
							if (map[k][l] == 1) {
								map[k][l] = 0;
							} else {
								map[k][l] = 1;
							}
						}
					}
//						System.out.println();
//						for(int[] a: map)
//							System.out.println(Arrays.toString(a));
				}
			}
		}
		System.out.println(cnt);
	}

	private static String src = "2 2\r\n" + "00\r\n" + "01";
}
