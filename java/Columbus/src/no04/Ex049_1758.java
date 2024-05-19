package no04;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex049_1758 {
	
	public static void main(String[] args) throws IOException  {
		// https://www.acmicpc.net/problem/11047
		
		// 1<=N<=100,000, 1<=tip<=100,000
		// 제일 큰 경우는 10,000,000,000-50,000 : int가 담을 수 있는 수를 넘어버려
		// int 범위 -2,147,483,648에서 2,147,483,647

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		long tip = 0;
		for (int i=0; i<N; i++) {
			if (arr[N-1-i]<=i) break;
			tip += arr[N-1-i]-i;
		}
		System.out.println(tip);
	}

}
