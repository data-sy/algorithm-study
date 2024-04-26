package chapter04_정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Ex020_수정렬하기2_sol {
	public static int[] A, tmp;
	public static long result;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		A = new int[N+1];
		tmp = new int[N+1];
		
		for (int i=1; i<=N; i++) {
			A[i]=Integer.parseInt(br.readLine());
		}

		mergeSort(1, N);
		System.out.println(Arrays.toString(A));
		for (int i=1; i<=N; i++) {
			bw.write(A[i]+"\n");
		}
		bw.flush();
		bw.close();	
		
	}
	public static void mergeSort(int s, int e) {
		// 기본 단계 
		if (e-s<1) return;
		
		// 재귀 단계 
		int m = (s+e)/2;
		mergeSort(s, m);
		mergeSort(m+1, e);
		
		// 정렬
		// 수 비교를 위한 임시 배열 
		for (int i=s; i<=e; i++) {
			tmp[i]=A[i];
		}
		
		int i = s;
		int j = m+1;
		int k = s;
		while(i<=m && j<=e) {
			if (tmp[i]<tmp[j]) A[k++]=tmp[i++];
			else A[k++]=tmp[j++];
		}
		while(i<=m) A[k++]=tmp[i++];
		while(j<=e) A[k++]=tmp[j++];
	}
}
