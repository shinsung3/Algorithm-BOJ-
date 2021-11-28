package Bronze3;

import java.util.Scanner;
import java.util.Stack;

public class Main_14720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt();
//		맨 처음에는 딸기우유를 한 팩 마신다.
//		딸기우유를 한 팩 마신 후에는 초코우유를 한 팩 마신다.
//		초코우유를 한 팩 마신 후에는 바나나우유를 한 팩 마신다.
//		바나나우유를 한 팩 마신 후에는 딸기우유를 한 팩 마신다. 
//		0은 딸기우유만을 파는 가게, 1은 초코우유만을 파는 가게, 2는 바나나우유만을 파는 가게
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < N; i++) {
			int milk = sc.nextInt();
			if (!stack.isEmpty()) {
				if (milk == 0) {
					if (stack.peek() == 2) {
						stack.push(milk);
					}
				} else if (milk == 1) {
					if (stack.peek() == 0) {
						stack.push(milk);
					}
				} else if (milk == 2) {
					if (stack.peek() == 1) {
						stack.push(milk);
					}
				}
			} else {
				if (milk == 0) {
					stack.push(milk);
				}
			}
		}
		System.out.println(stack.size());
	}

	private static String src = "7\r\n" + "0 1 2 0 1 2 0";
}
