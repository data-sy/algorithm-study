package no03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Ex039_2164 {

	public static void main(String[] args) throws IOException {
		//https://www.acmicpc.net/problem/2164
		
		// 1. 짝수(2^m)는 카드를 절반으로 줄일 수 있음 (원리는 그림으로 남기자)
		// 2. deque 사용 (확실히 문제 푸는 속도 빨라져. 코드 구현만 하면 되니까)

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 	N = 2^m*l (l: 홀수)
		int mul = 1; // 2^m 자체
		int l = N;
		while(l%2==0) {
			mul*=2;
			l/=2;
		}
		
		Deque<Integer> deque = new LinkedList<>();		
		for (int i=1; i<=l; i++) {
			deque.offer(i);			
		}
		
		while(deque.size()>1) {
			deque.poll();
			deque.offer(deque.poll());			
		}
		System.out.println(mul*deque.poll());
	}
	
}
