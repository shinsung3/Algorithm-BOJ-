package Silver4;

import java.util.Scanner;

public class Main_21920 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt();
		long answer = 0;
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int X = sc.nextInt();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if(gcd(X, arr[i])==1) {
				answer += arr[i];
				cnt++;
			}
		}
		System.out.printf("%.6f", (double)answer / cnt); // 오차범위 계산
	}

	// 1이외에는 공약수를 가지지 않을때 서로소이다
	static int gcd(int x, int y) {
		while (y != 0) {
			int temp = x % y;
			x = y;
			y = temp;
		}
		return x;
	}

	static String src = "5\r\n" + "4 2 8 5 7\r\n" + "4";
}
