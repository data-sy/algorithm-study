package no04;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Ex046_2531_시도2 {
	
	static int k;
	static int c;
	static int cnt;
	static int max; // Java에서 전역 변수는 해당 변수 타입의 기본값으로 자동으로 초기화. 즉, 0 할당되어 있음 

	public static void main(String[] args) throws IOException  {
		// https://www.acmicpc.net/problem/2531
				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken()); // d를 굳이 준 게 arr[d] 불리언 쓰라는 것 같기는 한데... 
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+k-1];
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}		
		for (int i=N; i<N+k-1; i++) {
			arr[i] = arr[i-N];
		}
//		System.out.println(Arrays.toString(arr));
		
		// list로 점검
		List<Integer> list = new ArrayList<>();

		int j=1;
		for (int i=0; i<N+k-1; i++) {
			System.out.println("===========" + j + "번째 값은 : " + arr[i] +"===========");
			j++;
			sliding(list, arr[i]);
			// 만약 k에 도달한다면 멈춰도 돼
			System.out.println(arr[i]+"에 대한 슬라이딩 결과 cnt : " + cnt);
			if (cnt==k) break;
		}
		System.out.println("최종 max : " + max);
		System.out.println("최종 cnt : " + cnt);
		System.out.println( cnt<max ? max + 1 : cnt + 1);
		
	}

	// 슬라이딩은 메서드로 
	// if 만약 쿠폰 번호라면 (A)
		// 비우기, cnt=0 
		// 이 때, 기존 길이를 max와 비교해서 크다면 max 갱신 
	// else if 쿠폰 번호 아니면서 비어있는 상태면 => 넣고 cnt++ (B)
	// else 쿠폰 번호 아니면서 비어있지도 않으면 (C)
		// if 길이가 k와 같으면 (C-1)
			// 맨 앞을 remove하면서 그게 내부에 없으면 cnt--
		// rValue를 담으면서 내부에 rValue 가 없으면 cnt++ (C-2)
	
	// 예제 입력 2를 보면
	// 2 7 9 25 에서 7이 쿠폰이라서 쿠폰 거 +1 안하고 4개
	// 즉, 쿠폰 나왔다고 list 비워버리면 안 돼!!!
	
	static void sliding(List<Integer> list, int rValue) {
		if (rValue == c) { // A
			list.clear();
			if (max<cnt) max=cnt;
			cnt = 0;
		} else if (list.isEmpty()) { // B
			list.add(rValue);
			cnt++;
		} else { // 쿠폰 번호도 아니고, 비어있지도 않을 때 C
			System.out.print("여기로 들어와서 ");
			list.forEach(e -> System.out.print(e + " "));
			System.out.println("리스트 확인 ");
	/*C-1*/	if (list.size()==k && !list.contains(list.remove(0))) cnt--;
	/*C-2*/ if (!list.contains(rValue)) cnt++;
			list.add(rValue);
		}
		System.out.print("메서드 나가기 전 ");
		list.forEach(e -> System.out.print(e + " "));
		System.out.println("리스트 확인 ");
		
	}

}
