import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int T = sc.nextInt();
		
		for(int ts=1; ts<=T; ts++) {
			int y = 0;
			int k = 0;
			for(int i=0; i<9; i++) {
				y += sc.nextInt();
				k += sc.nextInt();
			}
			if(k<y) {
				System.out.println("Yonsei");
			}else if(k==y) {
				System.out.println("Draw");
			}else {
				System.out.println("Korea");
			}
		}
	}

	private static String src = "1\r\n" + 
			"1 0\r\n" + 
			"0 0\r\n" + 
			"0 0\r\n" + 
			"0 0\r\n" + 
			"0 0\r\n" + 
			"0 0\r\n" + 
			"0 0\r\n" + 
			"0 0\r\n" + 
			"0 0";
}