import java.util.Arrays;
import java.util.Scanner;

public class Main_3003 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int[] info = new int[6];
		info[0] = info[1] = 1;
		info[2] = info[3] = info[4] = 2;
		info[5] = 8;
//		System.out.println(Arrays.toString(info));
		int[] arr = new int[6];
		for (int i = 0; i < 6; i++) {
			arr[i] = sc.nextInt();
		}

//		System.out.println(Arrays.toString(arr));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			sb.append(info[i] - arr[i]).append(" ");
		}
		System.out.println(sb.toString());
	}

	private static String src = "0 1 2 2 2 7";
}