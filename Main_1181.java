import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_1181 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);

		int N = sc.nextInt();
		sc.nextLine();
		List<String> line = new ArrayList<>();
		int size[][] = new int[N][2];
		for (int i = 0; i < N; i++) {
			boolean flag = false;
			String a = sc.nextLine();
			for (int j = 0; j < line.size(); j++) {
				if (a.equals(line.get(j))) {
					flag = true;
					break;
				}
			}
			//중복되지 않았을 때만 저장
			if (!flag) {
				line.add(a);

			}
		}

		//저장 된 문자열을 사전순으로 정렬
		Collections.sort(line);
		for (int i = 0; i < line.size(); i++) {
			size[i][0] = i;
			size[i][1] = line.get(i).length();
		}

		for (int i = 0; i < line.size() - 1; i++) {
			for (int j = i + 1; j < line.size(); j++) {
				//현재 사전순의 데이터 중에 글자 순으로 정렬
				if (size[i][1] > size[j][1]) {
					int temp = size[i][1];
					size[i][1] = size[j][1];
					size[j][1] = temp;

					temp = size[i][0];
					size[i][0] = size[j][0];
					size[j][0] = temp;
				}else if(size[i][1]==size[j][1]) {
					
					//글자순으로 정렬된 데이터 중에 같은 크기가 있다면 다시 한번 사전순으로 정렬
					if(size[i][0]>size[j][0]) {
						int temp = size[i][1];
						size[i][1] = size[j][1];
						size[j][1] = temp;

						temp = size[i][0];
						size[i][0] = size[j][0];
						size[j][0] = temp;
					}
				}
			}
		}

//		for (int data[] : size) {
//			System.out.println(Arrays.toString(data));
//		}
		for (int i = 0; i < line.size(); i++) {
			System.out.println(line.get(size[i][0]));
		}
//		System.out.println(line);

	}

	private static String src = "13\r\n" + "but\r\n" + "i\r\n" + "wont\r\n" + "hesitate\r\n" + "no\r\n" + "more\r\n"
			+ "no\r\n" + "more\r\n" + "it\r\n" + "cannot\r\n" + "wait\r\n" + "im\r\n" + "yours";
}
