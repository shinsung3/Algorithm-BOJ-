import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt();
		
		int arr[] = new int[101];
		int cnt=0;
		
		for(int i=0; i<N; i++) {
			int temp = sc.nextInt();
			
			if(arr[temp]!=0) {
				cnt++;
			}else {
				arr[temp]=1;
			}
		}
		System.out.println(cnt);
	}

	private static String src = "3\r\n" + 
			"1 2 3";
}