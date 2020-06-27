import java.util.Scanner;

public class Main_2884 {
    public static void main(String[] args) {
//    	Scanner sc = new Scanner(src);
		Scanner sc = new Scanner(System.in);
    	
    	int h = sc.nextInt();
    	int m = sc.nextInt();
    	
    	int minute = m-45;
    	if(minute>=0) {
    		System.out.println(h+" "+minute);
    	}else {
    		h -= 1;
    		m = 60 + minute;
    		if(h<0) {
    			h = 23;
    			System.out.println(h+" "+m);
    		}else {
    			System.out.println(h+" "+m);
    		}
    	}
	}
    private static String src = "10 10";
}
