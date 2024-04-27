package no01_1주차;

import java.util.Scanner;

public class Ex013_2004_2 {

	public static void main(String[] args) {
		// https://www.acmicpc.net/problem/1373
	
		Scanner sc = new Scanner(System.in);
		
		// int 범위 : -2,147,483,648 ~ 2,147,483,647
		// 문제 조건 N<=2,000,000,000 이므로 int에 넣는 것 OK 
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		// nCm = nCn-m
		if (N/2<M) M = N-M;
	
		// 조합 수식에서의 개수 
		// cnt1 : 1 ~ N
		// cnt2 : 1 ~ N-M
		// cnt3 : 1 ~ M
		// 분자에서의 개수 - 분모에서의 개수 = (cnt1 - cnt2) - cnt3
		
		// 2의 개수, 5의 개수 사이에 대소 관계는 없으므로 둘 다 구해주기 
		// 8C1 -> 2만 3개 , 25C1 -> 5만 2개 
		
		// 1차 시도 : (2000000000, 1)를 넣으면 / by zero 에러가 나
		// 아! 마지막에 div*=2가 int를 넘어가버려 => div를 long으로 
		int cnt2 = 0;
		for (long div=2; div<=N; div*=2) cnt2+= N/div;
		for (long div=2; div<=N-M; div*=2) cnt2-=(N-M)/div;
		System.out.println("분자 2 : " + cnt2);
		for (long div=2; div<=M; div*=2) cnt2-=M/div;
		int cnt5 = 0;
		for (long div=5; div<=N; div*=5) cnt5+=N/div;
		for (long div=5; div<=N-M; div*=5) cnt5-=(N-M)/div;
		System.out.println("분자 5 : " + cnt5);
		for (long div=5; div<=M; div*=5) cnt5-=M/div;
		
		System.out.println(cnt2);
		System.out.println(cnt5);
		System.out.println( cnt2<cnt5 ? cnt2 : cnt5);
		
	}
	
	// 리팩토링) 지수 구하는 방법이 반복되므로 함수로 처리 

}
