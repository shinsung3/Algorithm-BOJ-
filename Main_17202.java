import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		String A = sc.nextLine();
		String B = sc.nextLine();
		
		int[] arr = new int[A.length()+ B.length()];
		
		int eight=0;
		List<Integer> q = new LinkedList<Integer>();
		while(true) {
			q.add(A.charAt(eight)-'0');
			q.add(B.charAt(eight)-'0');
			
			eight++;
			
			if(eight==8)
				break;
		}
		
		List<Integer> before = new ArrayList<Integer>();
		int idx=0;
		while(true) {
			int a = q.remove(idx);
			if(q.isEmpty()) {
				if(before.size()==2)
					break;
				else {
					while(!before.isEmpty()) {
						q.add(before.remove(idx));
					}
				}
				continue;
			}
			int b = q.get(idx);
			
			int sum = a+b;
			int ans = sum%10;
			
			before.add(ans);
		}
		
		System.out.print(before.remove(idx));
		System.out.print(before.remove(idx));
	}
		

	private static String src = "71193527\r\n" + 
			"31513383";
}