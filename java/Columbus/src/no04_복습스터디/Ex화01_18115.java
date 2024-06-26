package no04_복습스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Ex화01_18115 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		String[] arr = new String[N];
		for (int i=0; i<N; i++){
			arr[N-1-i] = st.nextToken();
		}
		LinkedList<Integer> list = new LinkedList<>();
		for (int i=0; i<N; i++){
			switch (arr[i]) {
				case "1":
					list.add(0, i);
					break;
				case "2":
					list.add(1, i);
					break;
				case "3":
					list.add(i);
					break;
			}
		}
		list.forEach( e -> sb.append(e+1).append(" "));
		System.out.println(sb);
	}
}
