package no04_복습스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex수01_2609 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int mul = n*m;

		int r = n;
		while(r>0) {
			r = n%m;
			n = m;
			m = r;
		}
		int gcd = n;

		sb.append(gcd).append("\n").append(mul/gcd);
		System.out.println(sb);

	}
}
