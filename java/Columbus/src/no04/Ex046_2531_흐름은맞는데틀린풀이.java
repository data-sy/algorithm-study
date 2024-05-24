package no04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex046_2531_흐름은맞는데틀린풀이 {
	
	static int k;
	static int c;
	static int cnt;
	static int max; // Java에서 전역 변수는 해당 변수 타입의 기본값으로 자동으로 초기화. 즉, 0 할당되어 있음 

	public static void main(String[] args) throws IOException  {
		// https://www.acmicpc.net/problem/2531
		
		// 10%에서 틀림 : 지금 풀이 반례
//		8 30 4 30
//		2
//		3
//		4
//		4
//		2
//		3
//		4
//		4
// answer : 3		
		// 2 3 4 4 를 2번 반복
		// 즉 2가 빠지고 2가 더해져
		// 3이 빠지고 3이 더해져
		// 4가 빠지고 4가 더해져
		// 이 과정에서 len 계산이 잘못돼서 7개까지 올라가버려 
		
		// 17%에서 틀림 : 


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken()); // d를 굳이 준 게 arr[d] 불리언 쓰라는 것 같기는 한데... 
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		// 담기 
		int[] arr = new int[N+k-1];
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}		
		for (int i=N; i<N+k-1; i++) {
			arr[i] = arr[i-N];
		}
		System.out.println("추가한 것의 맨 마지막 : " + arr[N+k-2]);
		
		// 음식(번호가 인덱스) 개수 세는 배열 
		int[] cntArr = new int[d+1];
		
		// l을 기준으로 길이 k일 때 초밥 가짓수 (중복 제거한 길이라는 의미로 lenArr이라 두겠음)
		int[] lenArr = new int[N]; 

		// 처음부터 k개 초기화
		// l은 0으로 고정 
//		cntArr[arr[0]]++;
//		int len = 1;
		int len = 0;
		// l은 -1에서 대기 중
		// r(=i)을  0~k-1까지 진행
		for (int i=0; i<k; i++) {
			int tmp = arr[i];
			cntArr[tmp]++;
			if (cntArr[tmp]==1) len++;
		}
		// 확인 
		for (int i=0; i<cntArr.length; i++) {
			System.out.println((i) + "번 접시 개수 : " + cntArr[i]);
		}
		System.out.println("초기화 때 길이 : " + len);
		
		// 여기 결과물의 len을 lenArr[0]에 담아줘
		lenArr[0]=len;

		// 그 다음 부터는 l과 r의 위치 오른쪽으로 한 칸씩 옮겨가며 개수 세기
		// 한 반복 안의 결과물은 [l+1, --- , r] 형태
		for (int l=0, r=k; l<N-1; l++, r++) {
			len = lenArr[l];
			int lValue = arr[l];
			int rValue = arr[r];
			// (반례1) 이 풀이에서는 빼는 수와 더하는 수가 같을 때 상쇄 되어버려 
//			cntArr[lValue]--;
//			cntArr[rValue]++;
//			if (cntArr[lValue]==0) len--;
//			if (cntArr[rValue]==1) len++;
			cntArr[lValue]--;
			if (cntArr[lValue]==0) len--;
			cntArr[rValue]++;
			if (cntArr[rValue]==1) len++;
			lenArr[l+1]=len;
		}

		// 이제 lenArr에서 가장 큰 길이 구하고
        int max = lenArr[0];
        for (int i = 1; i < N; i++) {
            if (lenArr[i] > max) {
                max = lenArr[i];
            }
        }
        System.out.println("제일 긴 길이 : " + max);
		// 다시 돌리면서 해당하는 index 모두 모으기
		List<Integer> list = new ArrayList<>();
		for (int i=0; i<N; i++) {
			if (lenArr[i]==max) list.add(i);
		}
		
		System.out.print("제인 긴 배열 시작 인덱스들 : ");;
		list.forEach(e -> {
			System.out.print(e + " ");
		});
		System.out.println();

		// 한 번이라도 쿠폰 없는 게 나오면 끝
		Boolean hasNoCoupon = true;
		for (int i=0; i<list.size(); i++) {
			hasNoCoupon = true; // 쿠폰을 가지지 않을거라 가정하고 출발
			// 해당 시작 인덱스
			int check = list.get(i);
			System.out.println("check : " + check);
			// k개 다 돌면서 
			for (int j=0; j<k; j++ ) {
				System.out.println(arr[check]);
				if (arr[check]==c) {
					System.out.println("쿠폰 존재");
					hasNoCoupon = false;
					break;
					// 즉, 쿠키 가지는 경우 있으면 더 돌릴 필요 없이 멈추면 돼 
				}
				check++;
			}
			// 쿠폰을 가지는 경우가 없으면 끝. 있으면 큰 포문 다시 돌기
			if (hasNoCoupon) break;
		}
		// 쿠폰 없는 경우가 있으면 (k를 만족하지 못했으면 쿠폰 못 받아) max에서 +1 없애 
		// => 내가 문제 이해를 잘못했나봐. k를 만족하지 못하면 쿠폰을 못 받는 게 아니라
		// 중복해서 먹고 쿠폰도 받아. 즉, max+1 
		System.out.println(hasNoCoupon);
		if (hasNoCoupon) System.out.println(max<k ? max+1 :k+1);
		// 모두 쿠폰을 가지고 있으면 
		else System.out.println(max<=k ? max :k);
		// 아! k 길이를 만족 못 하면 쿠폰 못 받아 
	}


}
