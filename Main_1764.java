import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main_1764 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt();
		int M = sc.nextInt();

		HashSet<String> set = new HashSet<String>();
		sc.nextLine();
		for (int i = 0; i < N; i++) {
			set.add(sc.nextLine());
		}
		int cnt = 0;
		List<String> list = new ArrayList<String>();
		for (int j = 0; j < M; j++) {
			String answer = sc.nextLine();
			if(set.contains(answer)) {
				cnt++;
				list.add(answer);
			}
		}
		System.out.println(cnt);
		Collections.sort(list);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	private static String src = "3 4\r\n" + "ohhenrie\r\n" + "charlie\r\n" + "baesangwook\r\n" + "obama\r\n"
			+ "baesangwook\r\n" + "ohhenrie\r\n" + "clinton";
}
