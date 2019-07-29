import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt(); //학생 수
		int M = sc.nextInt(); //보성이의 위치
		
		int mySeat[] = new int[N];
		
		for(int i=0;i<N; i++) {
			mySeat[i] = sc.nextInt();
		}
		
//		System.out.println(Arrays.toString(mySeat));
		
		int key = 0;
		boolean visit[] = new boolean[N];
		boolean flag = false;
		int cnt=0;
		while(true) {
			if(mySeat[key]==M) {
				cnt++;
				break;
			}
			if(visit[mySeat[key]]) {
				flag = true;
				break;
			}else {
				key=mySeat[key];
				visit[key]=true;
				cnt++;
			}
		}
		if(flag)
			System.out.println(-1);
		else
			System.out.println(cnt);
	}

	private static String src = "5 3\r\n" + 
			"1\r\n" + 
			"3\r\n" + 
			"2\r\n" + 
			"1\r\n" + 
			"4";
}