package no03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Ex040_1158 {

	public static void main(String[] args) throws IOException {
		//https://www.acmicpc.net/problem/1158
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		

		Deque<Integer> deque = new LinkedList<>();		
		for (int i=1; i<=N; i++) {
			deque.offer(i);			
		}
		sb.append("<");
		while(deque.size()>1) {
			for (int i=0; i<K-1; i++) {
				deque.offer(deque.poll());				
			}
			sb.append(deque.poll()).append(", ");
		}
		sb.append(deque.poll()).append(">");
		System.out.println(sb);
	}
	
}
