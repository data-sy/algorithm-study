package no04;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex044_1940 {

	public static void main(String[] args) throws IOException  {
		// https://www.acmicpc.net/problem/1940

		// 들어온 값 중에 애초에 M보다 큰 것들은 버려도 돼 => 성능 사~알짝 올라감
		
		// 1. 투포인터
		// 2. 완전탐색 해서 성능 비교하기 

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		// idea
		// 먼저 정렬하고
		// l과 r의 합이
			// M보다 크다면 r을 한 칸 왼쪽으로
			// M과 같다면 cnt++ & l을 한 칸 오른쪽으로
			// M보다 작다면 l을 한 칸 오른쪽으로
		
		int[] arr = new int[N];
		for (int i=0; i<N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if (tmp<M) arr[i] = tmp;
		}
		Arrays.sort(arr);
		
		int cnt = 0;
		for (int l=0, r=N-1; l!=r;) {
			int intL = arr[l];
			int intR = arr[r];
			if (intL+intR>M) r--;
			else {
				if (intL+intR==M) cnt++;
				l++;
			}
		}
		System.out.println(cnt);

	}

}
