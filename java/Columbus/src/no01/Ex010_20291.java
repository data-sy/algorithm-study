package no01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SortedMap;
import java.util.TreeMap;

public class Ex010_20291 {

	public static void main(String[] args) throws IOException {
		// https://www.acmicpc.net/problem/20291
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());				
		String[] arr = new String[N];
		for (int i=0; i<N; i++) {
			String str = br.readLine();
			arr[i] = str.substring(str.indexOf('.')+1);
		}

		SortedMap<String, Integer> map = new TreeMap<>();
		for (String str : arr) {
			int cnt = map.getOrDefault(str, 0);
			map.put(str, cnt+1);
		}
		map.forEach((k, v) -> System.out.println(k + " " + v));
	}

	// 리팩토링) 두 for문을 하나로 합쳐도 돼. 입력과 동시에 개수 카운트 
			// 스트링토크나이저 사용, 스트링 빌더에 넣어서 출력하기
	
	// 람다식 관련 설명) https://velog.io/@limhaekyu/Java-람다식Lambda과-람다식을-사용한-forEach
	
	// HashMap에 담았다면 키를 추출한 list에 Collections.sort(list);로 정렬 출력 가능 

}
