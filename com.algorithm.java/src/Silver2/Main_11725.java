package Silver2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_11725 {
	static int[] answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt();
		List<Integer> list[] = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			list[b].add(a);
		}
//		for (List<Integer> a : list) {
//			System.out.println(a);
//		}
		boolean[] visit = new boolean[N + 1];
		answer = new int[N + 1];
		dfs(list, N, visit, 1);
		for (int i = 2; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

	static void dfs(List<Integer> list[], int N, boolean[] visit, int root) {
		if (visit[root]) {
			return;
		}
		for (int i = 0; i < list[root].size(); i++) {
//			System.out.println(list[root].get(i));
			if (visit[list[root].get(i)]) {
				continue;
			}
			answer[list[root].get(i)] = root;
//			System.out.println(Arrays.toString(answer));
			visit[root] = true;
			dfs(list, N, visit, list[root].get(i));
			visit[root] = false;
		}
	}

	static String src = "7\r\n" + "1 6\r\n" + "6 3\r\n" + "3 5\r\n" + "4 1\r\n" + "2 4\r\n" + "4 7";
}
