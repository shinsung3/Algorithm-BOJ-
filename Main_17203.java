import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt(); //구간의 값
		int M = sc.nextInt(); //변화량
		
		int[] arr = new int[N+1];
		
		for(int i=1; i<N+1; i++) {
			arr[i] =sc.nextInt();
		}
//		System.out.println(Arrays.toString(arr));
		
		for(int i=0; i<M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			if(start==end)
				System.out.println(0);
			else {
				int sum=0;
				for(int ii=start; ii<end; ii++) {
					sum+=Math.abs(arr[ii+1]-arr[ii]);
				}
				System.out.println(sum);
			}
		}
	}

	private static String src = "4 3\r\n" + 
			"100 101 382 573\r\n" + 
			"1 1\r\n" + 
			"1 3\r\n" + 
			"2 4";
}