import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		long N = sc.nextLong();
		int door[] = new int[6];

		int zero = sc.nextInt();
		door[0] = zero;
		int temp = zero;
		for(int i=1; i<5; i++) {
			door[i] = 1-zero;
			zero = 1-zero;
		}
		if (N >= 6) {
			System.out.println("Love is open door");
		}else {
			for(int i=1; i<N; i++) {
				System.out.println(door[i]);
			}
		}
	}

	private static String src = "10\r\n" + "1";
}