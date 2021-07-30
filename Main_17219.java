//package com.algorithm.java;

import java.util.HashMap;
import java.util.Scanner;

public class Main_17219 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();
		
		HashMap<String, String> map = new HashMap<>();
		for(int i=0; i<N; i++){
			String str[] = sc.nextLine().split(" ");
			map.put(str[0], str[1]);
		}
		
		for(int i=0; i<M; i++) {
			String answer = map.get(sc.nextLine());
			System.out.println(answer);
		}
	}

	private static String src = "16 4\r\n" + "noj.am IU\r\n" + "acmicpc.net UAENA\r\n" + "startlink.io THEKINGOD\r\n"
			+ "google.com ZEZE\r\n" + "nate.com VOICEMAIL\r\n" + "naver.com REDQUEEN\r\n" + "daum.net MODERNTIMES\r\n"
			+ "utube.com BLACKOUT\r\n" + "zum.com LASTFANTASY\r\n" + "dreamwiz.com RAINDROP\r\n"
			+ "hanyang.ac.kr SOMEDAY\r\n" + "dhlottery.co.kr BOO\r\n" + "duksoo.hs.kr HAVANA\r\n"
			+ "hanyang-u.ms.kr OBLIVIATE\r\n" + "yd.es.kr LOVEATTACK\r\n" + "mcc.hanyang.ac.kr ADREAMER\r\n"
			+ "startlink.io\r\n" + "acmicpc.net\r\n" + "noj.am\r\n" + "mcc.hanyang.ac.kr";
}
