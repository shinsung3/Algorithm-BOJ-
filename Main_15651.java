import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int arr[] = new int[M];
		
		System.out.println(Arrays.toString(arr));
		StringBuilder sb = new StringBuilder();
		combination(arr, N, M, 0, sb);
		System.out.println(sb.toString());
	}
	
	static void combination(int[] sort, int N, int M, int idx, StringBuilder sb) {
		if(idx==M) {
			for(int i:sort) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			sort[idx]=i;
			combination(sort, N, M, idx+1,sb);
		}
	}

	private static String src = "4 2";
}