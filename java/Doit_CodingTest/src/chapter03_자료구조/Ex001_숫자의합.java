package chapter03_자료구조;

import java.util.Scanner;

public class Ex001_숫자의합 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
//		// 수로 접근
//		// long은 20자리 미만의 크기라서 N<=100 을 품지 못함
//		long size = sc.nextLong();
//		long input = sc.nextLong();
//		
//		long sum=0;
//
//		while(input!=0) {
//			sum+=input%10;
//			input=input/10;
//		}
//		
//		System.out.println(sum);
		
		// Q. 0으로 시작하는 수는 어떻게 받아들일까?
			// 만약 없이 받아들인다면 합이라서 괜찮아.
		
		// 문자로 접근
		int size = sc.nextInt();
		String input = sc.next();
		
		long sum = 0;

		for(int i = 0; i < size; i++) {
			sum += input.charAt(i)-'0';
		}
		
		System.out.println(sum);
		
	
	}

}
