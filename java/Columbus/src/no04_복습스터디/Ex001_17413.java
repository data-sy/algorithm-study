package no04_복습스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex001_17413 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine() + 'A';
		StringBuilder sb = new StringBuilder();

		Stack<Character> stack = new Stack<>();
		for (int i=0; i<str.length(); i++){
			char ch = str.charAt(i);
			if (ch=='<') {
				while(ch!='>'){
					sb.append(ch);
					ch = str.charAt(++i);
				}
				sb.append(ch); // >
			} else {
				while( ch!=' ' && ch!='<' && ch!='A') {
					stack.push(ch);
					ch = str.charAt(++i);
				}
				while(!stack.isEmpty()) sb.append(stack.pop());
				if (ch==' ') sb.append(ch);
				else if (ch=='<') i--;
			}
		}
		System.out.println(sb);
	}
}
