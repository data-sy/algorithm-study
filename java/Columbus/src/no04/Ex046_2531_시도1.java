package no04;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Ex046_2531_시도1 {
	// 정돈 안 한 지저분한 상태
	
	static int cnt;
	static int c;
	static int max; // Java에서 전역 변수는 해당 변수 타입의 기본값으로 자동으로 초기화. 즉, 0 할당되어 있음 

	public static void main(String[] args) throws IOException  {
		// https://www.acmicpc.net/problem/2531
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		// idea
		// 처음 받을 때 마지막 부터 ~ k-1개까지 순회할 수 있도록 n뒤에 0~k-1 다시 더 붙여
		// indexOf로 쿠폰에 해당하는 번호가 벨트에 없는 경우/있는 경우로 분기 나누기
		// 없는 경우 (-1)
			// k로 슬라이딩 윈도우 하면서 서로 다른 최대 갯수 카운트 (1940에서 언급된 visited풀이 사용)
				// max가 k와 같아지는 순간 break 후 : k+1 출력 (max+1출력해도 같은 값이겠지)
				// 끝까지 돌아간다면 : max+1 출력
		// 있는 경우 (해당 최초 인덱스)
			// 해당 인덱스부터 점검하면 더 빨라
			// 위와 같은 방식으로 슬라이딩 하다가 (여기서는 cnt에 담기)
				// 똑같이 cnt가 k와 같아지면 break : cnt+1 출력
				// 쿠폰 나오면 max에 cnt 담아두고 cnt=0으로 초기화
				// 끝까지 돌아간다면 : max+1 출력
		// 있/없 나눌 필요 있나?? 매번 if문으로 쿠폰 번호인지 점검하는 것 vs 코드 중복 (우선 전자 택. 그 다음 후자로 리팩토링 해보자)
		// list여야 indexOf 가능... 그러면 그냥 arr쓰고 if문으로 점검하는 전자로 가자
		// 아냐 list의 contains 사용하면 좋아.. 아니야.. set으로 가자!!! 중복 제거 되니까!!! 오오오오
		// 아냐 ㅜㅡㅠ 넣을 때 중복 살려야 해! 중복 검사를 내부를 다 해야 하니까... 
		// 그러면 검색이 많은지 추가 삭제가 많은지에 따라 ArrayList(contains에 강해) , Linkedlist(offer, poll에 강해) 결정하기
		
		// 구현								
		int[] arr = new int[N+k-1];
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i=N; i<N+k-1; i++) {
			arr[i] = arr[i-N];
		}
//		System.out.println(Arrays.toString(arr));
		
		// boolean으로 시도하면 내부에 있을 가능성 구분할 수 없어 
		// 1940 문제에서는 딱 2개만 보는거라 T/F 처리 가능했어 
//		boolean[] isEaten = new boolean[d+1];
		// list로 점검
		List<Integer> list = new ArrayList<>();

		// k개 받아서 cnt 초기화 cnt=k;
		// 처음 k개 중 중복된 거 있으면 cnt--;
//		cnt = k; //
//		for (int i=0; i<k; i++) {
//			if (!list.contains(arr[i])) cnt--;
//			list.add(arr[i]);
//		}
		// 여기서도 쿠폰번호 있으면 max에 담고 리스트 비워줘야 해 
		// 그럴려면 cnt를 -- 하는 게 아니라 하나씩 ++ 해줘야 해
		// 메서드에 boolean 담아서 사용하자 
		for (int i=0; i<k; i++) {
			sliding(list, arr[i], false);			
		}
		System.out.print("초기화 한 배열 : ");
		list.forEach(e -> System.out.print(e + " "));
		System.out.println();
		System.out.println("1차 max : " + max);
		System.out.println("1차 cnt : " + cnt);
		System.out.println("============초기화끝 ===========");
		int j = 1;
		// i=k 부터 N+k-1까지 슬라이딩
		for (int i=k; i<N+k-1; i++) {
			System.out.println(j + "번째 값은 : " + arr[i]);
			j++;
			sliding(list, arr[i], true);
			// 만약 k에 도달한다면 멈춰도 돼
			System.out.println(arr[i]+"에 대한 슬라이딩 결과 cnt : " + cnt);
			if (cnt==k) break;
		}
		System.out.println("최종 max : " + max);
		System.out.println("최종 cnt : " + cnt);
		System.out.println( cnt<max ? max : cnt);
		
	}

	// 슬라이딩은 메서드로 
	// if 만약 쿠폰 번호라면 => 비우기, cnt=0 
		// 이 때, 기존 길이를 담아뒀다가 제일 max인 걸로 사용해야 해
	// else if 쿠폰 번호 아니면서 비어있는 상태면 => 넣고 cnt++
	// else 쿠폰 번호 아니면서 비어있지도 않으면
		// 맨 앞 빼면서 
			// 없으면 cnt--
		// r 은 넣기 전에
			// 없으면 cnt++
		// 그 다음 r 넣기 
	
	static void sliding(List<Integer> list, int rValue, Boolean isSecond) {
		if (rValue == c) {
//			list.clear();
			if (max<cnt) max=cnt;
			cnt = 0;
		} else if (list.isEmpty()) {
			System.out.println("쿠폰 다음은 여기로 들어와 ");
//			list.add(rValue);
			cnt++;
		} else { // 쿠폰 번호도 아니고, 비어있지도 않을 때
			System.out.print("여기로 들어와서 ");
			list.forEach(e -> System.out.print(e + " "));
			System.out.println("리스트 확인 ");
//			// l 빼기 
//			if(!list.contains(list.remove(0))) cnt--;
			// 두번째 일 때만 l 빼기 
			if (isSecond && !list.contains(list.remove(0))) cnt--;
			// r 넣기 
			if (!list.contains(rValue)) cnt++;
//			list.add(rValue);
		}
		list.add(rValue);
		System.out.print("메서드 나가기 전 ");
		list.forEach(e -> System.out.print(e + " "));
		System.out.println("리스트 확인 ");
		
	}

}
