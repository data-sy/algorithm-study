package no02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex019_1874 {

	public static void main(String[] args) throws IOException{
		//https://www.acmicpc.net/problem/10769
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int[] arr = new int[N];
		for (int i=0;i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Stack<Integer> stack = new Stack<>();

	}

}
