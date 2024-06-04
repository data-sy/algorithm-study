package no04_복습스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class Ex014_2504 {
	
	public static void main(String[] args) throws IOException  {

		//	if (!stack.isEmpty() || stack.pop()=='('){
		// 논리합으로는 앞쪽이 T이면 뒤쪽 실행하지 않고 if문 안으로 들어와.
		// if (!stack.isEmpty() && stack.pop()=='('){
		// 논리곱으로는 앞쪽이 F이면 뒤쪽 실행하지 않고 if문 빠져 나갸.

		// 지금 식 대로면 (( 연속해서 있는 것 처리 못해.
		// 만약 )가 들어왔을 때 (로 mul 줄이는 건 맞는데, 만약 그 전에도

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int sum = 0;
		int mul = 1;
		boolean isVPS = true;
		Stack<Character> stack = new Stack<>();

		for (int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			switch (ch) {
				case '(':
					mul*=2;
					stack.push(ch);
					break;
				case '[':
					mul*=3;
					stack.push(ch);
					break;
				case ')':
					if (!stack.isEmpty() && stack.pop()=='('){
						sum+=mul;
						mul/=2;
						System.out.println("3번 :" +mul);
					} else {
						System.out.println("3번에 들어오나?");
						isVPS = false;
					}
					break;
				case ']':
					if (!stack.isEmpty() && stack.pop()=='['){
						sum+=mul;
						mul/=3;
						System.out.println("4번 :" +mul);
					} else {
						System.out.println("4번에 들어오나?");
						isVPS = false;
					}
					break;
			}
			if (!isVPS) break;
		}
		// 만약 스택이 비어있지 않으면 0 출력
		// VPS가 아니어도 0출력
		System.out.println("VPS:" +isVPS);
		System.out.println(str.isEmpty());
		Iterator<Character> iterator = stack.iterator();
		while(iterator.hasNext()) System.out.print(iterator.next());
		if (stack.isEmpty() && isVPS) System.out.println(sum);
		else System.out.println(0);

	}

}
