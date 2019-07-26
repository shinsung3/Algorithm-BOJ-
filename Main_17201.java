import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt();
		sc.nextLine();
		String line = sc.nextLine();
		
		boolean flag = false;
		for(int i=1; i<line.length()-1; i+=2) {
			if(line.charAt(i)==line.charAt(i+1)) {
				flag = true;
				break;
			}
		}
		
		if(flag) {
			System.out.println("No");
		}else {
			System.out.println("Yes");
		}
	}

	private static String src = "3\r\n" + 
			"122112";
}