import java.util.Scanner;

public class Main_1388 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		String line = sc.nextLine();
		int N = Integer.parseInt(line.split(" ")[0]); // 세로
		int M = Integer.parseInt(line.split(" ")[1]); // 가로
		char[][] room = new char[N][M];
		for (int i = 0; i < N; i++) {
			room[i] = sc.nextLine().toCharArray();
		}

		int row = check(room, N, M, false, '-');
		int col = check(room, M, N, true, '|');
//		System.out.println(row);
//		System.out.println(col);
		System.out.println(row + col);
	}

	static int check(char[][] room, int row, int col, boolean chck, char key) {
		int cnt = 0;
		for (int i = 0; i < row; i++) {
			int total = 0;
			for (int j = 0; j < col; j++) {
				if (!chck) {
					if (key == room[i][j]) {
						total++;
					} else {
						if (total >= 1) {
							cnt++;
						}
						total = 0;
					}
				} else {
					if (key == room[j][i]) {
						total++;
					} else {
						if (total >= 1) {
							cnt++;
						}
						total = 0;
					}
				}
			}
			if (total >= 1)
				cnt++;
		}
		return cnt;
	}

	private static String src = "4 5\r\n" + "-||--\r\n" + "-||--\r\n" + "-||--\r\n" + "-|---";
}
