import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int target = sc.nextInt();
		int n = sc.nextInt();
		boolean remote[] = new boolean[10];

		for (int i = 0; i < n; i++) {
			int temp = sc.nextInt();
			remote[temp] = true;
		}

//		System.out.println(Arrays.toString(remote));

		int ans = Math.abs(target - 100);
		int idx=0;
//		System.out.println(ans);

		for (int i = 0; i <= 1000000; i++) {
			String a = String.valueOf(i);
			int len = a.length();

			boolean up = false;
			for (int j = 0; j < len; j++) {
				if (remote[a.charAt(j)-'0']) {
					up = true;
					break;
				}
			}

			if(!up){
				int min = Math.abs(target - i) + len;
				ans = Math.min(min, ans);
			}
		}
		System.out.println(ans);
//		System.out.println(idx);
	}
}