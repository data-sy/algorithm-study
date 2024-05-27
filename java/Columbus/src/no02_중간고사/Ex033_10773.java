package no02_중간고사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex033_10773 {

	public static void main(String[] args) throws IOException {
		// https://www.acmicpc.net/problem/10773
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		StringBuilder  sb = new StringBuilder();
		
		for (int i=0; i<K; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num!=0) {
				stack.push(num);
			}
			else {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			}
		}
		int sum = 0;
		while(!stack.isEmpty()) {
			sum+=stack.pop();			
		}
		System.out.println(sum);
	}

}
