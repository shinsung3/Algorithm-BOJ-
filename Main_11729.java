import java.util.Scanner;

public class Main_11729 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println((int) Math.pow(2, n) - 1);
		recur(n, 1, 2, 3);
		System.out.println(sb.toString());
	}

	static StringBuilder sb = new StringBuilder();

	static void recur(int n, int start, int mid, int end) {
		if (n == 1) {
			sb.append(start).append(" ").append(end).append("\n");
//			System.out.println(start+"에서 "+end+"로 이동");

		}
		// 1.start -> end -> mid -> start -> end -> mid 무한 반복
		else {
			// 1. n-1개를 start-> end로 이동
			recur(n - 1, start, end, mid);
			// 2. 1개를 start-> end로 이동
			sb.append(start).append(" ").append(end).append("\n");
//			System.out.println(start+"에서 "+end+"로 이동");
			// 3. n-1개를 다시 mid-> end로 이동
			recur(n - 1, mid, start, end);
		}
	}
}