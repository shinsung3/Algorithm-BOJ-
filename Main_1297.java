import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int TV = sc.nextInt();
		int R = sc.nextInt();
		int C = sc.nextInt();
		
		long RR = R*R;
		long CC = C*C;
		long TV2 = TV*TV;
		double ans = (double)TV2/(double)(RR+CC);
		System.out.println((int)Math.sqrt(ans*RR) + " "+ (int)Math.sqrt(CC*ans));
	}

	private static String src = "52 9 16";
}