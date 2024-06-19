package no04_복습스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex016_2217 {
	
	public static void main(String[] args) throws IOException  {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		int max = arr[N-1];
		for (int i=1; i<N; i++){
			int tmp = arr[N-i-1]*(i+1);
			if (max<tmp) max = tmp ;
		}
		System.out.println(max);
	}

}
