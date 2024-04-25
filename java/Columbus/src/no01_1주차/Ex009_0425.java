package no01_1주차;

import java.util.Scanner;

public class Ex009_0425 {

	public static void main(String[] args) {
		// https://www.acmicpc.net/problem/1929
	
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();

		// 윌슨 정리
		// p: 소수 => (p-1)!≡-1 (mod p)
		// 역도 T
		// 윌슨의 정리는 !이므로 O(N) * for문 O(N) = 시간복잡도 O(N^2) => 시간 초과  
//		for(int p=M; p<=N; p++) {
//			int i=2;
//			int fact=1;
//			while(i!=p) fact*=i++; // O(N)
//			if (fact%p==p-1) System.out.println(p);
//		}
		
		// 에라토스테네스의 체 + 제곱근으로 갯수 줄이기 O(N^1/2)
		// 배열 사용해서 소수성 t/f로 기록 
		// 참고 : https://velog.io/@jinvicky/백준-자바-1929번-소수-구하기
		// 양이 많으면 for에서 매번 syso 하는거 느려지기 때문에 sb에 담아서 한꺼번에 출력하자 
		StringBuilder sb = new StringBuilder();
		
		boolean[] arr = new boolean[N+1];
		for (int i=2; i<N+1; i++) arr[i] = true; // 0과 1은 false 이므로 2부터 넣어주기!! 
		
		for (int i=2; i*i<=N; i++) {
			if (arr[i]) {
				for (int j=i+i; j<=N; j+=i) arr[j]=false;
			}
		}
		for (int i=M; i<=N; i++) {
			if (arr[i]) sb.append(i).append('\n');
		}
		System.out.println(sb);
		
	}

}
