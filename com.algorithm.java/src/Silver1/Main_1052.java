package Silver1;

import java.util.Scanner;

public class Main_1052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int answer = 0;
		while (true) {
			char[] binary = Integer.toBinaryString(N).toCharArray();
			int cnt = 0;
			for (int i = 0; i < binary.length; i++) {
				if (binary[i] == '1') {
					cnt++;
				}
			}
			if(cnt<=K) {
				System.out.println(answer);
				break;
			}
			N++;
			answer++;
		}
	}

	private static String src = "1000000 5";
}
