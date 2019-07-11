import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt();
		int M = sc.nextInt();

		// 200000개를 미리 체크해줌
		List<Long> list = new ArrayList<>();
		long max = 0;
		for (int i = 0; i < N; i++) {
			long temp = sc.nextLong();

			list.add(temp);
		}

		HashSet<Long> set = new HashSet<>();
		for (int i = 0; i < M; i++) {
			long temp = sc.nextLong();
			set.add(temp);
		}

		int cnt=0;
		for (int i = 0; i < list.size(); i++) {
			if (set.contains(list.get(i))) {
				cnt++;
			}
		}
		
		int ans = (set.size()-cnt) + (list.size()-cnt);

		System.out.println(ans);

	}

	private static String src = "3 5\r\n" + "1 2 4\r\n" + "2 3 4 5 6";
}