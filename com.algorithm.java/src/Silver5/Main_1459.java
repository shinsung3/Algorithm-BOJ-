package Silver5;

import java.util.Scanner;

public class Main_1459 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		long x = sc.nextLong();
		long y = sc.nextLong();
		long w = sc.nextLong(); // ���� �̵�
		long s = sc.nextLong(); // �밢�� �̵�
		long ans = 0;

		// ���� �̵�
		long move1 = (x + y) * w;

		// ¦��, Ȧ���� ���� �̵�
		long move2;
		if ((x + y) % 2 == 0) { // x + y�� ¦����
			move2 = Math.max(x, y) * s;
		} else { // x + y�� Ȧ����
			move2 = (Math.max(x, y) - 1) * s + w;
		}

		// �밢�� + ���� �̵�
		long move3 = (Math.min(x, y) * s) + (Math.abs(x - y) * w);
		ans = Math.min(Math.min(move2, move1), move3);
		System.out.println(ans);
	}

	static String src = "4 2 3 10";
}
