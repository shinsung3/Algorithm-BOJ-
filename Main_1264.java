import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		
		HashSet<Character> set = new HashSet<>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		set.add('A');
		set.add('E');
		set.add('I');
		set.add('O');
		set.add('U');
		while(true) {
			String line = sc.nextLine();
			if(line.equals("#")) {
				break;
			}
			int cnt=0;
			for(int i=0; i<line.length(); i++) {
				if(set.contains(line.charAt(i))) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}

	private static String src = "How are you today?\r\n" + 
			"Quite well, thank you, how about yourself?\r\n" + 
			"I live at number twenty four.\r\n" + 
			"#";
}