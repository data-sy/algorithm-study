package no02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex015_3986 {

	public static void main(String[] args) throws IOException {
		// https://www.acmicpc.net/problem/3986

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;

		// () 괄호 문제 + 두 문자 사이에 선후관계는 없도록 (즉, 괄호문제에 비유하면 )가 먼저 나올 수도 있어. 쌍이 중요한 거지 문자 사이에 순서는 없어)
		// 다르면 push
		// 같으면 pop
		// 비어있으면 push
		
		for (int i=0; i<N; i++) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			
//			stack.push(str.charAt(0));

			for (int j=1; j<str.length(); j++) {
				char ch = str.charAt(j);
				//AABB
				if (stack.isEmpty()) {
					stack.push(ch);
				}
				else {
					if (ch==stack.peek()) {
						stack.pop();
					}
					else {
						stack.push(ch);
					}
				}
//				// ABA 다음에 A가 나오는 건 괜찮은데, B가 나오는 순간 x
//				if (stack.size()>3) {
//					break;
//				}
				// 반례 : BAAABBBAAABBB BABAB
				// 결국 미리 알 수 없고 끝까지 돌려봐야 해 (그래서 모든 단어 길이의 합이 1,000,000을 넘지 않는다는 조건 줬구나 => 중간에 break 안 되니까)
			}
			if (stack.isEmpty()) cnt++;
			
		}
		System.out.println(cnt);

	}

}
