package no02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex019_1874_시도들 {

	public static void main(String[] args) throws IOException{
		//https://www.acmicpc.net/problem/10769
		
		// 1차 시도 : 스택 peek() 이용
			// 스택이 비어있을 때 EmptyStackException 에러가 남 (조건문으로 비어있지 않을 때를 줘버리면 문제 상황에 어긋나)
		// 2차 시도 : num을 peek 삼아 +, - 시키고 이미 사용된 num은 불리언 배열 isUsed에 담아서 이동
			// 위, 아래 이동이 엄청 자주 날 거야. 이미 사용된 num 들을 올렸다 내렸다 하면서 다 점검해야 하니까 

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int[] arr = new int[n];
		for (int i=0;i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Stack<Integer> stack = new Stack<>();

		int i = 0; // 타겟 arr의 인덱스 
		int num = 1; // stack에 담을 1~n
		
		// 결국 최상단의 숫자를 
		
		
		
		

	}

}
