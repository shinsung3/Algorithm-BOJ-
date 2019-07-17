import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static final int N = 100;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int N = sc.nextInt();
		int Q = sc.nextInt();
		
		int music[] = new int[N];
		int time[] = new int[Q];
		for(int i=0; i<N; i++) {
			music[i] = sc.nextInt();
		}
		
		for(int j=0; j<Q; j++) {
			time[j] = sc.nextInt();
		}
		
//		System.out.println(Arrays.toString(music));
//		System.out.println(Arrays.toString(time));
		
		int idx=1;
		int I = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(true) {
			list.add(idx);
			music[I]--;
			if(music[I]==0) {
				I++;
				idx++;
			}
			
			if(I==N)
				break;
		}
		
//		System.out.println(list);
		for(int i=0; i<time.length; i++) {
			System.out.println(list.get(time[i]));
		}
	}

	private static String src = "3 5\r\n" + 
			"2\r\n" + 
			"1\r\n" + 
			"3\r\n" + 
			"2\r\n" + 
			"3\r\n" + 
			"4\r\n" + 
			"0\r\n" + 
			"1";
}