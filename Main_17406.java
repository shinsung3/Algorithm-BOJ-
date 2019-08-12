import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int map[][];
	static int K;
	static int N;
	static int M;
	static int per[];
	static List<Node> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);

		N = sc.nextInt();
		M = sc.nextInt();

		K = sc.nextInt(); // 횟수

		per = new int[K];
		for (int i = 0; i < K; i++) {
			per[i] = i;
		}

		map = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		list = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			list.add(new Node(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		ran = new ArrayList<>();
//		for (int[] data : map)
//			System.out.println(Arrays.toString(data));
//		System.out.println();
		turnRange();
		permutation(new boolean[K], 0, per);
		System.out.println(ans);

	}

	// 1. 제일 먼저 순서를 정해줘야 된다.
	static void permutation(boolean visit[], int k, int[] sel) {
		if (k == K) {
			turn();
			return;
		}

		for (int i = k; i < K; i++) {
			swap(i, k, sel);
			permutation(visit, k + 1, sel);
			swap(i, k, sel);
		}
	}

	static void swap(int i, int j, int[] sel) {
		int temp = sel[i];
		sel[i] = sel[j];
		sel[j] = temp;
	}
	////////////////////////// 순서를 정해준 부분 (순열)///////////////////

	// 2. 순서를 정한 뒤에는 돌릴 범위를 찾아줌.
	static List<Range> ran;

	static void turnRange() {
		for (int i = 0; i < K; i++) {
			int start = (list.get(per[i]).r - list.get(per[i]).s);
			int end = (list.get(per[i]).c - list.get(per[i]).s);
			int start2 = (list.get(per[i]).r + list.get(per[i]).s);
			int end2 = (list.get(per[i]).c + list.get(per[i]).s);
			ran.add(new Range(start, end, start2, end2));

		}
	}

	/////////////////////////////////////////////////////////////
	// 3. 배열 돌리기 시작!! + 카피해야됨.
	static void turn() {
		int map2[][] = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map2[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < per.length; i++) {
			int idx = 0;
			Range r = ran.get(per[i]);
			while (true) {
				int s = r.start + idx;
				int e = r.end + idx;
				int s2 = r.start2 - idx;
				int e2 = r.end2 - idx;
				
//				System.out.println(s+" "+e+" "+s2+" "+e2);
//				System.out.println(Arrays.toString(per));
				if(s2-s<=0)
					break;

				int tmp = map2[s][e];

				for (int j = 0; j < s2- s; j++) {
					map2[s+j][e]=map2[s+j+1][e];
				}
				
				for (int j = 0; j < s2- s; j++) {
					map2[s2][e+j]=map2[s2][e+j+1];
				}
		
				for (int j = 0; j < s2- s; j++) {
					map2[s2-j][e2]=map2[s2-j-1][e2];
				}
				
				for (int j = 0; j < s2- s; j++) {
					map2[s][e2-j]=map2[s][e2-j-1];
				}
				
				map2[s][e+1] = tmp;

//				for (int[] data : map2)
//					System.out.println(Arrays.toString(data));
//				System.out.println();
				idx++;
			}
		}
		
		for(int i=1; i<N+1; i++) {
			int sum=0;
			for(int j=1; j<M+1;j++) {
				sum += map2[i][j];
			}
			if(ans>sum) {
				ans = sum;
			}
		}
	}
	
	static int ans = Integer.MAX_VALUE;

	static class Node {
		int r, c, s;

		public Node(int r, int c, int s) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", s=" + s + "]";
		}

	}

	static class Range {
		int start, end, start2, end2;

		public Range(int start, int end, int start2, int end2) {
			super();
			this.start = start;
			this.end = end;
			this.start2 = start2;
			this.end2 = end2;
		}

		@Override
		public String toString() {
			return "Range [start=" + start + ", end=" + end + ", start2=" + start2 + ", end2=" + end2 + "]";
		}

	}

	private static String src = "5 6 2\r\n" + "1 2 3 2 5 6\r\n" + "3 8 7 2 1 3\r\n" + "8 2 3 1 4 5\r\n"
			+ "3 4 5 1 1 1\r\n" + "9 3 2 1 4 3\r\n" + "3 4 2\r\n" + "4 2 1";
}