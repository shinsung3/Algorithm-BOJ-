import java.util.Arrays;
import java.util.Scanner;

public class Main_1926 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt(); // ¼¼·Î
		int M = sc.nextInt(); // °¡·Î
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
//		for (int[] a : map)
//			System.out.println(Arrays.toString(a));

		int answerMax = 0;
		int cnt = 0;
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					max = 1;
					visit[i][j] = true;
					dfs(map, i, j, N, M);
					if(answerMax<max) {
						answerMax = max;
					}
//					System.out.println(max);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(answerMax);
	}

	static int Y[] = { -1, 1, 0, 0 };
	static int X[] = { 0, 0, -1, 1 };
	static boolean visit[][];
	static int max;
	
	static void dfs(int[][] map, int y, int x, int N, int M) {
		for(int i=0; i<4; i++) {
			int ny = Y[i] + y;
			int nx = X[i] + x;
			
			if(ny<0 || nx<0 || ny>=N || nx>=M)
				continue;
			if(visit[ny][nx])
				continue;
			if(map[ny][nx]==0)
				continue;
			visit[ny][nx] = true;
			dfs(map, ny, nx, N, M);
			max++;
		}
	}

	private static String src = "6 5\r\n" + "1 1 0 1 1\r\n" + "0 1 1 0 0\r\n" + "0 0 0 0 0\r\n" + "1 0 1 1 1\r\n"
			+ "0 0 1 1 1\r\n" + "0 0 1 1 1";
}
