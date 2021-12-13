package Bronze4;

import java.util.Scanner;

public class Main_3004 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int x = 1;
		int y = 1;
		for (int i = 0; i < N; i++) {
			if(i%2==0) {
				x++;
			}else {
				y++;
			}
		}
		System.out.println(x*y);
	}
}
