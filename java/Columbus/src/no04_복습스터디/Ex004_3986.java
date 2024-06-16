package no04_복습스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex004_3986 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int cnt = 0;
		for(int i=0; i<N; i++){
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			for (int j=0; j<str.length(); j++){
				char ch = str.charAt(j);
				if (stack.isEmpty()) stack.push(ch);
				else {
					if (ch == stack.peek()) stack.pop();
					else stack.push(ch);
				}
			}
			if (stack.isEmpty()) cnt++;
		}
		System.out.println(cnt);
	}
}
