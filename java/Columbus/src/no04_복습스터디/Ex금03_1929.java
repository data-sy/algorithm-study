package no04_복습스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex금03_1929 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		boolean[] isCompo = new boolean[N+1];
		// 요거 안 넣으면 1 1 했을 때 1이 나와서 틀려! (80%대에서)
		isCompo[0] = true;
		isCompo[1] = true;

		for (int i=2; i<M; i++) {
			if (!isCompo[i]) { // 소수이면
				for (int j=i+i; j<=N; j+=i){
					isCompo[j]=true;
				}
			}
		}
		for (int i=M; i<=N; i++) {
			if (!isCompo[i]) { // 소수이면
				sb.append(i).append('\n');
				for (int j=i+i; j<=N; j+=i){
					isCompo[j]=true;
				}
			}
		}
		System.out.println(sb);
	}
}
