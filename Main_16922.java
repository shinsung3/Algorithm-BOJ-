import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);

		int N = sc.nextInt();

		int arr[] = new int[4];
		arr[0] = 1;
		arr[1] = 5;
		arr[2] = 10;
		arr[3] = 50;

		sel = new int[N];
		boolean visit[] = new boolean[50*20+1];
		combi(N, arr, 0,0, 0, visit);
		System.out.println(count);
		count=0;
	}

	static int sel[];
	static int count;
	
	static void combi(int N, int arr[], int idx, int cnt, int sum, boolean[] visit) {
		if(cnt == N) {
			if(!visit[sum]) {
				visit[sum]= true;
				count++;
			}
			return;
		}

		for (int i = idx; i < arr.length; i++) {
			combi(N, arr, idx, cnt + 1, sum+arr[i], visit);
		}
	}

	private static String src = "2";
}