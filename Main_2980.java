import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int N = sc.nextInt();
		int L = sc.nextInt();
		int pre = 0;
		int time = 0;

		for (int i = 0; i < N; i++) {
			int D = sc.nextInt();
			int R = sc.nextInt();
			int G = sc.nextInt();
			
			time += D-pre;
			pre = D;
			
			int red = time %(R+G);
			if(red<=R) {
				time+=(R-red);
			}
		}
		
		System.out.println(time+pre);

	}

	private static String src = "2 10\r\n" + "3 5 5\r\n" + "5 2 2";
}