import java.util.Scanner;

public class Main_1676 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int n = sc.nextInt();
		int two = 0;
		int five = 0;
		
		for (int i = 1; i <= n; i++) {

			int num = i;
			while (true) {
				if(num%2!=0 && num%5!=0) {
					break;
				}
				
				if (num % 2 == 0) {
					num /= 2;
					two++;
				}
				if (num % 5 == 0) {
					num /= 5;
					five++;
				}
				
			}
		}
		System.out.println(Math.min(two, five));

	}

	private static String src = "10";
}
