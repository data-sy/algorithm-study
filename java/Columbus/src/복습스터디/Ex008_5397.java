package 복습스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class Ex008_5397 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i=0; i<T; i++){
			String str = br.readLine();
			LinkedList<Character> lStack = new LinkedList<>();
			Stack<Character> rStack = new Stack<>();
			for (int j=0; j<str.length(); j++){
				char ch = str.charAt(j);
				switch (ch) {
					case '<':
						if (!lStack.isEmpty()) rStack.push(lStack.pop());
						break;
					case '>':
						if (!rStack.isEmpty()) lStack.push(rStack.pop());
						break;
					case '-':
						if (!lStack.isEmpty()) lStack.pop();
						break;
					default:
						lStack.push(ch);
						break;
				}
			}
			while(!lStack.isEmpty()){
				sb.append(lStack.pollLast());
			}
			while(!rStack.isEmpty()){
				sb.append(rStack.pop());
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
