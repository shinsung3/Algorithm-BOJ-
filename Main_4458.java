import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int N = sc.nextInt();
		sc.nextLine();
		for(int i=0; i<N; i++) {
			String line = sc.nextLine();
			if(line.charAt(0)>=97) {
				char a = (char)(line.charAt(0)-32);
				System.out.print(a);
				for(int j=1; j<line.length(); j++) {
					System.out.print(line.charAt(j));
				}
				System.out.println();
			}else {
				System.out.println(line);
			}
		}
	}

	private static String src = "5\r\n" + 
			"powdered Toast Man\r\n" + 
			"skeletor\r\n" + 
			"Electra Woman and Dyna Girl\r\n" + 
			"she-Ra Princess of Power\r\n" + 
			"darth Vader";
}