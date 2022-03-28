package Gold5;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_15465 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);

		int N = sc.nextInt();
		int[] origin = new int[N];
		int[] perfect = new int[N];
		for (int i = 0; i < N; i++) {
			origin[i] = sc.nextInt();
			perfect[i] = origin[i];
		}

		// 1. perfect -> 정렬된 배열이 필요함.
		Arrays.sort(perfect);

		int cnt = 0;
		for (int i = origin.length - 1; i >= 0; i--) {
			if (origin[i] != perfect[i]) {
				for (int j = i; j >= 1; j--) {
					// 2. 연달아 나오면 1개로 보겠다. [2 4 7 7 9 3] -> [2 4 3 7 7 9]
					if (origin[j] == origin[j - 1]) {
						continue;
					}
					// 2 3 4 7 7 9
					if (origin[j] == perfect[i]) { // [2 4 7 7 9 3] -> [2 4 7 7 3 9]
						int temp = origin[j];
						origin[j] = origin[i];
						origin[i] = temp;
						cnt++;
						break;
					}
				}
			}
		}
		System.out.println(cnt);
	}

	private static String src = "6\r\n" + "2\r\n" + "4\r\n" + "7\r\n" + "7\r\n" + "9\r\n" + "3";
}
