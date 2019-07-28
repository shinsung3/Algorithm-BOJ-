import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int Ax = sc.nextInt();
		int Ay = sc.nextInt();
		int Az = sc.nextInt();

		int Cx = sc.nextInt();
		int Cy = sc.nextInt();
		int Cz = sc.nextInt();

		int Bx = Math.abs(Az - Cx);
		int By =0;
		if(Cy<Ay) {
			By=Ay/Cy;
		}else {
			By=Cy/Ay;
		}
		int Bz = Math.abs(Ax - Cz);

		System.out.println(Bx + " " + By + " " + Bz);
	}

	private static String src = "15 16 17\r\n" + 
			"19 32 90";
}