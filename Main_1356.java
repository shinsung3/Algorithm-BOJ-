import java.util.Scanner;

public class Main {
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		String line = sc.nextLine();
		
		int first = 1;
		int second = 1;
		boolean flag = false;
		for(int i=0; i<line.length()-1;i++) {
			first *= line.charAt(i)-'0';
			second=1;
			for(int j=i+1; j<line.length(); j++) {
				second *=line.charAt(j)-'0';
			}
			if(first==second) {
				flag = true;
				break;
			}
		}
		if(!flag)
			System.out.println("NO");
		else
			System.out.println("YES");
	}
	private static String src = "1236";
}