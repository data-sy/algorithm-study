package no03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Ex041_18115 {

	public static void main(String[] args) throws IOException {
		//https://www.acmicpc.net/problem/18115
				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 기술을 역순으로 담아서 다시 실행
		String[] arr = new String[N];
		for (int i=N-1; i>=0; i--) {
			arr[i] = st.nextToken();
		}
		// 1 2 3 3 2
		
		// Deque는 인덱스 지정 add는 사용 못해
//		Deque<String> deque = new LinkedList<>();
		LinkedList<Integer> list = new LinkedList<>();
		
		for (int i=0; i<N; i++) {
			String str = arr[i];
			switch(str) {
				case "1" :
					list.add(0, i);
					break;
				case "2" :
					list.add(1, i);
					break;
				case "3" : 
					list.add(i);
					break;
			}
		}
		list.forEach(e -> sb.append(e+1).append(" "));
	
		System.out.println(sb);
		
	}
	
}
