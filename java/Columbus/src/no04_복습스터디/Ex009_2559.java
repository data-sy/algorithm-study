package no04_복습스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex009_2559 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int sum = 0;
		int[] arr = new int[N+1];
		for (int i=1; i<=N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			arr[i]=temp;
			if (i<=K) sum+=temp;
		}
		int max = sum;
		for (int i=K+1; i<=N; i++) {
			sum = sum + arr[i] - arr[i-K];
			if (max<sum) max=sum;
		}
		System.out.println(max);

	}

}
