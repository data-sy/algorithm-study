package no03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Ex035_1620_3 {

	public static void main(String[] args) throws IOException {
		//https://www.acmicpc.net/problem/1620
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<Integer, String> map = new HashMap<>();
		Map<String, Integer> reverseMap = new HashMap<>();		
		for (int i=1; i<=N; i++) {
			String str = br.readLine();
			map.put(i, str);
			reverseMap.put(str, i);
		}
		for (int i=1; i<=M; i++) {
			String str = br.readLine();
			// charAt(0)이 알파벳 대소문자라면 -> 이 논리로 해도 돼! 근데 이번엔 try catch 써보자  
			int pocketNum = changeInt(str);
			if (pocketNum>0) {
				sb.append(map.get(pocketNum)).append("\n");
			} else { // -1이겠지
				sb.append(reverseMap.get(str)).append("\n");
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
