import java.util.Scanner;

public class Main_9655 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);

		int n = sc.nextInt();
		// 짝,홀 구분/ 짝- CY 승, 홀 - SK승
		if (n % 3 == 0) {
			if ((n / 3) % 2 == 0) {
				System.out.println("CY");
			} else {
				System.out.println("SK");
			}
		} else {
			if ((n / 3) % 2 == 0) { // 짝
				if (n % 3 == 1) {
					System.out.println("SK");
				} else {
					System.out.println("CY");
				}
			} else { // 홀
				if (n % 3 == 1) {
					System.out.println("CY");
				} else {
					System.out.println("SK");
				}
			}

		}
	}

	private static String src = "5";
}