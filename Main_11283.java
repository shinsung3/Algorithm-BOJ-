import java.util.Scanner;

public class Main_11283 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
//		���� UTF-8 ��ǥ�� EA B0 80 ���� ǥ���ȴ�.
//		�ڹ��� StringŬ���������� codePointAt�̶�� �޼��带 �����ϴµ�,
//		�� �޼���� ���ڿ��� ���������� UTF-16������� ���ڵ��� ��
//		�̸� char �� int �� ��ȯ�� 10���� ������ ���� ��ȯ���ش�.
//		System.out.println("��".codePointAt(0)); // ���: 44032
		
		System.out.println(str.codePointAt(0)-44031);
	}
}
