import java.util.Scanner;

public class Main_17249 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		String line = sc.nextLine();

		int right = 0;
		int left = 0;
		boolean dir = false;
		for (int i = 0; i < line.length(); i++) {
			char a = line.charAt(i);
			if (a == '0') {
				dir = true;
			}
			if (!dir) {
				if (a == '@') {
					right++;
				}
			}else {
				if(a=='@') {
					left++;
				}
			}
		}
		
		System.out.println(right+" "+left);
	}

	private static String src = "@===@==@=@==(^0^)==@=@===@";

}
