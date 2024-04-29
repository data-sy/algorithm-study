package no01_1주차;

import java.util.Scanner;

public class Ex006_2609 {

	public static void main(String[] args) {
		// https://www.acmicpc.net/problem/2609
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int lcm = n;
		int i = 2;
		while(lcm%m!=0)	lcm = n*(i++);
		
		System.out.println(n*m/lcm);
		System.out.println(lcm);
		
		// 리팩토링) gcd를 유클리드 알고리즘을 이용해서 구하는 방법 사용하면 시간복잡도 O(logN)
		// https://develop247.tistory.com/346

	}

}
