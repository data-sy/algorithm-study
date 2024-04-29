package no01_1주차;

import java.util.Scanner;

public class Ex013_2004 {

	public static void main(String[] args) {
		// https://www.acmicpc.net/problem/1373
	
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		// N=dn, M=dm 에 대하여, NCM=nCm => XXXXXXX
		// 너무 당연한건디 왜 이렇게 생각했지???ㅋㅋㅋ
		// (dn)! ≠ d^n(n!)
//		// 최대공약수
//		int gcd = N;
//		int b = M;
//		while(b!=0) {
//			int r = gcd%b;
//			gcd = b;
//			b = r;
//		}
//		N /= gcd;
//		M /= gcd;
		
		// nCm = nCn-m
		if (N/2<M) M = N-M;
		
		// 조합 : 2의 배수, 5의 배수만 
		// 2차 시도 : !곱셈이라 숫자가 커서 int에 담기 부족.. %10 연산 할 거라 double 사용도 x
		// 결국 이 안에서 while로 갯수 세주는 걸로 알고리즘 바꾸어야 할 듯!
		int num = 1; // 분자 
		int denom = 1; // 분모 
		for (int i=1; i<=M; i++) {
			if (N%2==0 || N%5==0) num*=N;
			N--;
			if (i%2==0 || i%5==0) denom*=i;
		}
		System.out.println(num);
		System.out.println(denom);

//		// 1차 시도 : 아얘 계산을 해버리면 안 곱한 원소들이 있어서 안 맞아 
//		int combi = num/denom;
//		int cnt = 1;
//		while(combi%10==0) cnt++;
		// 따라서 분자, 분모 각각 끝자리 0 개수 찾아서 빼기 

		int cntNum = 0;
		int cntDenom = 0;
		while(num%10==0) {
			cntNum++;
			num%=10;
			if (denom%10==0) {
				cntDenom++;
				denom%=10;
			}
		}
		System.out.println(cntNum-cntDenom);
	}

}
