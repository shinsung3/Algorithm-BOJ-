import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int N = sc.nextInt();
		
		long[] arr = new long[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextLong();
		}
		
		Arrays.sort(arr);
		
		System.out.println(arr[N-1]);
		
	}
		

	private static String src = "3\r\n" + 
			"3 2 1";
}