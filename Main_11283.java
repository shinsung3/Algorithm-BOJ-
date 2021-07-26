import java.util.Scanner;

public class Main_11283 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
//		가는 UTF-8 도표상 EA B0 80 으로 표현된다.
//		자바의 String클래스에서는 codePointAt이라는 메서드를 제공하는데,
//		이 메서드는 문자열을 내부적으로 UTF-16방식으로 인코딩한 후
//		이를 char → int 로 변환한 10진수 정수형 값을 반환해준다.
//		System.out.println("가".codePointAt(0)); // 출력: 44032
		
		System.out.println(str.codePointAt(0)-44031);
	}
}
