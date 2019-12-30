import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int N = sc.nextInt();
		
		if(N%4==0 && (N%100!=0 || N%400==0)) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
		
		
	}
	private static String src = "2000";

}