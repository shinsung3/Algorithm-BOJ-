import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
	
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int R = sc.nextInt();
			int N = sc.nextInt();

			if (R == N)
				System.out.println(1);
			else {
				long ans = 1;
				int cnt=0;
				int len = N-R;
				long ans1 = 1;
				while(true) {
					ans1*=N;
					N--;
					if(ans1%ans==0 && ans<=len) {
						ans1/=ans;
						ans++;
					}
					cnt++;
					if(cnt==(len))
						break;
				}
				System.out.println(ans1);
			}
		}
	}

	private static String src = "3\r\n" + "2 2\r\n" + "1 5\r\n" + "13 29";
}