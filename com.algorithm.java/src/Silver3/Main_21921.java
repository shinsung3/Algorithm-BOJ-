package Silver3;

import java.util.Scanner;

public class Main_21921 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt();
		int X = sc.nextInt();
		int[] days = new int[N];
		boolean everyDayZero = true;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			days[i] = sc.nextInt();
			if (i < X) {
				sum += days[i]; // 미리 x데이까지의 합을 구해둠
			}
			if (days[i] != 0) {
				everyDayZero = false;
			}
		}
		int maxSum = sum; // 초기 기간의 합
		int cnt = 1; // 기간의 합
		if (everyDayZero) {
			System.out.println("SAD");
		} else {
			// 슬라이딩 윈도우 시작
			int left = -1;
			int right = X-1;
			while (true) {
				// 윈도우를 한칸씩 오른쪽으로 이동하기.
				left++;
				right++;
				if (right >= N) {
					break;
				}
				// 합을 계산하여 정답 갱신
				sum = sum + days[right] - days[left];
				if (maxSum == sum) {
					cnt++;
				} else if (maxSum < sum) {
					maxSum = sum;
					cnt = 1;
				}
			}
			System.out.println(maxSum);
			System.out.println(cnt);
		}
	}

	static String src = "7 5\r\n" + "1 1 1 1 1 5 1";
}
