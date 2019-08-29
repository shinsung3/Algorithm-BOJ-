import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);

		int T = sc.nextInt();
		for (int ts = 1; ts <= T; ts++) {
			int N = sc.nextInt();
			List<Node> list = new LinkedList<>();
			int K = sc.nextInt();
			String line = sc.next();

			int key = N / 4;
			int cnt = key - 1;
			for (int i = 0; i < line.length(); i++) {
				list.add(new Node(line.charAt(i), cnt));
				cnt--;
				if (cnt < 0)
					cnt = key - 1;
			}
//			System.out.println(list);

			HashSet<String> set = new HashSet<>();
			cnt = 0;
			for (int i = 0; i < key; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < list.size(); j++) {
					sb.append(list.get(j).value);
					cnt++;
					if (cnt == key) {
						set.add(sb.toString());
						sb = new StringBuilder();
						cnt = 0;
					}
				}
				Node n = list.remove(list.size() - 1);
				list.add(0, new Node(n.value, n.num));
			}
//			System.out.println(set);
			String[] str = new String[set.size()];
			set.toArray(str);
			Arrays.sort(str);
//			System.out.println(Arrays.toString(str));
			cnt = 0;
			for (int i = str.length - 1; i >= 0; i--) {
				cnt++;
				if (cnt == K) {
					int sum=0;
					for (int j = 0; j < str[i].length(); j++) {
						int value = 0;
						if(str[i].charAt(j)=='A')
							value = 10;
						else if(str[i].charAt(j)=='B')
							value = 11;
						else if(str[i].charAt(j)=='C')
							value = 12;
						else if(str[i].charAt(j)=='D')
							value = 13;
						else if(str[i].charAt(j)=='E')
							value = 14;
						else if(str[i].charAt(j)=='F')
							value = 15;
						else
							value = str[i].charAt(j)-'0';
						sum += value*(int)Math.pow(16, str[i].length()-j-1);
					}
					System.out.println("#" + ts + " " + sum);
				}
			}
		}
	}

	static class Node {
		char value;
		int num;

		public Node(char value, int num) {
			super();
			this.value = value;
			this.num = num;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + ", num=" + num + "]";
		}

	}

	private static String src = "1\r\n" + "12 10\r\n" + "1B3B3B81F75E\r\n" + "16 2\r\n" + "F53586D76286B2D8\r\n"
			+ "20 14\r\n" + "88F611AE414A751A767B\r\n" + "24 16\r\n" + "044D3EBA6A647B2567A91D0E\r\n" + "28 11\r\n"
			+ "8E0B7DD258D4122317E3ADBFEA99";
}