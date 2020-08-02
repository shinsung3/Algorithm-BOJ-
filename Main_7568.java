import java.util.Arrays;
import java.util.Scanner;

public class Main_7568 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int n = Integer.parseInt(sc.nextLine());
		int[][] arr = new int[n][3];
		for (int i = 0; i < n; i++) {
			String temp[] = sc.nextLine().split(" ");
			arr[i][0] = Integer.parseInt(temp[0]);
			arr[i][1] = Integer.parseInt(temp[1]);
			arr[i][2] = i;
		}
		int[] rank = new int[n];
		Arrays.fill(rank, 1);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					continue;
				}
				if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					rank[i]++;
				}
			}
		}
		for (int a : rank) {
			System.out.print(a + " ");
		}
	}

	private static String src = "5\r\n" + "55 185\r\n" + "58 183\r\n" + "88 186\r\n" + "60 175\r\n" + "46 155";
}