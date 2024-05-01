package no02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Ex021_1918 {

	public static void main(String[] args) throws IOException{
		//https://www.acmicpc.net/problem/1918
		
		// 덱 사용 	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		// 우선 괄호 없이 +-*/ 연산은
			// */을 한 덩어리로 처리하면서 스택에 쌓고
			// +-를 큐로 추출 
		// 괄호가 있으면 그 괄호 안의 문자열을 postfix
		
		
		
	}
	
	// 괄호 없는 상태로 돌리는 건 만들었는데,,, 흠.. ㅋㅋ 

	static String postfix(String str) {
		StringBuilder sb = new StringBuilder();
		if (str.contains("(")) {
			
		}
		else {
			Deque<String> deque = new LinkedList<>();
			StringBuilder sb2 = new StringBuilder();
			// 스택으로 사용 : push, pop 
			for (int i=0; i<str.length(); i++) {
				char ch = str.charAt(i);
				if ( ch==42 || ch==47 ) { // *, / 이면 연산해서 push
					sb2 = new StringBuilder();
					sb2.append(deque.pop()).append(str.charAt(++i)).append(String.valueOf(ch));
					deque.push(sb2.toString());
				} else deque.push(String.valueOf(ch));
			}
			// 큐로 사용 : pollLast 
			while(!deque.isEmpty()) {
				String deStr = deque.pollLast();
				if ( deStr.equals("+") || deStr.equals("-") ) { 
					sb.append(deque.pollLast()).append(deStr);
				} else sb.append(deStr);			
			}		
			
		}
		return sb.toString();
	}
	
}
