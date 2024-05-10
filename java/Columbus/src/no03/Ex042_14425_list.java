package no03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex042_14425_list {

	public static void main(String[] args) throws IOException {
		//https://www.acmicpc.net/problem/14425
		
		// 성능 비교 
		// 1. set.contains
		// 2. map.get
		// 3. list.contains

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<String> set = new ArrayList<>();
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
