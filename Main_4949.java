package com.algorithm.java;

import java.util.Scanner;
import java.util.Stack;

public class Main_4949 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		while(true) {
			String str = sc.nextLine();
			if(str.equals(".")) {
				break;
			}
			String answer = "";
			Stack<String> stack = new Stack<String>();
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i)=='(') {
					stack.push("(");
				}else if(str.charAt(i)=='[') {
					stack.push("[");
				}else if(str.charAt(i)==')') {
					if(stack.isEmpty()) {
						answer = "no";
						break;
					}
					String top = stack.peek();
					if(top.equals("(")) {
						stack.pop();
					}else {
						answer = "no";
						break;
					}
				}else if(str.charAt(i)==']') {
					if(stack.isEmpty()) {
						answer = "no";
						break;
					}
					String top = stack.peek();
					if(top.equals("[")) {
						stack.pop();
					}else {
						answer = "no";
						break;
					}
				}
			}
			if(answer.equals("no")) {
				System.out.println(answer);
			}else {
				if(!stack.isEmpty()) {
					answer = "no";
				}else {
					answer = "yes";
				}
				System.out.println(answer);
			}
		}
	}
    private static String src = "So when I die (the [first] I will see in (heaven) is a score list).\r\n"
    		+ "[ first in ] ( first out ).\r\n"
    		+ "Half Moon tonight (At least it is better than no Moon at all].\r\n"
    		+ "A rope may form )( a trail in a maze.\r\n"
    		+ "Help( I[m being held prisoner in a fortune cookie factory)].\r\n"
    		+ "([ (([( [ ] ) ( ) (( ))] )) ]).\r\n"
    		+ " .\r\n"
    		+ ".";
}