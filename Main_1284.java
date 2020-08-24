import java.util.Scanner;

public class Main_1284 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		while (true) {
			String line = sc.nextLine();
			if (line.equals("0"))
				break;
			int size = 2;// 여백 2
			size += line.length() - 1;
			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) == '1') {
					size += 2;
				} else if (line.charAt(i) == '0') {
					size += 4;
				} else {
					size += 3;
				}
			}
			System.out.println(size);
		}
	}

	private static String src = "120\r\n" + "5611\r\n" + "100\r\n" + "0";
}