package no01_1주차;

import java.util.Scanner;

public class Ex004_1157 {

	public static void main(String[] args) {
		// https://www.acmicpc.net/problem/1157
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		int[] arr = new int[26];
		for (int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if (65<=c && c<=90)	arr[c-65]++;
			else arr[c-97]++;
		}
		
		int max = arr[0];
		int maxIndex = 0;
		for (int i=0; i<26; i++) {
			if (max<=arr[i]) {
				max = arr[i];
				maxIndex = i;
			}
		}
		
		char c = (char) (maxIndex + 65);
		for (int i=0; i<26; i++) {
			if (arr[i]==max && i!=maxIndex) c = '?';
		}
		// 리팩토링) 두 for문을 하나로 합쳐도 돼. else if 조건문으로 추가해서 
		
		System.out.println(c);
		
		sc.close();

	}

}
