package no02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex017_18258_큐 {

	public static void main(String[] args) throws IOException{
		//https://www.acmicpc.net/problem/18258
		
		// 1. LinkedList로 구현
		// 2. 배열로 구현
		// 3. 라이브러리 사용 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int input = 0;
		StringBuilder sb = new StringBuilder();

		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String method = st.nextToken();
			if (st.hasMoreTokens()) input = Integer.parseInt(st.nextToken());
			
		}
		System.out.println(sb);
		
	}
	
	public static class arrQueue {
		private int front;
		private int back;
		private int size;
		private int[] arr;
		
		
	}

}
