import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt();

		int chess[] = new int[N];
		bfs(N, chess, 0);
		System.out.println(ans);
	}

	static int ans;

	static void bfs(int N, int[] chess, int row) {
		if (row == N)
			ans++;
		else {

			for (int i = 0; i < N; i++) {
				chess[row] = i;
				if (isPossible(row, chess)) {
					bfs(N, chess, row + 1);
				}
			}
		}
	}

	static boolean isPossible(int row, int[] chess) {
		for (int i = 0; i < row; i++) {
			if (chess[i] == chess[row])
				return false;
			if (Math.abs(chess[i] - chess[row]) == Math.abs(i - row)) {
				return false;
			}
		}
		return true;
	}

	private static String src = "8";
}