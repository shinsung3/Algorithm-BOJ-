package Silver4;

import java.util.Scanner;

public class Main_1543 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		String line = sc.nextLine();
		String line2 = sc.nextLine();

		int idx = 0;
		int cnt = 0;
		while (true) {
			if(idx>=line.length()) {
				break;
			}
			boolean isSame = true;
			if (line.charAt(idx) == line2.charAt(0)) {
				int len = 0;
				for (int j = 0; j < line2.length(); j++) {
					if(idx + j >= line.length()) {
						break;
					}
					
					if (line.charAt(idx + j) != line2.charAt(j)) {
						isSame = false;
						break;
					}else {
						len++;
					}
				}
				if(len != line2.length()) {
					isSame = false;
				}
				if (isSame) {
					cnt++;
					idx += line2.length();
				} else {
					idx++;
				}
			} else {
				idx++;
			}
		}
		System.out.println(cnt);
	}

	static String src = "ababababa\r\n" + "ababa";
}
