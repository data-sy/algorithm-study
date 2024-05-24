package no04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex051_21921_누적합 {
	
	public static void main(String[] args) throws IOException  {
		// https://www.acmicpc.net/problem/21921

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());

		// 누적합 
		int[] arr = new int[N];
		arr[0] = Integer.parseInt(st.nextToken());
		for (int i=1; i<N; i++) arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
		
		// X개 부분합 중 큰 것 찾기
		int max = arr[X-1];
		int cnt = 1;
		for (int i=X; i<N; i++) {
			// i-X+1부터 i+1까지의 부분합 (X개)
			int tmp = arr[i] - arr[i-X];
			if (tmp>max) {
				max = tmp;
				cnt = 1;
			} else if (tmp==max) cnt++;
		}
		
		if (max==0) System.out.println("SAD");
		else {
			System.out.println(max);
			System.out.println(cnt);
		}
		
	}

	// 시간이 획기적으로 빠른 애들은 스트링토크나이저부분을 직접 구현 
	// 하나 빼고 하나 더하는 거랑 내 풀이는 별 차이 없나봐
}
