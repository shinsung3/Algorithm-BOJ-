import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		 sc = new Scanner(src);

//		int T = sc.nextInt();
		int T = Integer.parseInt(br.readLine());
		for (int ts = 1; ts <= T; ts++) {
			String line = br.readLine();

			List<Character> list = new LinkedList<Character>();
			int idx = 0;
			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) >= 'A' && line.charAt(i) <= 'Z' || line.charAt(i) >= 'a' && line.charAt(i) <= 'z'
						|| line.charAt(i) >= '0' && line.charAt(i) <= '9') {
					list.add(idx, line.charAt(i));
					idx++;
				} else {
					if (line.charAt(i) == '-') {
						if (idx == 0)
							continue;
						else {
							list.remove(idx - 1);
							idx--;
						}
					} else if (line.charAt(i) == '<') {
						if(idx==0)
							continue;
						else {
							idx--;
							continue;
						}
					} else if (line.charAt(i) == '>') {
						if (idx == list.size()) {
							continue;
						}else {
							idx++;
							continue;
						}
					}

				}
			}
			StringBuilder sb = new StringBuilder();
			for (char a : list)
				sb.append(a);
			System.out.println(sb.toString());
		}
	}

	private static String src = "2\r\n" + "<<BP<A>>Cd-\r\n" + "ThIsIsS3Cr3t";
}