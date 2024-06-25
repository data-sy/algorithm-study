package no04_복습스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Ex목02_10816 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		HashMap<String, Integer> map = new HashMap<>();
		for (int i=0; i<N; i++) {
			String str = st.nextToken();
			map.put(str, map.getOrDefault(str, 0)+1);
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i=0; i<M; i++) {
			String str = st.nextToken();
			sb.append(map.getOrDefault(str, 0)).append(" ");
		}

		System.out.println(sb);

	}
}
