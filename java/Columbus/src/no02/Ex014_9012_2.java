package no02;


import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex014_9012_2 {

	public static void main(String[] args) throws IOException{
		// https://www.acmicpc.net/problem/9012

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		String[] arr = new String[T];
		for (int i=0; i<T; i++) {
			arr[i] = br.readLine();
		}
		
		for (String str : arr) {
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
			System.out.println(result);
		}

	}

}
