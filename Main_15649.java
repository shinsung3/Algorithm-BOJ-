import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
		
		value = new int[M];
		q = new ArrayList<>();
		permutation(N, M, 0,0, sort);
		Collections.sort(q);
		for(int i=0; i<q.size();i++) {
			System.out.println(q.get(i));
		}
		
	}

	static List<String> q;
	static int value[];
	static void permutation(int N, int M, int idx, int cnt, int[] sort) {
		if(idx==M) {
			String str = "";
			for(int i=0; i<value.length; i++) {
				if(i==value.length-1)
					str+=value[i];
				else {
					str+=value[i];
					str+=" ";
				}
			}
			q.add(str);
			return;
		}
		
		for(int i=idx; i<N; i++) {
			swap(i, idx, sort);
			value[idx] = sort[idx];
			permutation(N, M, idx+1, cnt, sort);
			swap(i,idx, sort);
		}
	}
	
	static void swap(int i, int j, int[] sort) {
		int temp = sort[i];
		sort[i] = sort[j];
		sort[j] = temp;
	}

	private static String src = "3 1";
}