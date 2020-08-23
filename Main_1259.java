import java.util.Scanner;

public class Main_1259 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		while (true) {
			String line = sc.nextLine();
			if (line.equals("0"))
				break;
			StringBuffer sb = new StringBuffer();
			sb.append(line).reverse();
			if (line.equals(sb.toString())) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}

	private static String src = "121\r\n" + "1231\r\n" + "12421\r\n" + "0";
}
