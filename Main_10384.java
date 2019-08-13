import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int T = sc.nextInt();
		sc.nextLine();
		for(int ts=1; ts<=T; ts++) {
			int count[] = new int[26];
			String line = sc.nextLine();
			for(int i=0; i<line.length(); i++) {
				if(line.charAt(i)>='A' && line.charAt(i)<='Z') {
					count[line.charAt(i)-'A']++;
				}
				if(line.charAt(i)>='a' && line.charAt(i)<='z') {
					count[line.charAt(i)-'a']++;
				}
			}
			System.out.print("Case "+ts+": ");
			int one = 0;
			int two = 0;
			int three = 0;
			int zero = 0;
			for(int i=0; i<26; i++) {
				if(count[i]>=1) {
					one++;
				}
				if(count[i]>=2) {
					two++;
				}
				if(count[i]>=3) {
					three++;
				}
				if(count[i]<1) {
					zero++;
				}
			}
			if(zero!=0) {
				System.out.println("Not a pangram");
			}else if(three==26) {
				System.out.println("Triple pangram!!!");
			}else if(two==26) {
				System.out.println("Double pangram!!");
			}else if(one==26) {
				System.out.println("Pangram!");
			}
//			System.out.println(one+" "+two+" "+three+" "+zero);
		}
	}

	private static String src = "3\r\n" + 
			"The quick brown fox jumps over a lazy dog.\r\n" + 
			"The quick brown fox jumps over a laconic dog.\r\n" + 
			"abcdefghijklmNOPQRSTUVWXYZ-zyxwvutsrqpon   2013/2014      MLKJIHGFEDCBA";
}