import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_1120 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		
		String line = sc.nextLine();
		StringTokenizer st = new StringTokenizer(line, " ");
		String A = st.nextToken();
		String B = st.nextToken();
		
		int idx=0;
		int ans=Integer.MAX_VALUE;
		int len = B.length() - A.length();
		while(true) {
			int cnt=0;
			for(int j=0; j<A.length(); j++) {
				if(A.charAt(j)!=B.charAt(j+idx)) {
//					System.out.println(j);
					cnt++;
				}
			}
			idx++;
			
			if(ans>cnt) {
				ans = cnt;
			}
			if(idx>len)
				break;
		}
		System.out.println(ans);
	}
	private static String src = "adaabc aababbc";
}