package no01;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Ex007_17413_선수문제 {

	public static void main(String[] args) throws IOException  {
		// https://www.acmicpc.net/problem/9093
		
		// 단어 뒤집기 => 스택 사용 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		Stack<Character> stack = new Stack<>();
		for (int i=0; i<N; i++) {
			String str = br.readLine() + '\n';
			for(int j=0; j<str.length(); j++) {
				char c = str.charAt(j);
				if (c!=' ' && c!='\n') stack.push(str.charAt(j));
				else {
					while(!stack.isEmpty()) bw.write(stack.pop());
					bw.write(' ');
				}
			}		
			bw.write('\n');
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
