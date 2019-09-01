import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt();

		List<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			list.add((i + 1));
		}

		while (true) {
			if(list.size()==1) {
				System.out.println(list.get(0));
				break;
			}
			removeCard(list);
			if(list.size()==1) {
				System.out.println(list.get(0));
				break;
			}
			backCard(list);
			
		}
	}

	static void removeCard(List<Integer> list) {
		list.remove(0);
	}

	static void backCard(List<Integer> list) {
		int a = list.remove(0);

		list.add(list.size(), a);
	}

	private static String src = "6";
}
