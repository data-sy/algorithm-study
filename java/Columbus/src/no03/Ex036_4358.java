package no03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SortedMap;
import java.util.TreeMap;

public class Ex036_4358 {

	public static void main(String[] args) throws IOException {
		//https://www.acmicpc.net/problem/4358
		
		// 입력 개수 미정일 때 : readLine() 반환값이 null일 때 중단  
		// 출처 : https://ddoongi.tistory.com/31
		// 입력을 끝내는 방법 : ctrl + D (오답노트에 상세설명)
		
		// 특정 포맷으로 바꾸고 싶을 때 : String.format("%.2f", 값);
		
		// 람다 표현식 및 익명 클래스에서 외부에서 정의된 변수를 참조할 때는 최종 변수(effectively final)여야 함 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		SortedMap<String, Integer> map = new TreeMap<>();
		String line;
		int len = 0;
		while((line=br.readLine())!=null) {
			int cnt = map.getOrDefault(line, 0);
			map.put(line, cnt+1);
			len++;
		}
		final double finalLen = len; // 람다식에서 사용하기 위해
		map.forEach((k, v) -> {
			sb.append(k).append(" ");
			sb.append(String.format("%.4f", v/finalLen*100 )).append("\n");
		});
		System.out.println(sb);

	}
}
