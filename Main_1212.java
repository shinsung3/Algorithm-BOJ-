import java.util.Scanner;

public class Main_1212 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		String line = sc.nextLine();

		if (line.equals("0")) {
			System.out.println("0");
		} else {

			int arr[] = new int[3 * line.length()];
			int idx = arr.length - 1;

			for (int i = 0; i < line.length(); i++) {
				int temp = line.charAt(i) - '0';
				String a1 = Integer.toBinaryString(temp);
				if (a1.length() == 3) {
					for (int k = 0; k < a1.length(); k++) {
						arr[idx] = a1.charAt(k) - '0';
						idx--;
					}
				} else if (a1.length() == 2) {
					arr[idx] = 0;
					idx--;
					for (int k = 0; k < a1.length(); k++) {
						arr[idx] = a1.charAt(k) - '0';
						idx--;
					}
				} else {
					arr[idx] = 0;
					idx--;
					arr[idx] = 0;
					idx--;
					arr[idx] = Integer.parseInt(a1);
					idx--;
				}
			}
			boolean flag = false; // 제일 먼저 0이 나오면 출력 x

			for (int i = arr.length - 1; i >= 0; i--) {
				if (!flag) {
					if (arr[i] != 0) {
						flag = true;
						System.out.print(arr[i]);
					}
				} else {
					System.out.print(arr[i]);
				}
			}
		}

	}

	private static String src = "314";
}
