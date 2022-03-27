package Silver3;

import java.util.Arrays;
import java.util.Scanner;

public class Main_15594 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);

		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] copyArr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			copyArr[i] = arr[i];
		}

		int cnt = 0;
		Arrays.sort(arr);
//		System.out.println(Arrays.toString(copyArr));
//		System.out.println(Arrays.toString(arr));
//		System.out.println();
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] != copyArr[i]) {
				for (int j = i; j >= 1; j--) {
					if (copyArr[j] == copyArr[j - 1]) {
						continue;
					}
					if (copyArr[j] == arr[i]) {
						int temp = copyArr[j];
						copyArr[j] = copyArr[i];
						copyArr[i] = temp;
						cnt++;
//						System.out.println(Arrays.toString(copyArr));
//						System.out.println(Arrays.toString(arr));
//						System.out.println();
						break;
					}
				}
			}
		}
		System.out.println(cnt);
	}

	private static String src = "6\r\n" + "2\r\n" + "4\r\n" + "7\r\n" + "7\r\n" + "9\r\n" + "3";
}
