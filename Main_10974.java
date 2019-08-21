import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int N;
	static int K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt();
		
		int select[] = new int[N];
		for(int i=0; i<N; i++) {
			select[i] = i+1;
		}
		
		list = new ArrayList<>();
		permutation(0, N, select, new boolean[N]);
		Collections.sort(list);
		for(String s: list)
			System.out.println(s);
	}
	
	static List<String> list;
	static void permutation(int idx, int N, int[] select, boolean[] visit) {
		if(idx==N) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<select.length; i++) {
				if(i==select.length-1) {
					sb.append(select[i]);					
				}else {
					sb.append(select[i]).append(" ");
				}
			}
			list.add(sb.toString());
		}
		
		for(int i=idx; i<N; i++) {
			swap(idx, i, select);
			permutation(idx+1, N, select, visit);
			swap(idx, i, select);
		}
	}
	
	static void swap(int i, int j, int[] select) {
		int temp = select[i];
		select[i] = select[j];
		select[j] = temp;
	}

	private static String src = "3";
}
