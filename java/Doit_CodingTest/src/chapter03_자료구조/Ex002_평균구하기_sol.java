package chapter03_자료구조;

import java.util.Scanner;

public class Ex002_평균구하기_sol {

	public static void main(String[] args) {
		
		// 답안에서는 그냥 스캐너 사용
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		// 답안에서는 배열에 저장
		int[] A = new int[N];
		for (int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		
		long sum = 0;
		long max = 0;
		
		for (int i=0; i<N; i++) {
			if (A[i] > max) max = A[i];
			sum += A[i];
		}
		
		// 곱할 때 100.0을 (나누기 전에 먼저 곱해야 함) 사용하면 long으로 해결 가
		System.out.println(sum*100.0/max/N);
		
	}

}
