import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt();
		long dp[] = new long[N + 1];

		if (N == 1)
			System.out.println(0);
		else {
			dp[1] = 0;
			dp[2] = 1;
			for (int i = 3; i <= N; i++) {
				// dp[n-2] = ���� n�� ������ ��ȯ�ϴ� ���,
				// dp[n-1] = ���� n�� ������ ��ȯ�ߴµ�, ��, n�� �ٸ� ������ ������ �� ���
				// n-1 = �� �ٸ��ְ� n-1�� �ִ�.
				dp[i] = ((dp[i - 1] + dp[i - 2]) % 1000000000) * (i - 1) % 1000000000;
			}

			System.out.println(dp[N]);
		}
	}

	private static String src = "5";
}