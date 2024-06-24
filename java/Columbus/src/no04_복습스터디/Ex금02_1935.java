package no04_복습스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex금02_1935 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();

		double[] arr = new double[26];
		for(int i=0; i<N; i++) {
			arr[i] = Double.parseDouble(br.readLine());
		}

		Stack<Double> stack = new Stack<>();
		for (int i=0; i<str.length(); i++){
			char ch = str.charAt(i);
			if (65<=ch && ch<=90) stack.push(arr[ch-65]);
			else {
				double num2 = stack.pop();
				double num1 = stack.pop();
				switch (ch) {
					case '+' :
						stack.push(num1+num2);
						break;
					case '-' :
						stack.push(num1-num2);
						break;
					case '*' :
						stack.push(num1*num2);
						break;
					case '/' :
						stack.push(num1/num2);
						break;
				}
			}
		}
		double result = stack.pop();

		System.out.printf("%.2f", result);

	}
}
