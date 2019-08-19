import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int arr[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt();

		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		char calculate[] = new char[N - 1];
		int idx = 0;
		for (int i = 0; i < 4; i++) {
			int a = sc.nextInt();
			if (i == 0) {
				for (int j = 0; j < a; j++) {
					calculate[idx] = '+';
					idx++;
				}
			}else if(i==1) {
				for (int j = 0; j < a; j++) {
					calculate[idx] = '-';
					idx++;
				}
			}else if(i==2) {
				for (int j = 0; j < a; j++) {
					calculate[idx] = '*';
					idx++;
				}
			}else if(i==3) {
				for (int j = 0; j < a; j++) {
					calculate[idx] = '/';
					idx++;
				}
			}
		}

		perm(calculate, new boolean[N-1], 0, 0);
		System.out.println(max);
		System.out.println(min);
	}
	
	static long min = 2000000000;
	static long max = -2000000000;
	static void perm(char[] calculate, boolean[] visit, int idx, int cnt) {
		if(idx==calculate.length) {
			long sum = arr[0];
			for(int i=0; i<calculate.length; i++) {
				if(calculate[i] =='+') {
					sum += arr[i+1];
				}else if(calculate[i] =='-') {
					sum-= arr[i+1];
				}else if(calculate[i] =='*') {
					sum *= arr[i+1];
				}else if(calculate[i] =='/') {
					sum /=arr[i+1];
				}
			}
			if(min>sum) {
				min = sum;
			}
			if(max<sum) {
				max = sum;
			}
			return;
		}
		
		for(int i=idx; i<calculate.length; i++) {
			swap(idx, i, calculate);
			perm(calculate, visit, idx+1, cnt);
			swap(idx, i, calculate);
		}
	}
	
	static void swap(int i, int j, char[] calculate) {
		char temp = calculate[i];
		calculate[i] = calculate[j];
		calculate[j] = temp;
	}

	private static String src = "6\r\n" + "1 2 3 4 5 6\r\n" + "2 1 1 1";
}