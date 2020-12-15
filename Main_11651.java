import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main_11651 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);

		int n = sc.nextInt();
		sc.nextLine();
		List<Sort> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String line[] = sc.nextLine().split(" ");
			list.add(new Sort(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
		}

		Collections.sort(list, new Comparator<Sort>() {

			@Override
			public int compare(Sort o1, Sort o2) {
				// TODO Auto-generated method stub
				if (o2.y < o1.y) {
					return 1;
				} else if (o2.y > o1.y) {
					return -1;
				} else {
					if (o2.x < o1.x) {
						return 1;
					} else if (o2.x > o1.x) {
						return -1;
					} else {
						return 0;
					}
				}
			}
		});

		StringBuilder sb = new StringBuilder();
		int idx = 0;
		for (Sort s : list) {
			sb.append(s.x).append(" ").append(s.y);
			idx++;
			if (idx != n)
				sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static class Sort {
		int x;
		int y;

		public Sort(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Sort [x=" + x + ", y=" + y + "]";
		}
	}

	private static String src = "5\r\n" + "2 -1\r\n" + "1 2\r\n" + "1 -1\r\n" + "2 2\r\n" + "3 3";
}