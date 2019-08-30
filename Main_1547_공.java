import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);

		int N = sc.nextInt();
		int arr[] = new int[4];
		arr[1] = 1;
		
		for(int i=0; i<N; i++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			
			int temp = arr[y];
			arr[y] = arr[x];
			arr[x] = temp;
		}
		
		for(int i=0; i<4; i++) {
			if(arr[i] == 1) {
				System.out.println(i);
				break;
			}
		}
	}

	private static String src = "4\r\n" + 
			"3 1\r\n" + 
			"2 3\r\n" + 
			"3 1\r\n" + 
			"3 2";
}