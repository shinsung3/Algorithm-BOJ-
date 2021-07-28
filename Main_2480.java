import java.util.Scanner;

public class Main_2480 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int sum = 0;
		if(a==b && b==c) {
			sum += (10000 + a*1000);
		}else if((a==b && a!=c) || (a==c && b!=c) || (b==c && c!=a) ){
			if(a==b) {
				sum+= (1000 + a*100);
			}else if(a==c) {
				sum += (1000 + a*100);
			}else if(b==c) {
				sum += (1000 + b*100);
			}
		}else {
			sum += Math.max(c, Math.max(a, b))*100;
		}
		
		System.out.println(sum);
	}

	private static String src = "3 3 6";
}
