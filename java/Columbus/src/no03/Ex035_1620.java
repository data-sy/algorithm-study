package no03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Ex035_1620 {

	public static void main(String[] args) throws IOException {
		//https://www.acmicpc.net/problem/1620
		
		// 1. 배열 : 번호->이름 / map : 이름->번호
		// 2. 배열만 사용 : 시간 초과 (아! 그래서 자료구조를 사용하는구나!)
		// 3. 둘다 map 사용 : 1번보다 성능 ↓
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] arr = new String[N+1];
		Map<String, Integer> reverseMap = new HashMap<>();
		for (int i=1; i<=N; i++) {
			String str = br.readLine();
			arr[i] = str;
			reverseMap.put(str, i);
		}
		for (int i=1; i<=M; i++) {
			String str = br.readLine();
			int pocketNum = changeInt(str);
			// charAt(0)이 알파벳 대소문자라면 -> 이 논리로 해도 돼! 근데 이번엔 try catch 써보자  
			if (pocketNum>0) {
				sb.append(arr[pocketNum]).append("\n");
			} else { 
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

	// 들어오는 숫자도 String 처리 해버리면 한 map에서 관리 가능 map<String, String>
}
