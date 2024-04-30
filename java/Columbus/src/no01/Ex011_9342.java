package no01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SortedMap;
import java.util.TreeMap;

public class Ex011_9342 {

	public static void main(String[] args) throws IOException {
		// https://www.acmicpc.net/problem/9342
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());				
		String[] arr = new String[N];
		for (int i=0; i<N; i++) arr[i] = br.readLine();

		for (int i=0; i<N; i++) {
			String str = arr[i];
			char start = str.charAt(0);
			char end = str.charAt(str.length()-1);
			
			if (70<start || 70<end || str.length()<3) {
				System.out.println("Good");
				continue;
			} else { 
				if (start!='A') str=str.substring(1);
				if (end!='C') str=str.substring(0, str.length()-1);				
			}
			// AAAAAA 꼴이나 CCCCC 꼴은 인덱스 오류나므로
			int cnt = 0;
			int len = str.length();
			// AAAAAA 제외 앞에서부터 연속된 A 갯수 
			if (str.charAt(len-1) == 'A') {
				System.out.println("Good");
				continue;
			} else {
				int j = 0;
				while (str.charAt(j++)=='A') cnt++;
			}
			// CCCCC 제외 뒤에서부터 연속된 C 갯수 
			if (str.charAt(0) == 'C') {
				System.out.println("Good");
				continue;
			} else {
				int j = len-1;
				while (str.charAt(j--)=='C') cnt++;
			}
			// F 갯수 
			for (int j=0; j<len; j++) {
				if (str.charAt(j)=='F') cnt++;
			}
			
			if (cnt != len)	System.out.println("Good");
			else System.out.println("Infected!");
		}
	}

	// 다른 풀이) 정규표현식 사용 https://nahwasa.com/entry/%EB%B0%B1%EC%A4%80-9342-%EC%9E%90%EB%B0%94-%EC%97%BC%EC%83%89%EC%B2%B4-boj-9342-java
}
