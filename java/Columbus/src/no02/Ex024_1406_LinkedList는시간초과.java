package no02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Ex024_1406_LinkedList는시간초과 {

	public static void main(String[] args) throws IOException{
		// https://www.acmicpc.net/problem/1406
				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		// N으로 고정해서 나중에 N으로 인덱스 위치 비교하면 안돼!
		// 삭제하면서 사이즈 줄 수도 있으니 
//		int N = str.length();
		LinkedList<Character> list = new LinkedList<>();
		for (int i=0; i<str.length(); i++) {
			list.add(str.charAt(i));
		}
		// 인덱스로 커서 위치 표시 (선택된 인덱스의 뒤에 커서가 있다.)
		int cursor = str.length()-1;
		
		int M = Integer.parseInt(br.readLine());
		String cmd;
		char input = 0;

		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			cmd = st.nextToken();
			if (st.hasMoreTokens()) input = st.nextToken().charAt(0); // 받은 String을 char로 형변환 
			switch(cmd) {
				case "L":
					if (cursor>=0) cursor--;
					break;
				case "D":
					if (cursor<list.size()-1) cursor++;
					break;
				case "B":
					if (cursor>=0) {
						list.remove(cursor);
						cursor--;						
					}
					break;
				case "P":
					list.add(cursor+1, input);
					cursor++;
					break;
			}
		}
		for (Character ch : list) {
			sb.append(ch);
		}
		System.out.println(sb);
	}

}




