package Silver5;

import java.util.Scanner;

public class Main_4796 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int idx = 0;
		while (true) {
			idx++;
			int L = sc.nextInt();
			int P = sc.nextInt();
			int V = sc.nextInt();

			if (L == 0 && P == 0 && V == 0) {
				break;
			}
			
			int mok = V/P;
			int namugi = Math.min(V%P, L);
			
			mok *= L;
			mok += namugi;
			System.out.println("Case "+idx+": "+mok);
		}
	}

	static String src = "5 8 20\r\n" + "5 8 17\r\n" + "0 0 0";
}
