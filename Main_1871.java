import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt();
		sc.nextLine();
		for(int i=0; i<N; i++) {
			String line = sc.nextLine();
			StringTokenizer token = new StringTokenizer(line, "-");
			
			String first = token.nextToken();
			int sum = 0;
			int idx=0;
			for(int j=first.length()-1; j>=0; j--) {
				int a = (int)Math.pow(26,idx);
				int temp = (int)(first.charAt(j)-'A');
				int b = a*temp;
				sum+=b;
				idx++;
			}
			String second = token.nextToken();
			int ans=0;
			idx=0;
			for(int j=0; j<second.length();j++) {
				if(second.charAt(j)=='0') {
					continue;
				}else {
					idx=j;
					break;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			for(int j=idx; j<second.length(); j++) {
				sb.append(second.charAt(j));
			}
			ans = Integer.parseInt(sb.toString());
			
			if(Math.abs(sum-ans)<=100) {
				System.out.println("nice");
			}else {
				System.out.println("not nice");
			}
		}
	}

	private static String src = "2\r\n" + 
			"ABC-0123\r\n" + 
			"AAA-9999";
}