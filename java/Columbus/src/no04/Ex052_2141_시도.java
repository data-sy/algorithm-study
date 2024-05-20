package no04;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex052_2141_시도 {
	
	public static void main(String[] args) throws IOException  {
		// https://www.acmicpc.net/problem/2141

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		// idea
		// 사람을 순서대로 나열했을 때 양 끝의 사람의 거리는 내부에서 상쇄
		// 그래서 그 내부가 계속 좁아지다가 한 가운데서 만났을 때 -> 거기가 최소거리
		// 이 때, |X[i]| ≤ 1,000,000,000, 1 ≤ A[i] ≤ 1,000,000,000이므로 long 사용 
		
		// 3%에서 틀림
			// 조건 : 가능한 경우가 여러 가지인 경우에는 더 작은 위치를 출력하도록 한다.
			// long cnt = ASum[N-1]/2+1;을 하면 큰 경우를 출력한 것!
		// 이거 해결해도 3프로에서 틀리는 거 보니까 다른 반례가 있나봐...
		
		// 질문 게시판에서 확인! => 마을 위치가 순서대로 주어지는 게 아니야!!!
		// 즉, sort를 먼저 하긴 해야 해 

		long[] X = new long[N]; // 마을 위치
		long[] ASum = new long[N]; // 사람 수 누적
		// i=0은 직접 채우자
		st = new StringTokenizer(br.readLine());
		X[0] = Integer.parseInt(st.nextToken());
		ASum[0] = Integer.parseInt(st.nextToken());
		for (int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			X[i] = Integer.parseInt(st.nextToken());
			ASum[i] = ASum[i-1]+Integer.parseInt(st.nextToken());
		}
		
		// 가운데 해당하는 사람의 마을 위치 찾기
		long cnt = (ASum[N-1]+1)/2;
		int i = 0;
		while(ASum[i]<cnt) i++;
		
		System.out.println(X[i]);
		
	}
	
}
