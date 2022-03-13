package Bronze2;

import java.util.Scanner;

public class Main_21918 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt(); // 총 전구의 수
		int M = sc.nextInt(); // 전구 명형

		int[] light = new int[N];
		for (int i = 0; i < N; i++) {
			light[i] = sc.nextInt();
		}
		for (int i = 0; i < M; i++) {
			int order = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();

			if (order == 1) { // x위치 전구를 켠다
				light[x - 1] = y;
			} else if (order == 2) { // x~y위치의 전구를 변경한다
				for (int j = x - 1; j < y; j++) {
					if (light[j] == 0) {
						light[j] = 1;
					} else {
						light[j] = 0;
					}
				}
			} else if (order == 3) { // x~y 전구를 끈다
				for (int j = x - 1; j < y; j++) {
					light[j] = 0;
				}
			} else { // x ~ y 전구를 켠다
				for (int j = x - 1; j < y; j++) {
					light[j] = 1;
				}
			}
		}
		for(int i=0; i<light.length; i++) {
			System.out.print(light[i]+" ");
		}
	}

	static String src = "8 6\r\n" + "0 0 0 0 0 0 0 0\r\n" + "1 2 1\r\n" + "1 4 1\r\n" + "2 2 4\r\n" + "2 1 7\r\n"
			+ "3 5 8\r\n" + "4 4 6";
}
