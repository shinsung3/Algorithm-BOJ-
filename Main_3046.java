import java.util.Scanner;

public class Main_3046 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);

		int x = sc.nextInt();
		int ans = sc.nextInt();

		ans = ans * 2 - x;
		System.out.println(ans);
	}

	private static String src = "11 15";
}