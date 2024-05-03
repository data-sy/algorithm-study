package no02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Ex024_1406 {

	public static void main(String[] args) throws IOException{
		// https://www.acmicpc.net/problem/1406
		
		// 1. ListIterator 사용 
			// 출처 : https://minhamina.tistory.com/17
		// 2. LinkedList 사용 : 시간 초과
		// 3. 직접 구현 
				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();

		LinkedList<Character> list = new LinkedList<>();
		for (int i=0; i<str.length(); i++) {
			list.add(str.charAt(i));
		}
		
		int M = Integer.parseInt(br.readLine());
		String cmd;
		char input = 0;
		
		// 
		ListIterator<Character> iter = list.listIterator();
		
		// 커서를 맨 뒤로 이동
		while(iter.hasNext()) {
			iter.next();
		}

		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			cmd = st.nextToken();
			if (st.hasMoreTokens()) input = st.nextToken().charAt(0); // 받은 String을 char로 형변환 
			switch(cmd) {
				case "L":
					if (iter.hasPrevious()) iter.previous();
					break;
				case "D":
					if (iter.hasNext()) iter.next();
					break;
				case "B":
					if (iter.hasPrevious()) {
						iter.previous();
						iter.remove();
					}
					break;
				case "P":
					iter.add(input);
					break;
			}
		}
		for (Character ch : list) {
			sb.append(ch);
		}
		System.out.println(sb);
	}

}




