package com.algorithm.java;

import java.util.Scanner;

public class Main_15727 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int answer = N/5;
		if(N%5!=0) {
			answer++;
		}
		System.out.println(answer);
	}
}
