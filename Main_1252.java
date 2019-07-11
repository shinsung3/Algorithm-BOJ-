import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		String a = sc.nextLine();
		StringTokenizer token = new StringTokenizer(a);
		String line = token.nextToken();
		String line1 = token.nextToken();

		Stack<Integer> stackLine = new Stack<>();
		Stack<Integer> stackLine1 = new Stack<>();

		for (int i = 0; i < line.length(); i++) {
			stackLine.push(line.charAt(i) - '0');
		}

		for (int i = 0; i < line1.length(); i++) {
			stackLine1.push(line1.charAt(i) - '0');
		}
		Queue<Integer> q = new LinkedList<>();

		if (stackLine.size() > stackLine1.size()) {
			int up = 0;
			while (!stackLine1.isEmpty()) {
				int A = stackLine1.pop();
				int B = stackLine.pop();

				int ans = A + B + up;

				if (ans >= 2) {
					q.add(ans - 2);
					up = 1;
				} else {
					q.add(ans);
					up = 0;
				}
			}
			while (!stackLine.isEmpty()) {
				int A = stackLine.pop();

				int ans = A + up;

				if (ans >= 2) {
					q.add(ans - 2);
					up = 1;
				} else {
					q.add(ans);
					up = 0;
				}
			}
			if (stackLine1.size() == 0 && stackLine.size() == 0) {
				if (up == 1) {
					q.add(1);
				}
			}
		} else {
			int up = 0;
			while (!stackLine.isEmpty()) {
				int A = stackLine1.pop();
				int B = stackLine.pop();

				int ans = A + B + up;

				if (ans >= 2) {
					q.add(ans - 2);
					up = 1;
				} else {
					q.add(ans);
					up = 0;
				}
			}
			while (!stackLine1.isEmpty()) {
				int A = stackLine1.pop();

				int ans = A + up;

				if (ans >= 2) {
					q.add(ans - 2);
					up = 1;
				} else {
					q.add(ans);
					up = 0;
				}
			}
			if (stackLine1.size() == 0 && stackLine.size() == 0) {
				if (up == 1) {
					q.add(1);
				}
			}
		}
		long arr[] = new long[q.size()];
		int idx = 0;
		while (!q.isEmpty()) {
			arr[idx] = q.poll();
			idx++;
		}

		boolean flag = false;
		boolean isZero = false;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (!flag) {
				if (arr[i] == 0) {
					continue;
				}else {
					isZero = true;
					flag = true;
					System.out.print(arr[i]);
				}
			} else {
				System.out.print(arr[i]);
			}
		}
		if(!isZero) {
			System.out.println(0);
		}
	}

	private static String src = "1001101 10010";
}