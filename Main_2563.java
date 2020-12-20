import java.util.Scanner;

public class Main_2563 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		map = new int[102][102];
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			coloring(sc.nextInt(), sc.nextInt());
		}
		int ans = 0;
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map.length; j++) {
				if(map[i][j]==1) {
					ans++;
				}
			}
		}
		System.out.println(ans);
	}

	static int[][] map;

	static void coloring(int x, int y) {
		for (int i = 100 - y; i > 90 - y; i--) {
			for (int j = 100 - x; j > 90 - x; j--) {
				map[i][j] = 1;
//				System.out.println((100-i) + " "+ (100-j));
			}
		}
	}

	private static String src = "3\r\n" + "3 7\r\n" + "15 7\r\n" + "5 2";
}