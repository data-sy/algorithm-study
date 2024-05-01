package no02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex020_1935 {

	public static void main(String[] args) throws IOException{
		//https://www.acmicpc.net/problem/1935
		
		// 기호 아스키코드 
		// 40 41 42 43 44 45 46 47
		// (  )  *  +  ,  -  .  /
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		double[] arr = new double[26];
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// 알파벳이면 push
		// 기호이면 pop 2개 & 그걸로 연산 후 다시 push
		Stack<Double> stack = new Stack<>();
		
		for (int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if (65<=ch && ch<=90) stack.push(arr[ch-65]);
			else {
				double num2 = stack.pop();
				double num1 = stack.pop();
				if (ch==43) stack.push(num1+num2); // +
				else if (ch==45) stack.push(num1-num2); // -
				else if (ch==42) stack.push(num1*num2); // *
				else stack.push(num1/num2) ; // /
			}
		}
		// Double -> int로 직접 캐스팅 불가
			// Double : 객체, int : 원시 데이터 타입
			// intValue 메서드 사용
		// Double -> double은 가능
			// Java는 객체와 해당 기본 타입 간의 자동 변환을 지원
		// 계산 방식으로 접근하면 3은 3.00 이 아니라 3.0이 나와버림 
//		double numDouble = stack.pop()*100;
//		int numInt = (int) numDouble;
//		System.out.println(numInt/100.0);
		// 결론 : 포매팅 (printf, String.format() 등 가능) (리턴값이 필요하면 String.format() 사용 
		System.out.printf("%.2f", stack.pop());

	}
	
	// 소수점 자리수 출력 참고 자료 : https://bullie.tistory.com/7 

}
