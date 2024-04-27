package no01_1주차;

import java.util.Scanner;

public class Ex012_1373 {

	public static void main(String[] args) {
		// https://www.acmicpc.net/problem/1373
	
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		
		// 3의 배수에서 비는 만큼 0을 채워줌 (인덱스 에러 방지)
		// 1차 시도 : 3의 배수 앞에는 000이 들어가 (나중에 0+0+0=0이 앞에 붙어)
		// 예) 100 -> 04로 나옴 
//		str = "0".repeat(3 - str.length()%3) + str;
		// 그래서 다시 한 번 3으로 나눠서 3은 0 되도록 
		str = "0".repeat((3 - str.length()%3)%3) + str;
		
		for (int i=0; i<str.length()-2; i+=3) {		
			int n = 4*(str.charAt(i)-'0') + 2*(str.charAt(i+1)-'0') + str.charAt(i+2)-'0';
			sb.append(n);
		}
		System.out.println(sb);

	}

	// 다른 풀이) BigInteger 사용. 매개변수로 진수 변화 가능 
}
