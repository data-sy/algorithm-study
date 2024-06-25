package no04_복습스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Ex목01_1620 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[] arr = new String[N+1];
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			arr[i+1] = str;
			map.put(str, i+1);
		}
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			char ch = str.charAt(0);
			if (65<=ch && ch<=90) sb.append(map.get(str)).append("\n");
			else {
				int num = Integer.parseInt(str) ;
				sb.append(arr[num]).append("\n");
			}
		}
		System.out.println(sb);
	}
}
