import java.util.Scanner;

public class Main_1384 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int test = 1;
		while (true) {
			String line = sc.nextLine();
			if (line.equals("0"))
				break;
			int n = Integer.parseInt(line);
			String[] arr = new String[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextLine();
			}
			int idx = n - 1;
			String[][] name = new String[n][n];
			for (int i = 0; i < n; i++) {
				name[i][0] = arr[i].split(" ")[0];
				int j = 1;
				while (true) {
					name[i][j] = arr[idx].split(" ")[0];
					j++;
					idx--;
					if (idx < 0)
						idx = n - 1;
					if (j == n)
						break;
				}
			}
			boolean check = false;
			StringBuilder sb = new StringBuilder();
			sb.append("Group ").append(test).append("\n");
			for (int j = 0; j < arr.length; j++) {
				String[] temp = arr[j].split(" ");
				for (int i = 0; i < temp.length; i++) {
					if (temp[i].equals("N")) {
						check = true;
						sb.append(name[j][i]).append(" was nasty about ").append(temp[0]).append("\n");
					}
				}
			}
			if (!check) {
				sb.append("Nobody was nasty").append("\n");
			}
			test++;
			System.out.println(sb.toString());
		}
	}

	private static String src = "5\r\n" + "Ann P N P P\r\n" + "Bob P P P P\r\n" + "Clive P P P P\r\n"
			+ "Debby P N P P\r\n" + "Eunice P P P P\r\n" + "6\r\n" + "Zheng P P P P P\r\n" + "Yeng P P P P P\r\n"
			+ "Xiao P P P P P\r\n" + "Will P P P P P\r\n" + "Veronica P P P P P\r\n" + "Utah P P P P P\r\n" + "0";
}
