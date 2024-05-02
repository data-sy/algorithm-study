package no02;


import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex014_9012_3 {

	public static void main(String[] args) throws IOException{
		// https://www.acmicpc.net/problem/9012
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i<T; i++) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			
			String result = "YES";
			for (int j=0; j<str.length(); j++){
				if (str.charAt(j)=='(') {
					stack.push(str.charAt(j));
				}
				else {
					if (stack.isEmpty()) {
						result = "NO";
						break;
					}
					else stack.pop();
				}
			}
			
			// (가 남는 경우  예) (())(()
			if (!stack.isEmpty()) result = "NO";
			sb.append(result + "\n");
		}
		
		System.out.println(sb);
		
	}

}
