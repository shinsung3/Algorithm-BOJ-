package Bronze3;

import java.util.Scanner;

public class Main_2720_Greedy {

	static final int Quarter = 25;
	static final int Dime = 10;
	static final int Nickel = 5;
	static final int Penny = 1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			answer = 0;
			if (Quarter <= a) {
				a = solution(a, Quarter);
			}
			System.out.print(answer + " ");
			answer = 0;
			if (Dime <= a) {
				a = solution(a, Dime);
			}
			System.out.print(answer + " ");
			answer = 0;
			if (Nickel <= a) {
				a = solution(a, Nickel);
			}
			System.out.print(answer + " ");
			answer = 0;
			if (Penny <= a) {
				a = solution(a, Penny);
			}
			System.out.println(answer);
		}
	}

	static int answer;

	static int solution(int a, int value) {
		answer = a / value;
		return a % value;
	}

	private static String src = "3\r\n" + "124\r\n" + "25\r\n" + "194";
}
