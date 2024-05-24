package no04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex045_2559_부분합 {

	public static void main(String[] args) throws IOException  {
		// https://www.acmicpc.net/problem/2559

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		// idea 
		// sum의 초기값은 0에서 K-1까지 더하기 (이거는 arr 채울 때 같이 작업) 
		// a A b (a는 l, A는 가운데 배열, b는 r)
		// 기존 배열 a+A < 다음 배열 A+b 일 때 갱신
			// a+A<A+b <=> a<b
		// 즉, i를 0에서 N-K까지 반복문을 돌며
			// arr[i] < arr[i+K]일 때 sum 갱신
		// 구현 
		// 1차 시도 : 처음엔 tmp = arr[i+K] - arr[i] > 0 일 때 max+=tmp; 라고 만들었어
			// 이 코드의 반례 : K=2 일 때, [7 13] 2 2 [13 8] => 떨어진 곳에서 갱신될 수도 있어 
		// 수정 : 배열의 합 sum을 계속 찾고, 그게 max보다 크면 max를 sum으로 갱신 

		int[] arr = new int[N];
		int max = 0;

		for (int i=0; i<N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			arr[i] = tmp;
			if (i<K) max+=tmp;
		}

		int sum = max;
		for (int i=0; i+K<N; i++) {
			sum += arr[i+K] - arr[i];
			if (max<sum) max = sum;
		}
		System.out.println(max);

	}

}
