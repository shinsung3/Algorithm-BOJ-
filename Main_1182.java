import java.util.Arrays;
import java.util.Scanner;

public class Main_1182 {

	static int N;
	static int S;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);

		N = sc.nextInt();
		S = sc.nextInt();

		int arr[] = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		visit = new boolean[N];
		powerSet(0, 0, arr, 0);
		System.out.println(ans);

	}

	static boolean visit[];
	static int ans;

	static void powerSet(int cnt, int a, int arr[], int sum) {

		if (cnt == N) {
			int falseCnt = 0;
			for (int i = 0; i < N; i++) {
				if (!visit[i]) {
					falseCnt++;
				}
			}
			if (falseCnt != N) {
				if (sum == S) {
					ans++;
				}
			}
			return;
		}
		visit[cnt] = true;
		powerSet(cnt + 1, a + 1, arr, sum + arr[cnt]);
		visit[cnt] = false;
		powerSet(cnt + 1, a, arr, sum);
	}

	private static String src = "5 0\r\n" + "-7 -3 -2 5 8";
}
