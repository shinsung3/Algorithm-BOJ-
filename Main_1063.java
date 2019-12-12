import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static int ky = 0;
	static int kx = 0;
	static int sy = 0;
	static int sx = 0;
	static int map[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);

		String str = sc.nextLine();
		StringTokenizer token = new StringTokenizer(str);

		String king = "";
		String stone = "";
		int n = 0;

		while (token.hasMoreTokens()) {
			king = token.nextToken();
			stone = token.nextToken();
			n = Integer.parseInt(token.nextToken());
		}

		map = new int[8][8];
		// map에 king 위치, 돌 위치 설정하기
		for (int i = 0; i < 2; i++) {
			char[] first = new char[2];
			if (i == 0) {
				first[0] = king.charAt(0);
				first[1] = king.charAt(1);
			} else {
				first[0] = stone.charAt(0);
				first[1] = stone.charAt(1);
			}

			int y = 0;
			int x = 0;
			for (int j = 0; j < 2; j++) {
				switch (first[j]) {
				case 'A':
					x = 0;
					break;
				case 'B':
					x = 1;
					break;
				case 'C':
					x = 2;
					break;
				case 'D':
					x = 3;
					break;
				case 'E':
					x = 4;
					break;
				case 'F':
					x = 5;
					break;
				case 'G':
					x = 6;
					break;
				case 'H':
					x = 7;
					break;
				case '1':
					y = 7;
					break;
				case '2':
					y = 6;
					break;
				case '3':
					y = 5;
					break;
				case '4':
					y = 4;
					break;
				case '5':
					y = 3;
					break;
				case '6':
					y = 2;
					break;
				case '7':
					y = 1;
					break;
				case '8':
					y = 0;
					break;
				}
			}
			if (i == 0) {
				map[y][x] = 1; // king은 1
				ky = y;
				kx = x;
			} else {
				map[y][x] = 2; // stone은 2
				sy = y;
				sx = x;
			}
		}

//		for (int i[] : map) {
//			System.out.println(Arrays.toString(i));
//		}
//		System.out.println();

		for (int i = 0; i < n; i++) {
			String line = sc.nextLine();
			if (line.equals("R")) {
				r_move();
			} else if (line.equals("L")) {
				l_move();
			} else if (line.equals("B")) {
				b_move();
			} else if (line.equals("T")) {
				t_move();
			} else if (line.equals("RT")) {
				rt_move();
			} else if (line.equals("LT")) {
				lt_move();
			} else if (line.equals("RB")) {
				rb_move();
			} else if (line.equals("LB")) {
				lb_move();
			}
		}

