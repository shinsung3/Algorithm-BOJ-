package Silver4;

import java.util.Scanner;

public class Main_14490 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		String line = sc.nextLine();
		String arr[] = line.split(":");
		int[] value = new int[2];
		value[0] = Integer.parseInt(arr[0]);
		value[1] = Integer.parseInt(arr[1]);

		int max = Math.max(value[0], value[1]);

		int idx = 2;
		while (true) {
			if (max == idx) {
				break;
			}
			if (value[0] % idx == 0 && value[1] % idx == 0) {
				value[0] = value[0] / idx;
				value[1] = value[1] / idx;
				Math.max(value[0], value[1]);
				idx = 2;
			} else {
				idx++;
			}
		}
		System.out.println(value[0]+":"+value[1]);
	}

	static String src = "18:24";
}
