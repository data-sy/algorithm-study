package no02;


import java.util.Stack;
import java.math.BigInteger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex014_9012 {

	public static void main(String[] args) throws IOException{
		// https://www.acmicpc.net/problem/9012
		// 1 : 입력과 출력 한 for문 안에 + 매번 syso
		// 2 : 입출력을 나눔
		// 3 : 스트링빌더 
		// 결론 : 별 차이 없었음.
		// (str변화가 많은 예제에서 다시 해보자.)
		// 4 : 스택 대신 숫자 놀음
		// 결론 : 사~알짝 더 빠르긴 한데 큰 차이는 아님
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i=0; i<T; i++) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			
			String result = "YES";
			for (int j=0; j<str.length(); j++){
				if (str.charAt(j)=='(') stack.push(str.charAt(j));
				else {
					if (stack.isEmpty()) {
						result = "NO";
						break;
					}
					else stack.pop();
				}
			}
			
			// (가 남는 경우  예) (())((), ((((
			if (!stack.isEmpty()) result = "NO";
			System.out.println(result);
		}

	}

}
