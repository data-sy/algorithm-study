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
		
		// 쭉 스택에 쌓다가 ) 가 나오면 스택에서 (가 나올 때 까지 pop 해서 
		// 모은 것을 postfix
		LinkedList<String> stack = new LinkedList<>();
		for (int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if (ch==')') {
				LinkedList<String> list = new LinkedList<>();
				String check = stack.pollLast();					
				while (!check.equals("(")) {
					list.addFirst(check);
					check = stack.pollLast();
				}
				stack.add(postfix(list));
			} else stack.add(String.valueOf(ch));
		}
		// 이제 괄호 부분은 다 후위로 바꾼 상태니까 여기에 postfix
		System.out.println(postfix(stack));
		
	}
	
	// 괄호 없는 버전의 중위 -> 후위
	static String postfix(LinkedList<String> list) {
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		Deque<String> deque = new LinkedList();

		// */ 연산 큐로 돌리면서 처리
		while(!list.isEmpty()) {
			String str = list.poll();
			if ( str.equals("*") || str.equals("/") ) {
				sb2.setLength(0);
				sb2.append(deque.pollLast()).append(list.poll()).append(str);
				deque.add(sb2.toString());
			} else deque.add(str);
		}
		// +- 연산 큐로 돌리면서 처리
		while(!deque.isEmpty()) {
			String deStr = deque.poll();
			if ( deStr.equals("+") || deStr.equals("-") ) { 
				sb.append(deque.poll()).append(deStr);
			} else sb.append(deStr);			
		}
		return sb.toString();
	}
}
