import java.util.Scanner;

public class Main_1371 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int[] alphabet = new int[26];
		int max = 0;
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) >= 'a' && line.charAt(i) <= 'z') {
					alphabet[line.charAt(i) - 'a']++;
					max = Math.max(alphabet[line.charAt(i) - 'a'], max);
				}
			}
		}
		for (int i = 0; i < 26; i++) {
			if (max == alphabet[i]) {
				System.out.print((char) (i + 'a'));
			}
		}
	}

	private static String src = "baekjoon online judge";
}
