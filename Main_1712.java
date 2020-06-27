import java.util.Scanner;

public class Main_1712 {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(src);
		Scanner sc = new Scanner(System.in);

		long a = sc.nextLong(); // 고정비용
		long b = sc.nextLong(); // 변동비용
		long c = sc.nextLong(); // 판매금액

		long margin = c - b;
		if (margin <= 0) {
			System.out.println(-1);
		} else {
			long n = a / margin;
			n++;
			System.out.println(n);
		}
	}

	private static String src = "1000 70 170";
}
