package no04_복습스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex월02_9012 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i=0; i<N; i++) {
			String str = br.readLine();
			int cnt = 0;
			String isVPS = "YES";
			for(int j=0; j<str.length(); j++){
				if (str.charAt(j)=='(') cnt++;
				else {
					cnt--;
					if (cnt<0) {
						isVPS = "NO";
						break;
					}
				}
			}
			if (cnt>0) isVPS="NO";
			sb.append(isVPS).append("\n");
		}
		System.out.println(sb);
	}
}
