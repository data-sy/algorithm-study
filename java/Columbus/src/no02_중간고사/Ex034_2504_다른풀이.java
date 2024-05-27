package no02_중간고사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Ex034_2504_다른풀이 {

	public static void main(String[] args) throws IOException {
		// https://www.acmicpc.net/problem/2504

		// ans : 최종 답
		// val : 괄호 곰샘용
		// (가 들어오면 val에 2를 곱하고 push
		// [가 들어오면 val에 3을 곱하고 push
		// )가 들어오면
			// 비어있거나 peek가 (일 때 => 0 주고 break
			// str의 직전이 ( 였을 때 => answer에 val 더하기
			// 한 원소 빼면서 val/2
		// ArrayDeque 사용 : 나중에
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Deque<Character> dq = new ArrayDeque<>();
		int ans = 0;
		int val = 1;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				dq.push(s.charAt(i));
				val *= 2;
			} else if (s.charAt(i) == '[') {
				dq.push(s.charAt(i));
				val *= 3;
			} else if (s.charAt(i) == ')') {
				if (dq.isEmpty() || dq.peek() != '(') {
					ans = 0;
					break;
				} else if (s.charAt(i - 1) == '(') {
					ans += val;
				}
				dq.pop();
				val /= 2;
			} else if (s.charAt(i) == ']') {
				if (dq.isEmpty() || dq.peek() != '[') {
					ans = 0;
					break;
				} else if (s.charAt(i - 1) == '[') {
					ans += val;
				}
				dq.pop();
				val /= 3;
			}
		}

		StringBuilder sb = new StringBuilder();
		if (!dq.isEmpty()) {
			sb.append(0);
		} else {
			sb.append(ans);
		}

		System.out.println(sb);

	}

}
