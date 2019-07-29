import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt(); // N
		int R = sc.nextInt(); // R - 중복순열인듯 아닌듯..?
		int sort[] = new int[R];
		StringBuilder sb = new StringBuilder();
		permutation(sort, N, R, 0, sb);
		System.out.println(sb.toString());
	}
	
	static void permutation(int[] sort, int N, int M, int idx, StringBuilder sb) {
		if(idx==M) {
			for(int i: sort)
				sb.append(i).append(" ");
			sb.append("\n");
			return;
		}
		
		for(int i=(idx==0)?1:sort[idx-1]; i<=N; i++) {
			sort[idx]=i;
			permutation(sort, N, M, idx+1, sb);
		}
	}

	private static String src = "4 2";
}