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
		
		System.out.println(c);
		
		sc.close();

	}

}
