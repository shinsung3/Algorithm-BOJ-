package Silver5;

import java.util.Scanner;

public class Main_1343 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		String line = sc.nextLine();
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		String A = "AAAA";
		String B = "BB";
		boolean fail = false;

		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == 'X') {
				cnt++;
			} else {
				if (cnt > 0) {
					if (cnt % 2 == 0) {
						int aCnt = cnt / 4;
						for (int j = 0; j < aCnt; j++) {
							sb.append(A);
						}
						int bCnt = cnt - aCnt * 4;
						bCnt = bCnt / 2;
						for (int j = 0; j < bCnt; j++) {
							sb.append(B);
						}
						cnt = 0;
					} else {
						fail = true;
						System.out.println(-1);
						break;
					}
				}
				sb.append(line.charAt(i));
			}
		}
		if (!fail) {
			if (cnt != 0) {
				if (cnt % 2 == 0) {
					int aCnt = cnt / 4;
					for (int j = 0; j < aCnt; j++) {
						sb.append(A);
					}
					int bCnt = cnt - aCnt * 4;
					bCnt = bCnt / 2;
					for (int j = 0; j < bCnt; j++) {
						sb.append(B);
					}
					cnt = 0;
				} else {
					fail = true;
					System.out.println(-1);
				}
			}
			if (!fail) {
				System.out.println(sb.toString());
			}
		}
	}

	private static String src = "XXXX....XXX.....XX";
}
