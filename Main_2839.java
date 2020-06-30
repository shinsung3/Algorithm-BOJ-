import java.util.Scanner;

public class Main_2839 {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(src);
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		//1. 5로 나눠지면 가장 알맞는 값임.
		if(n%5==0) {
			System.out.println(n/5);
		}else{
			int answer = 0;
			while(true) {
				n-=3;
				if(n<0) {
					System.out.println(-1);
					break;
				}
				answer++;
				if(n%5==0) {
					answer += n/5;
					System.out.println(answer);
					break;
				}
			}
		}
	}
	
	private static String src = "18";
}