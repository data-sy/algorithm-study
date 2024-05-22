package no04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex053_13305_시도1 {
	
	public static void main(String[] args) throws IOException  {
		// https://www.acmicpc.net/problem/13305

		// 지금 이 풀이는 그 때 그 때 부족할 때마다 충전하는 코드
		// 이건 이건 최소값이 아니야
		// 항상 남은 기름을 단 채로 이동하니까 그만큼이 낭비된 cost

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dArr = new int[N-1];
		for (int i=0; i<N-1; i++) {
			dArr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int[] costArr = new int[N-1]; // 마지막 도시 가격은 필요 없어서
		for (int i=0; i<N-1; i++) {
			costArr[i] = Integer.parseInt(st.nextToken());
		}
		int r = 0;
		int sum = 0;
		for (int i=0; i<N-1; i++) {
			int k = 0;
			int d = dArr[i];
			int cost = costArr[i];
			r-=d;
			while(r<0) {
				r += cost;
				k++;
			}
			sum += k*cost;
		}
		System.out.println(sum);
	}
	
}
