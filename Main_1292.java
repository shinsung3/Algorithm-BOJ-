import java.util.Scanner;

public class Main_1292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int arr[] = new int[500600];
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int idx=0;
		int sum=0;
		out : for(int i=1; i<=1000; i++) {
			for(int j=0; j<i; j++) {
				idx++;
				arr[idx]=i;
				if(idx>=A && idx<=B) {
					sum+=arr[idx];
				}
				if(idx==B) {
					break out;
				}
			}
		}
		System.out.println(sum);
	}
	private static String src = "3 7";
}
