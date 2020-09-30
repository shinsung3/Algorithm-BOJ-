import java.util.Scanner;

public class Main_6749 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int last = sc.nextInt();
		int second = sc.nextInt();

		int diff = second - last;
		System.out.println(second + diff);
	}

	private static String src = "12\r\n" + "15";
}