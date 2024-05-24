package no04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex053_13305_long {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		long[] dArr = new long[N];
		for (int i=0; i<N-1; i++){
			dArr[i] = Long.parseLong(st.nextToken());
		}
		dArr[N-1] = 0;
		st = new StringTokenizer(br.readLine());
		long[] cArr = new long[N];
		for (int i=0; i<N; i++){
			cArr[i] = Long.parseLong(st.nextToken());
		}
		cArr[N-1] = -1;

		long sum = 0;
		for (int i=0; i<N-1; i++){
			long d =  dArr[i];
			long cost = cArr[i];
			while (cost < cArr[i+1]){
				d+=dArr[i+1];
				i++;
			}
			sum+=d*cost;
		}
		System.out.println(sum);
	}
}
