package no04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex054_2217 {

	public static void main(String[] args) throws IOException  {
		// https://www.acmicpc.net/problem/2217

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		int max = 0;
		for (int i=0; i<N; i++) {
			if (max<=arr[i]*(N-i)) max=arr[i]*(N-i);
		}
		System.out.println(max);

	}

}
