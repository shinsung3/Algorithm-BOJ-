import java.util.Scanner;

public class Main_1362 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int idx = 0;
		while (true) {
			int normal = sc.nextInt();
			int now = sc.nextInt();
			if (normal == 0 && now == 0)
				break;
			int start = normal / 2; // 1/2초과
			int end = normal * 2; // 2배 미만.
			sc.nextLine();
			boolean die = false;
			while (true) {
				String line = sc.nextLine();
				if (line.equals("# 0"))
					break;
				if (!die) {
					String[] check = line.split(" ");
					if (check[0].equals("E")) {
						now -= Integer.parseInt(check[1]);
					} else if (check[0].equals("F")) {
						now += Integer.parseInt(check[1]);
					}
					// 중간에 죽은거 확인하기.
				}
				if (now <= 0) {
					die = true;
				}
			}

			idx++;
			if (now <= 0) {
				System.out.println(idx + " RIP");
				continue;
			}
			if (start < now && end > now) {
				System.out.println(idx + " :-)");
				continue;
			}
			System.out.println(idx + " :-(");
		}
	}

	private static String src = "100 100\r\n" + "F 10\r\n" + "F 10\r\n" + "E 200\r\n" + "# 0\r\n" + "50 30\r\n"
			+ "F 5\r\n" + "E 20\r\n" + "# 0\r\n" + "0 0";
}