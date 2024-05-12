package no03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Ex042_14425_set {

	public static void main(String[] args) throws IOException {
		//https://www.acmicpc.net/problem/14425
		
		// 성능 비교 
		// 1. set.contains
		// 2. map.get
		// 3. list.contains
		// 2>1>>>>3
		// 의외로 set보다 map이 빠르네? 근데 아~주 근소한 차이이긴 해
		// list는 엄청 느려 (1,2는 400ms, 3은 2660ms)

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashSet<String> set = new HashSet<>();
		for (int i=0; i<N; i++) {
			set.add(br.readLine());
		}

		int cnt = 0;
		for (int i=0; i<M; i++) {
			if (set.contains(br.readLine())) cnt+=1;
		}
		System.out.println(cnt);		
	}
	
}
