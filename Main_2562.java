import java.util.Scanner;

public class Main_2562 {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(src);
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int idx = 0;
		for (int i = 0; i < 9; i++) {
			int n = sc.nextInt();
			if (max < n) {
				max = n;
				idx = i + 1;
			}
		}
		System.out.println(max);
		System.out.println(idx);
	}

	private static String src = "3\r\n" + "29\r\n" + "38\r\n" + "12\r\n" + "57\r\n" + "74\r\n" + "40\r\n" + "85\r\n"
			+ "61";
}