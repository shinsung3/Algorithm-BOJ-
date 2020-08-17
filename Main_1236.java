import java.util.Arrays;
import java.util.Scanner;

public class Main_1236 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);

		String[] str = sc.nextLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);

		boolean[] col = new boolean[M];
		boolean[] row = new boolean[N];
		for (int i = 0; i < N; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < M; j++) {
				if (line.charAt(j) == 'X') {
					row[i] = true;
					col[j] = true;
				}
			}
		}

		int rCnt = 0;
		int cCnt = 0;
		for (int i = 0; i < N; i++) {
			if (!row[i]) {
				rCnt++;
			}
		}
		for (int i = 0; i < M; i++) {
			if (!col[i]) {
				cCnt++;
			}
		}

		System.out.println(cCnt > rCnt ? cCnt : rCnt);
	}

	private static String src = "4 5\r\n" + ".....\r\n" + ".....\r\n" + ".....\r\n" + "..X..";
}