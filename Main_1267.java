import java.io.IOException;
import java.util.Scanner;

public class Main_1267 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt();
		int price[] = new int[N];
		for(int i=0; i<N; i++) {
			price[i]=sc.nextInt();
		}
		
		int young = 0;
		int min = 0;

		for(int i=0; i<N; i++) {
			young+=(price[i]/30+1)*10;
			min+=(price[i]/60+1)*15;
		}
		
		if(young>min) {
			System.out.print("M "+min);
		}else if(young<min){
			System.out.println("Y "+young);
		}else {
			System.out.println("Y M "+min);
		}
	}
	
	private static String src = "3\r\n" + 
			"40 40 40";
}