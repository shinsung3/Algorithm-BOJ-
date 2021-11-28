package Silver3;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1449 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt(); // 물이 새는 곳의 개수
		int L = sc.nextInt(); // 테이프의 길이
		int line[] = new int[N];
		for (int i = 0; i < N; i++) {
			line[i] = sc.nextInt();
		}
		
		Arrays.sort(line);
		boolean water[] = new boolean[1001];
		int cnt = 0;
		for (int j = 0; j < line.length; j++) {
			int startIdx = line[j];
			if (!water[startIdx]) {
				cnt++;
				for (int i = startIdx; i < startIdx + L; i++) {
					if (i >= water.length) {
						break;
					} else {
						water[i] = true;
					}
				}
			}
		}
		System.out.println(cnt);

	}

	private static String src = "4 2\r\n" + "1 2 100 101";
}
