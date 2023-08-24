package chapter03_자료구조;

import java.util.Scanner;

public class Ex001_숫자의합_sol {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String sNum = sc.next();
		// char 배열로 변환
		char[] cNum = sNum.toCharArray();
		
		long sum = 0;

		for(int i = 0; i < cNum.length; i++) {
			sum += cNum[i] - '0';
		}
		
		System.out.println(sum);
	
	}

}
