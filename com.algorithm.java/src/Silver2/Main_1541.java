package Silver2;

import java.util.Scanner;

public class Main_1541 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);

		String line[] = sc.nextLine().split("-");

		for (int i = 0; i < line.length; i++) {
			String key = line[i];
			if (key.contains("+")) {
				String[] plus = key.split("\\+");
				int sum = 0;
				for (int j = 0; j < plus.length; j++) {
					sum += Integer.parseInt(plus[j]);
				}
				line[i] = Integer.toString(sum);
			}
		}

		int answer = 0;
		for (int i = 0; i < line.length; i++) {
			if (i == 0) {
				if (line[i].length() == 0) {
					continue;
				} else {
					answer += Integer.parseInt(line[i]);
				}
			} else {
				answer -= Integer.parseInt(line[i]);
			}
		}
		System.out.println(answer);

	}

	private static String src = "55-50+40";
}
