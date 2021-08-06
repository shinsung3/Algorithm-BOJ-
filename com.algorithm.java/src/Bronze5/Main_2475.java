package Bronze5;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2475 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		String[] arr = sc.nextLine().split(" ");
		int[] answer = new int[arr.length];
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			answer[i] = Integer.parseInt(arr[i])*Integer.parseInt(arr[i]);
			sum += answer[i];
		}
		System.out.println(sum%10);
	}

	private static String src = "0 4 2 5 6";
}