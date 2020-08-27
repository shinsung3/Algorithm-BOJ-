import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_1333 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int Nsong = sc.nextInt();
		int Lsecond = sc.nextInt();
		int Dbell = sc.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<Nsong; i++) {
			for(int j=0; j<Lsecond; j++) {
				list.add(1);
			}
			for(int j=0; j<5; j++) {
				list.add(0);
			}
		}
		int time = 0;
		while(true) {
			if(time>= list.size()) {
				break;
			}
			if(list.get(time)==0)
				break;
			else {
				time += Dbell;
			}
		}
		System.out.println(time);
	}

	private static String src = "2 5 7";
}