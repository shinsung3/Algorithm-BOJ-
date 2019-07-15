import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static final int N = 100;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);

		String line = sc.nextLine();

		StringTokenizer token = new StringTokenizer(line);

		String X = token.nextToken();
//		System.out.println(X);
		String Y = token.nextToken();

		Stack<Integer> stackX = new Stack<>();
		Stack<Integer> stackY = new Stack<>();

		for (int i = X.length()-1; i >=0; i--) {
			stackX.push(X.charAt(i) - '0');
		}

		for (int i = Y.length()-1; i >=0; i--) {
			stackY.push(Y.charAt(i) - '0');
		}

		int[] ans = new int[5];
//		System.out.println(stackX+" "+stackY);

		int idx = 4;
		while (!stackX.isEmpty()) {
			int a = stackX.pop();
			ans[idx] = a;
			idx--;
		}

		idx = 4;
		while (!stackY.isEmpty()) {
			int a = stackY.pop();
//			System.out.println(a);
			int temp = ans[idx] + a;
			if (temp >= 10) {
				int tmp = temp % 10;
				ans[idx] = tmp;
				tmp = temp / 10;
				idx--;
				ans[idx] = ans[idx]+tmp;
			} else {
				ans[idx] = temp;
				idx--;
			}
		}

//		System.out.println(Arrays.toString(ans));
		String answer = "";
		boolean flag = false;
		for (int i = 0; i<ans.length; i++) {
			if (!flag) {
				if (ans[i] != 0) {
//					System.out.print(ans[i]);
					answer+=ans[i];
					flag = true;
				}
			}else {
//				System.out.print(ans[i]);
				answer+=ans[i];
			}
		}
//		System.out.println(answer);
		flag = false;
		for(int i=answer.length()-1; i>=0; i--) {
			if (!flag) {
				if (answer.charAt(i)!='0') {
					System.out.print(answer.charAt(i));
					flag = true;
				}
			}else {
				System.out.print(answer.charAt(i));
			}
		}
	}

	private static String src = "123 100";
}