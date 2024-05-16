package no04;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex045_2559 {

	public static void main(String[] args) throws IOException  {
		// https://www.acmicpc.net/problem/2559

		// 같은 풀이로도 시간 차이가 남
		// 10ms 정도의 차이는 의미 없나봐. 
		// 오차 날 수 있대! https://www.acmicpc.net/board/view/75899

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
		// 기존 풀이 (23708	272)
		for (int i=0; i<N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			arr[i] = tmp;
			if (i<K) max+=tmp;
		}
//		// 실험1 : 조건문 빼고 for로 직접 넣어주기 (23772 280) 오잉? 더 느려졌어 ㅋㅋㅋ
//		// 실험2 : 실험 1 + 따로 변수명에 안 담아줬어
//		for (int i=0; i<N; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
//		}
//		for (int i=0; i<K; i++) {
//			max +=arr[i];
//		}
				
		// 기존 풀이
		int sum = max;
		for (int i=0; i+K<N; i++) {
			sum += arr[i+K] - arr[i];
			if (max<sum) max = sum;
		}
		System.out.println(max);
//		// 실험 3 : sum을 한꺼번에 연결하지 않고 따로 하기 (	24088	276)
//		int sum = max;
//		for (int i=0; i+K<N; i++) {
//			sum += arr[i+K];
//			sum -= arr[i];
//			if (max<sum) max = sum;
//		}
//		System.out.println(max);
//		// 실험 4 : max와 sum 바꾸기 (24068	 280)
//		int sum = max;
//		for (int i=0; i+K<N; i++) {
//			max += arr[i+K] - arr[i];
//			if (sum<max) sum = max;
//		}
//		System.out.println(sum);		

	}
	
	// 나랑 완전히 똑같은 풀이인데 왜 성능 차이가 날까? (22976	256) https://www.acmicpc.net/source/27839946
	// 다른 점 1
		// max를 담을 때 같이 하지 않고 for {arr[i] = 토큰} / for {K까지 누적} 
			// 내 풀이는 for문 안에서 K보다 큰 i들에 대해서도 if 조건을 점검하지만
			// 이 풀이는 점검 없이 딱 K만 따로 돌려셔... for문을 2번 사용하는 건 (O(2N)) 큰 영향 없나봐..
	// => 실험 1, 2 결과 이 부분은 내 풀이가 더 빠르고 메모리도 적게 사용해!
	// 다른 점 2
		// sum += 에 한꺼번에 하지 않고 둘을 나눠서 진행
		// sum -= 따로, sum += 따로
	// => 실험 3 결과 이 부분도 내 풀이가 더 빠르고 메모리도 적게 사용해!
	// 다른 점 3
		// max와 sum 변수명 바꿔서 사용 근데 마지막에 둘 다 max를 출력..
		// 나는 sum의 초기값을 max로 두고 거기에 슬라이딩 윈도우를 적용 sum이 커지면 max에 담아
		// 이 풀이는 max의 초기값을 sum으로 두고 같은 논리로 max를 갱신
	// => 실험 4 결과 이 부분도 내 풀이가 더 빠르고 메모리도 적게 사용해!
	
	// 오잉오잉???
	// 아얘 복붙해서 돌려보자 (24132	284) 더 느려짐 ㅋㅋㅋㅋㅋㅋ
	// 3년 전 풀이라 뭔가 서버 성능이 바뀌었나바........
	
	// 다시 한 번 내 기존 풀이로 돌렸을 때 맨 처음과 같다면 이거 ㄱㄱ
	// 23772 288 또 느려짐.... 
	// 결론 : 이 정도 시간차는 같은 풀이에서 나올수도 있나봐!!!

}
