import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		
		int E = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();
		
		int years[] = new int[3];
		for(int i=0; i<3; i++) {
			years[i] = 1;
		}
		int cnt=1;
		while(true) {
			if(E==years[0] && S==years[1] && M== years[2]) {
				System.out.println(cnt);
				break;
			}
			years[0]++;
			years[1]++;
			years[2]++;
			cnt++;
			if(years[0]==16)
				years[0]=1;
			if(years[1]==29)
				years[1]=1;
			if(years[2]==20)
				years[2]=1;
			
			
		}
	}

	private static String src = "1 16 16";
}