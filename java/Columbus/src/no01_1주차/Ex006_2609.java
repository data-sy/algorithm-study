package no01_1주차;

import java.util.Scanner;

public class Ex006_2609 {

	public static void main(String[] args) {
		// https://www.acmicpc.net/problem/2609
		
		// (n, m) 최대공약수, 최소공배수 구하기 문제 
		// 2로 미리 점검할 수 있으니 약수 구하기가 나은가? 
			// 놉! 배수도 어차피 알아서 내부에서 그런 논리로 돌아가.
			// ( 심지어 얘는 알아서 그렇게 되기 때문에 오히려 코드 간결)
			// 2*500, 2*501 => 2*500*1~501 501에서 스탑 
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int lcm = n;
		int i = 2;
		while(lcm%m!=0)	lcm = n*(i++);
//		int gcd = n*m/lcm;
		
		System.out.println(n*m/lcm);
		System.out.println(lcm);

	}

}
