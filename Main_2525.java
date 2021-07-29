import java.util.Scanner;

public class Main_2525 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int hour = sc.nextInt();
		int min = sc.nextInt();
		int time = sc.nextInt();
		
		int total = min + time;
		
		if(total>=60) {
			hour += total/60;
			total = total%60;
		}
		if(hour>=24) {
			hour %= 24;
		}
		
		System.out.println(hour +" "+total);
	}

	private static String src = "23 48\r\n"
			+ "25";
}
