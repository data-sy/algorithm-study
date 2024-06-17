package no04_복습스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Ex007_1158 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();

		LinkedList<Integer> list = new LinkedList<>();
		for (int i=1; i<=N; i++){
			list.add(i);
		}
		sb.append("<");
		int i=K-1;
		while(list.size()>1){
			sb.append(list.remove(i)).append(", ");
			i = (i+K-1)% list.size();
		}
		sb.append(list.pop()).append(">");
		System.out.println(sb);

	}
}
