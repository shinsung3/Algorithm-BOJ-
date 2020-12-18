import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_11723 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int n = sc.nextInt();
		sc.nextLine();

		StringBuilder sb = new StringBuilder();
		boolean first = false;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			String line[] = sc.nextLine().split(" ");
			idx = -1;
			int value = 0;

			if (line[0].equals("all") || line[0].equals("empty")) {

			} else {
				value = Integer.parseInt(line[1]);
			}

			if (line[0].equals("add")) {
				list.add(value);
			} else if (line[0].equals("remove")) {
				check(list, list.size(), value);
				if (idx != -1)
					list.remove(idx);
			} else if (line[0].equals("toggle")) {
				check(list, list.size(), value);
				if (idx == -1) {
					list.add(value);
				} else {
					list.remove(idx);
				}
			} else if (line[0].equals("all")) {
				list.clear();
				for (int j = 0; j < 20; j++) {
					list.add(j + 1);
				}
			} else if (line[0].equals("empty")) {
				list.clear();
			} else {
				check(list, list.size(), value);
				if (first) {
					sb.append("\n");
				} else {
					first = true;
				}
				if (idx == -1) {
					sb.append(0);
				} else {
					sb.append(1);
				}
			}

		}

		System.out.println(sb.toString());
	}

	static int idx;

	static void check(List<Integer> list, int n, int value) {
		for (int j = 0; j < n; j++) {
			if (list.get(j) == value) {
				idx = j;
			}
		}
	}

	private static String src = "26\r\n" + "add 1\r\n" + "add 2\r\n" + "check 1\r\n" + "check 2\r\n" + "check 3\r\n"
			+ "remove 2\r\n" + "check 1\r\n" + "check 2\r\n" + "toggle 3\r\n" + "check 1\r\n" + "check 2\r\n"
			+ "check 3\r\n" + "check 4\r\n" + "all\r\n" + "check 10\r\n" + "check 20\r\n" + "toggle 10\r\n"
			+ "remove 20\r\n" + "check 10\r\n" + "check 20\r\n" + "empty\r\n" + "check 1\r\n" + "toggle 1\r\n"
			+ "check 1\r\n" + "toggle 1\r\n" + "check 1";
}