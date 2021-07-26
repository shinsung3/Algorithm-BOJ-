import java.util.Scanner;

public class Main_14652 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int num = sc.nextInt();

		if (num == 0) {
			System.out.println(0 + " " + 0);
		} else {
			int ans = (num / M);
			int ans2 = num % M;
			System.out.println(ans + " " + ans2);
		}
	}
}
