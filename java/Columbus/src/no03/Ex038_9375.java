package no03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Ex038_9375 {

	public static void main(String[] args) throws IOException {
		//https://www.acmicpc.net/problem/9375
		
		// 약수의 개수 세기랑 같은 논리
		// 의상의 종류 => 각 소수
		// 의상의 수 => 그 소수의 n제곱
		// 입을 수 있는 조합 => 약수의 개수
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i=0; i<T; i++) {
			int n = Integer.parseInt(br.readLine());
			// 같은 이름을 가진 의상은 존재하지 않으니까 의상의 종류만 카운트하면 돼
			HashMap<String, Integer> map = new HashMap<>();
			for (int j=0; j<n; j++) {
				String str = br.readLine().split(" ")[1];
				map.put(str, map.getOrDefault(str, 0)+1);
			}
			int mul=1;
			for (Integer cnt : map.values()) {
				mul*=cnt+1;
			}
			sb.append(mul-1).append("\n");
			
		}
		System.out.println(sb);
	}
	
}
