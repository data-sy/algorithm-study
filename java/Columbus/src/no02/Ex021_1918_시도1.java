package no02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex021_1918_시도1 {

	public static void main(String[] args) throws IOException{
		//https://www.acmicpc.net/problem/1918

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		Stack<String> stack = new Stack<>();
		
		// 한 수식 단위로 
		// 역으로 담으면서 */ 처리 (역으로 담아야, 다시 뺄 때 +-가 왼쪽에서 오른쪽으로 진행 돼)
		// 아냐! 역으로 담으면 여러번 *일 때 순서가 바뀌어
		// 반례) A*B*C 를 이 방법으로 담으면 ABC** 가 나와
		// 하지만 올바른 출력은 AB*C* 야.
		for (int i=str.length()-1; i>=0; i--) {
			char ch = str.charAt(i);
			if ( ch==42 || ch==47 ) { // *, / 이면 연산해서 push
				sb2 = new StringBuilder();
				sb2.append(str.charAt(--i)).append(stack.pop()).append(String.valueOf(ch));
				stack.push(sb2.toString());
				// String을 + 로 연결했었음 
//				char ch1 = str.charAt(++i);
//				String ch2 = stack.pop();
//				String tmp = ch1 + ch + ch2 ; // 만약 모두 char이면 + "" 을 붙여서 해결 가능  
//				stack.push(tmp);
			} else stack.push(String.valueOf(ch));
		}
		System.out.println("최종 : " + stack.toString());
		// 스택에서 꺼내며 +- 처리
		// 이 때, 무조건 [문자 +- 문자 +- 문자] 이런 순서로 담겨 있게 될 거야 
		sb.append(stack.pop());
		int stackSize = stack.size(); // 스택 pop 하면서 사이즈 바뀌니까 변수로 미리 빼줘야 해 
		for (int i=0; i<stackSize; i+=2) {
			String popStr1 = stack.pop();
			String popStr2 = stack.pop();
			sb.append(popStr2).append(popStr1);
		}
		
		System.out.println(sb);
	}

//	static 
	
}