//		for (int i[] : map) {
//			System.out.println(Arrays.toString(i));
//		}
//		System.out.println();

		int yx[] = new int[4];
		yx[0] = kx;
		yx[1] = ky;
		yx[2] = sx;
		yx[3] = sy;

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0) {
				switch (yx[i]) {
				case 0:
					sb.append("A");
					break;
				case 1:
					sb.append("B");
					break;
				case 2:
					sb.append("C");
					break;
				case 3:
					sb.append("D");
					break;
				case 4:
					sb.append("E");
					break;
				case 5:
					sb.append("F");
					break;
				case 6:
					sb.append("G");
					break;
				case 7:
					sb.append("H");
					break;
				}
			} else {
				switch (yx[i]) {
				case 7:
					sb.append("1");
					break;
				case 6:
					sb.append("2");
					break;
				case 5:
					sb.append("3");
					break;
				case 4:
					sb.append("4");
					break;
				case 3:
					sb.append("5");
					break;
				case 2:
					sb.append("6");
					break;
				case 1:
					sb.append("7");
					break;
				case 0:
					sb.append("8");
					break;
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	static void r_move() {
		int kkx = kx + 1;
		if (kkx < 8) {
			if (kkx == sx && ky == sy) {
				if (sx + 1 < 8) {
					map[ky][kx] = 0;
					map[sy][sx] = 0;
					kx = kkx;
					sx += 1;
					map[ky][kx] = 1;
					map[sy][sx] = 2;
				}
			} else {
				map[ky][kx] = 0;
				kx = kkx;
				map[ky][kx] = 1;
			}
		}
	}

	static void l_move() {
		int kkx = kx - 1;
		if (kkx > -1) {
			if (kkx == sx && ky == sy) {
				if (sx - 1 > -1) {
					map[ky][kx] = 0;
					map[sy][sx] = 0;
					kx = kkx;
					sx -= 1;
					map[ky][kx] = 1;
					map[sy][sx] = 2;
				}
			} else {
				map[ky][kx] = 0;
				kx = kkx;
				map[ky][kx] = 1;
			}
		}
	}

	static void b_move() {
		int kkx = ky + 1;
		if (kkx < 8) {
			if (kkx == sy && kx == sx) {
				if (sy + 1 < 8) {
					map[ky][kx] = 0;
					map[sy][sx] = 0;
					ky = kkx;
					sy += 1;
					map[ky][kx] = 1;
					map[sy][sx] = 2;
				}
			} else {
				map[ky][kx] = 0;
				ky = kkx;
				map[ky][kx] = 1;
			}
		}
	}

	static void t_move() {
		int kkx = ky - 1;
		if (kkx > -1) {
			if (kkx == sy && kx == sx) {
				if (sy - 1 > -1) {
					map[ky][kx] = 0;
					map[sy][sx] = 0;
					ky = kkx;
					sy -= 1;
					map[ky][kx] = 1;
					map[sy][sx] = 2;
				}
			} else {
				map[ky][kx] = 0;
				ky = kkx;
				map[ky][kx] = 1;
			}
		}
	}

	static void rt_move() {
		int kkx = kx + 1;
		int kky = ky - 1;
		if (kkx < 8 && kky > -1) {
			if (kkx == sx && kky == sy) {
				if (sx + 1 < 8 && sy - 1 > -1) {
					map[ky][kx] = 0;
					map[sy][sx] = 0;
					kx = kkx;
					ky = kky;
					sx += 1;
					sy -= 1;
					map[ky][kx] = 1;
					map[sy][sx] = 2;
				}
			} else {
				map[ky][kx] = 0;
				kx = kkx;
				ky = kky;
				map[ky][kx] = 1;
			}
		}
	}

	static void lt_move() {
		int kkx = kx - 1;
		int kky = ky - 1;
		if (kkx > -1 && kky > -1) {
			if (kkx == sx && kky == sy) {
				if (sx - 1 > -1 && sy - 1 > -1) {
					map[ky][kx] = 0;
					map[sy][sx] = 0;
					kx = kkx;
					ky = kky;
					sx -= 1;
					sy -= 1;
					map[ky][kx] = 1;
					map[sy][sx] = 2;
				}
			} else {
				map[ky][kx] = 0;
				kx = kkx;
				ky = kky;
				map[ky][kx] = 1;
			}
		}
	}

	static void rb_move() {
		int kkx = kx + 1;
		int kky = ky + 1;
		if (kkx < 8 && kky < 8) {
			if (kkx == sx && kky == sy) {
				if (sx + 1 < 8 && sy + 1 < 8) {
					map[ky][kx] = 0;
					map[sy][sx] = 0;
					kx = kkx;
					ky = kky;
					sx += 1;
					sy += 1;
					map[ky][kx] = 1;
					map[sy][sx] = 2;
				}
			} else {
				map[ky][kx] = 0;
				kx = kkx;
				ky = kky;
				map[ky][kx] = 1;
			}
		}
	}

	static void lb_move() {
		int kkx = kx - 1;
		int kky = ky + 1;
		if (kkx > -1 && kky < 8) {
			if (kkx == sx && kky == sy) {
				if (sx - 1 > -1 && sy + 1 < 8) {
					map[ky][kx] = 0;
					map[sy][sx] = 0;
					kx = kkx;
					ky = kky;
					sx -= 1;
					sy += 1;
					map[ky][kx] = 1;
					map[sy][sx] = 2;
				}
			} else {
				map[ky][kx] = 0;
				kx = kkx;
				ky = kky;
				map[ky][kx] = 1;
			}
		}
	}

	private static String src = "A1 A2 1\r\n" + "R";
}
