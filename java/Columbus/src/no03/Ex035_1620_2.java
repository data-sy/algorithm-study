package no03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex035_1620_2 {

	public static void main(String[] args) throws IOException {
		//https://www.acmicpc.net/problem/1620
		
		// 2. 배열만 
		// 시간 초과 => 그래서 자료구조를 쓰는 거구나!
		// 지금 풀이로는 문자가 들어오면 arr를 순회하면서 인덱스를 찾아내야 해!
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] arr = new String[N+1];
		for (int i=1; i<=N; i++) {
			arr[i] = br.readLine();
		}
		for (int i=1; i<=M; i++) {
			String str = br.readLine();
			// charAt(0)이 알파벳 대소문자라면 -> 이 논리로 해도 돼! 근데 이번엔 try catch 써보자  
			int pocketNum = changeInt(str);
			if (pocketNum>0) {
				sb.append(arr[pocketNum]).append("\n");
			} else { // -1이겠지
				int j=-1;
				while(!str.equals(arr[++j]));
				sb.append(j).append("\n");
			}
		}
		System.out.println(sb);

	}
	static int changeInt(String str) {
		try {			
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return -1;
		}
	}

}
