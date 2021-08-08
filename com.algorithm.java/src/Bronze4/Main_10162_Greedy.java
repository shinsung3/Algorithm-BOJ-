package Bronze4;

import java.util.Scanner;

public class Main_10162_Greedy {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int A = 300; // 5Ка
		int B = 60; // 1Ка
		int C = 10; // 10УЪ
		answer = 0;
		
		if (N % 10 != 0) {
			System.out.println(-1);
		} else {
			answer = 0;
			if (N >= A) {
				N = calculate(N, A);
			}
			System.out.print(answer+" ");
			answer = 0;
			if (N >= B) {
				N = calculate(N, B);
			}
			System.out.print(answer+" ");
			answer = 0;
			if (N >= C) {
				N = calculate(N, C);
			}
			System.out.println(answer);
		}
	}

	static int answer;

	static int calculate(int N, int value) {
		answer = N / value;
		return N%value;
	}
}
