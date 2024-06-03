package no04_복습스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex011_1758 {
	
	public static void main(String[] args) throws IOException  {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		for(int i=0; i<N; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		long sum = 0;
		for(int i=0; i<N; i++){
			int tip = arr[N-i-1]-i;
			if (tip>0) sum += tip;
			else break; // 음수 나오는 순간 더 할 필요 없으니까 멈추자
		}
		System.out.println(sum);

	}

}
