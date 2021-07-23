import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class Main_1620 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		HashMap<String, String> hm = new HashMap<String, String>();
		HashMap<String, String> hmKey = new HashMap<String, String>();
		for(int i=0; i<=N; i++) {
			String line = sc.nextLine();
			hm.put(Integer.toString(i), line); //sc.nextLine()À¸·Î 1ÁÙÀº 0¿¡ ¸ÅÄªµÊ.
			hmKey.put(line, Integer.toString(i));
		}
		
		for(int i=0; i<M; i++) {
			String line = sc.nextLine();
			if(hm.containsKey(line)) {
				System.out.println(hm.get(line));
			}else {
				if(hmKey.containsKey(line)) {
					System.out.println(hmKey.get(line));
				}
			}
		}
	}

	private static String src = "26 5\r\n"
			+ "Bulbasaur\r\n"
			+ "Ivysaur\r\n"
			+ "Venusaur\r\n"
			+ "Charmander\r\n"
			+ "Charmeleon\r\n"
			+ "Charizard\r\n"
			+ "Squirtle\r\n"
			+ "Wartortle\r\n"
			+ "Blastoise\r\n"
			+ "Caterpie\r\n"
			+ "Metapod\r\n"
			+ "Butterfree\r\n"
			+ "Weedle\r\n"
			+ "Kakuna\r\n"
			+ "Beedrill\r\n"
			+ "Pidgey\r\n"
			+ "Pidgeotto\r\n"
			+ "Pidgeot\r\n"
			+ "Rattata\r\n"
			+ "Raticate\r\n"
			+ "Spearow\r\n"
			+ "Fearow\r\n"
			+ "Ekans\r\n"
			+ "Arbok\r\n"
			+ "Pikachu\r\n"
			+ "Raichu\r\n"
			+ "25\r\n"
			+ "Raichu\r\n"
			+ "3\r\n"
			+ "Pidgey\r\n"
			+ "Kakuna";
}
