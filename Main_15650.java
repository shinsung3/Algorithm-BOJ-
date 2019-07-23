import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int sort[] = new int[N];
		
		for(int i=0; i<N; i++) {
			sort[i] = i+1;
		}
		
//		System.out.println(Arrays.toString(sort));
		powerSet(0, 0, sort, new boolean[N], N, M);
	}
	
	static void powerSet(int idx, int cnt, int[] sort, boolean[] visit, int N, int M) {
	
		if(cnt==M)
		{
			for(int i=0; i<N; i++) {
				if(visit[i]) {
					System.out.print(sort[i]+" ");
				}
			}
			System.out.println();
			return;
		}
		
		if(idx==N)
			return;
		
		visit[idx] = true;
		powerSet(idx+1, cnt+1, sort, visit, N, M);
		visit[idx] = false;
		powerSet(idx+1, cnt, sort, visit, N, M);
	}
	
	private static String src = "4 2";
}