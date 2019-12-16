import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i]= sc.nextInt();
		}
		int[] dp = new int[N+1];
		dp[1] = 1;
		int max=1;
		for(int i=2; i<=N; i++) {
			dp[i] = 1;
			for(int j=i; j>=0; j--) {
				if(arr[i]>arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

	private static String src = "5\r\n" + 
			"8 9 1 2 10";

}
