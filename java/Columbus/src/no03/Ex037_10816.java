package no03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class Ex037_10816 {

	public static void main(String[] args) throws IOException {
		//https://www.acmicpc.net/problem/10816
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split(" ");
		
		HashMap<String, Integer> map = new HashMap<>();
		for (int i=0; i<N; i++) {
			String str = arr[i];
			map.put(str, map.getOrDefault(str, 0)+1);
		}
		
		int M = Integer.parseInt(br.readLine());		
		arr = br.readLine().split(" ");
		
		for (String str : arr)	{
			sb.append(map.getOrDefault(str, 0)).append(" ");
		}
		System.out.println(sb);
	}
	
	// arr[2*입력max]에 담아도 돼. 음수부터 양수까지 담을거니까 2배 크기로 선정 	
}
