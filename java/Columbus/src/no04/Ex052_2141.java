package no04;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Ex052_2141 {
	
	public static void main(String[] args) throws IOException  {
		// https://www.acmicpc.net/problem/2141

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		// idea
		// 사람을 순서대로 나열했을 때 양 끝의 사람의 거리는 내부에서 상쇄
		// 그래서 그 내부가 계속 좁아지다가 마지막 내부 -> 거기가 최소거리
		// 이 때, |X[i]| ≤ 1,000,000,000, 1 ≤ A[i] ≤ 1,000,000,000이므로 long 사용 
		// 또한, 마을 위치가 순서대로 주어지는 게 아니야!!!

		long[][] XA = new long[N][2]; // 마을 위치와 그에 따른 사람 수 
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			XA[i][0] = Long.parseLong(st.nextToken());
			XA[i][1] = Long.parseLong(st.nextToken());
		}
//		System.out.println("전 첫번째 : "+Arrays.toString(XA[0]));
		// XA 정렬 (정렬기준은 첫 번째 열)
		Arrays.sort(XA, Comparator.comparingLong(a -> a[0]));
//		System.out.println("후 첫번째 : "+Arrays.toString(XA[0]));
		
		// 사람 수 누적
		long[] ASum = new long[N];
		ASum[0] = XA[0][1];
		for (int i=1; i<N; i++) {
			ASum[i] = ASum[i-1]+XA[i][1];
		}
		
		// 가운데 해당하는 사람의 마을 위치 찾기
		long cnt = (ASum[N-1]+1)/2;
		int i = 0;
		while(ASum[i]<cnt) i++;
		
		System.out.println(XA[i][0]);
		
	}
	
}
