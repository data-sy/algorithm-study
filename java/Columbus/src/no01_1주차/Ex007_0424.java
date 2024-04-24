package no01_1주차;

import java.util.Scanner;
import java.util.Stack;

public class Ex007_0424 {

	public static void main(String[] args)  {
		// https://www.acmicpc.net/problem/17413

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String str = sc.nextLine()+'.';
		Stack<Character> stack = new Stack<>();
		
		// 1차 시도 : '.' 붙이지 않고 진행
		// 문자로 끝나는 케이스에 java.lang.StringIndexOutOfBoundsExceptio 에러
			// 맨 마지막 단어에 대해서도 ++i의 charAt을 찾게 되어서
			// 마침표로 인덱스를 하나 더 추가하면 에러가 안 나!
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if (c =='<') {
				while(c!='>') {
					sb.append(c);
					c = str.charAt(++i);
					}
				sb.append(c);
			} else {
				while(c!=' ' && c!='<' && c!='.') {
					stack.push(c);
					c = str.charAt(++i); // '.' 조건 없을 때 여기서 에러 
				}
				while(!stack.isEmpty()) sb.append(stack.pop());
				if (c==' ')	sb.append(c);
				else if (c=='<') i--;
			}
		}	
		// 조건에서 안 쓰이는 대문자 A를 마지막에 넣어서 에러 처
		
		System.out.println(sb);
	}

}
