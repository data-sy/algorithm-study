package no02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex016_10799 {

	public static void main(String[] args) throws IOException{
		//https://www.acmicpc.net/problem/10769
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		// (( push
		// () + size
		// )) pop & + 1
		// )( 아무것도 안 함
		// 분석한 것은 굿노트 필기에
		
		Stack<Boolean> stack = new Stack<>();
		int sum = 0;
		
		for (int i=1; i<str.length(); i++) {
			if (str.charAt(i-1)=='(') {
				if (str.charAt(i)=='(') stack.push(true); // ((
				else sum+=stack.size(); // ()
			} else if (str.charAt(i)==')') { // ))
				stack.pop();
				sum++;
			}
		}
		System.out.println(sum);
		
	}

}
