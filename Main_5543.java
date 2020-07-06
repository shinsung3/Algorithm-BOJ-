import java.util.Arrays;
import java.util.Scanner;

public class Main_5543 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(src);
		int burger[] = new int[3];
		for (int i = 0; i < 3; i++) {
			burger[i] = sc.nextInt();
		}
		int juice[] = new int[2];
		for (int i = 0; i < 2; i++) {
			juice[i] = sc.nextInt();
		}

		Arrays.sort(burger);
		Arrays.sort(juice);
		int answer = burger[0] + juice[0] - 50;
		System.out.println(answer);
	}

	private static String src = "800\r\n" + "700\r\n" + "900\r\n" + "198\r\n" + "330";
}