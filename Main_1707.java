import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_1707 {
	static boolean check = false;// üũ flag
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int T = sc.nextInt();
		for (int ts = 1; ts <= T; ts++) {
			int V = sc.nextInt();// ����
			int E = sc.nextInt();// ����
			List<Integer>[] list = new ArrayList[V + 1];
			check = false;
			
			for (int i = 0; i < V + 1; i++) {
				list[i] = new ArrayList<>();
			}
			int color[] = new int[V + 1];// ���� Ȯ��

			for (int i = 0; i < E; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();

				list[a].add(b);
				list[b].add(a);
			}

			// �̺б׷����� ���� �������� ������ �ٸ� ��

			for (int i = 1; i < V + 1; i++) {
				if (check)
					break;
				if (color[i] == 0)
					bfs(list, i, 1, color);
			}

			System.out.println(check ? "NO" : "YES");
		}

	}

	static void bfs(List<Integer>[] list, int start, int RedOrBlue, int[] color) {
		Queue<Integer> q = new LinkedList<>();

		q.add(start);
		color[start] = RedOrBlue; // ���� red���� üũ����

		while (!q.isEmpty()) {
			int v = q.poll();
			for (int adj : list[v]) {
				if (color[adj] == 0) {
					q.add(adj);
					color[adj] = color[v] * -1;
					// -1�� Blue
				} else if (color[adj] + color[v] != 0) {
					check = true;
					return;
				}
			}
		}
	}

	private static String src = "2\r\n" + "3 2\r\n" + "1 3\r\n" + "2 3\r\n" + "4 4\r\n" + "1 2\r\n" + "2 3\r\n"
			+ "3 4\r\n" + "4 2";
}