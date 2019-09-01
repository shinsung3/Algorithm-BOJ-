import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//sc = new Scanner(src);
		int day = sc.nextInt();
		int korean = sc.nextInt();
		int math = sc.nextInt();
		int korDay = sc.nextInt();
		int mathDay = sc.nextInt();
		
		if(korean%korDay==0) {
			korean = korean/korDay;
		}else {
			korean = korean/korDay +1;
		}
		
		if(math%mathDay==0) {
			math = math/mathDay;
		}else {
			math = math/mathDay +1;
		}
		
		if(math>korean) {
			System.out.println(day-math);
		}else {
			System.out.println(day-korean);
		}
	}

	private static String src = "20\r\n" + 
			"25\r\n" + 
			"30\r\n" + 
			"6\r\n" + 
			"8";
}
