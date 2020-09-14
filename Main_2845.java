import java.util.Scanner;

public class Main_2845 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int size = sc.nextInt();
		int people = sc.nextInt();

		long total = size * people;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			sb.append(sc.nextLong() - total).append(" ");
		}
		System.out.println(sb.toString());
	}

	private static String src = "5 20\r\n" + "99 101 1000 0 97";
}