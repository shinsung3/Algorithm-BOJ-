package Gold5;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1041 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		long N = sc.nextLong();
		int dice[] = new int[6];
		for (int i = 0; i < 6; i++) {
			dice[i] = sc.nextInt();
		}
		long answer = 0;
		if (N == 1) {
			Arrays.sort(dice);
			for (int i = 0; i < 5; i++) {
				answer += dice[i];
			}
		} else {
			long three = 4;
			long two = 4 * (2 * N - 3);
			long one = (N - 2) * (N - 2) + 4 * ((N - 2) * (N - 1));

			long min = dice[0];
			for (int i = 1; i < 6; i++) {
				min = Math.min(min, dice[i]);
			}

			answer += min * one;

			min = Long.MAX_VALUE;
			for (int i = 0; i < 6; i++) {
				for (int j = i + 1; j < 6; j++) {
					if (i + j != 5) {
						min = Math.min(min, dice[i] + dice[j]);
					}
				}
			}

			answer += min * two;

			int sum = 0;
			for (int i = 0; i < 3; i++) {
				sum += Math.min(dice[i], dice[5-i]);
			}
			
			answer += sum * three;

		}
		System.out.println(answer);
	}

	private static String src = "10\r\n" + "1 1 1 1 50 1";
}
