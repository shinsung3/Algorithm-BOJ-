import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int X = sc.nextInt();
		
		int[][] map = new int[N+1][N+1];
		
		//���� ����� ���� ���Ѵ밪���� ����
		for(int[] data: map) {
			Arrays.fill(data, 1000_0001);
		}
		
		//�ڽŰ� �ڽ����� ���� ���� 0
		for(int i=0; i<N+1; i++) {
			map[i][i]=0;
		}
		
		for(int i=0; i<M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int w = sc.nextInt();
			map[start][end]=w;
		}
		
		//1���� �ϴ� ������ 1�� �������̱� ����
		for(int mid=1; mid<N+1; mid++) {
			for(int start=1; start<N+1; start++) {
				for(int end=1; end<N+1; end++) {
					map[start][end]=Math.min(map[start][end], map[start][mid]+map[mid][end]);
				}
			}
		}
		
		int result = 0;
		//�ڽ��� ������ X�� ��ȴٰ� �ٽ� �ڽ��� ������ ���ߵǴϱ�
		for(int i=1; i<N+1; i++) {
			result = Math.max(map[i][X]+map[X][i], result);
		}
		System.out.println(result);
		
	}

	private static String src = "4 8 2\r\n" + 
			"1 2 4\r\n" + 
			"1 3 2\r\n" + 
			"1 4 7\r\n" + 
			"2 1 1\r\n" + 
			"2 3 5\r\n" + 
			"3 1 2\r\n" + 
			"3 4 4\r\n" + 
			"4 2 3";
}