package Bronze4;

import java.util.Arrays;
import java.util.Scanner;

public class Main_5575 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);

		int[][] hms = new int[3][6];

		for (int i = 0; i < 3; i++) {
			String line = sc.nextLine();
			String[] arr = line.split(" ");
			for (int j = 0; j < 6; j++) {
				hms[i][j] = Integer.parseInt(arr[j]);
			}
		}

		int[][] answer = new int[3][3];
		int idx = 0;
		for (int[] hmsData : hms) {
			for (int i = 2; i >= 0; i--) {
				int time = hmsData[i + 3] - hmsData[i];
				if (time < 0) {
					hmsData[i + 3] += 60;
					hmsData[i + 3 - 1]--;
					time = hmsData[i + 3] - hmsData[i];
					answer[idx][i] = time;
				} else {
					answer[idx][i] = time;
				}
			}
			idx++;
		}

		for (int[] a : answer) {
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
		}
	}

	static String src = "9 0 0 18 0 0\r\n" + "9 0 1 18 0 0\r\n" + "12 14 52 12 15 30";
}
