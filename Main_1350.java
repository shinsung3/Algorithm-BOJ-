import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int N = sc.nextInt();
		long map[] = new long[N];
		for (int i = 0; i < N; i++) {
			map[i] = sc.nextInt();
		}

//		System.out.println(Arrays.toString(map));
		int cluster = sc.nextInt();

		long sum = 0;
		for (int i = 0; i < N; i++) {
			if (map[i] != 0) {
				if (map[i] > cluster) {
					long temp = map[i] / cluster;
					long temp1 = map[i]%cluster;
					if(temp1!=0)
						sum += (temp+1) * cluster;
					else{
						sum+=temp*cluster;
					}
				} else {
					sum += cluster;
				}
			}
		}
		System.out.println(sum);

	}

	private static String src = "5\r\n" + 
			"16 32 128 128 0\r\n" + 
			"32768";
}