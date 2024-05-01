package no02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Ex021_1918_괄호없는버전 {

	public static void main(String[] args) throws IOException{
		//https://www.acmicpc.net/problem/1918
		
		// 덱 사용 	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		Deque<String> deque = new LinkedList<>();
		
		// */ 연산은 스택으로 넣고 				
		// 스택으로 사용 : push, pop 
		for (int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if ( ch==42 || ch==47 ) { // *, / 이면 연산해서 push
				sb2 = new StringBuilder();
				sb2.append(deque.pop()).append(str.charAt(++i)).append(String.valueOf(ch));
				deque.push(sb2.toString());
			} else deque.push(String.valueOf(ch));
		}
		
		// +- 연산은 큐로 빼자 
		// 큐로 사용 : pollLast 
		while(!deque.isEmpty()) {
			String deStr = deque.pollLast();
			if ( deStr.equals("+") || deStr.equals("-") ) { 
				sb.append(deque.pollLast()).append(deStr);
			} else sb.append(deStr);			
		}
		System.out.println("최종 : " + sb);
	}

//	static 위에서 만든 로직을 함수로 만들어서
	// (가 시작할 때부터 )로 끝날 때 까지 담아서 수행하려 했음 
	
}
