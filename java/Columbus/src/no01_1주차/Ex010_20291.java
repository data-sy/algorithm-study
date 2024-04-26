package no01_1주차;

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

}
