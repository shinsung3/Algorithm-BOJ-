//package com.algorithm.java;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2752 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		
		int[] arr = new int[3];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);
		for(int a : arr)
			System.out.print(a+" ");
	}

//	private static String src = "3 1 2";
}
