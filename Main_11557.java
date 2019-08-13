import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int T = sc.nextInt();
		for(int ts=1; ts<=T; ts++) {
			int N = sc.nextInt();
			int max = 0;
			String ans = "";
			for(int i=0; i<N; i++) {
				String line = sc.next();
				int soju = sc.nextInt();
				
				if(max<soju) {
					max = soju;
					ans = line;
				}
			}
			System.out.println(ans);
		}
	}

	private static String src = "2\r\n" + 
			"3\r\n" + 
			"Yonsei 10\r\n" + 
			"Korea 10000000\r\n" + 
			"Ewha 20\r\n" + 
			"2\r\n" + 
			"Yonsei 1\r\n" + 
			"Korea 10000000";
}