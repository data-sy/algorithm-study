package no02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex022_1966_배열카운트로 {

	public static void main(String[] args) throws IOException{
		//https://www.acmicpc.net/problem/1966
		// 16%에서 틀렸음 
		
		// 이런거 넣어도 맞는데 ㅜㅠ 
//		1
//		28 16
//		6 6 3 6 6 3 7 7 3 3 7 2 2 3 2 3 3 3 2 2 6 7 6 6 7 3 3 8
		// 반례 (https://www.acmicpc.net/board/view/90449)
//		1
//		5 3
//		1 2 3 [1] 2
		//  3까지 돌려 3 [1] 2 1 2 . 3프린트 한 뒤
		// => 앞의 2까지 돌려 2 1 2 [1] . 2 프린트 한 뒤
		// => 뒤의 2까지 돌려 2 [1] 1 . 2 프린트 한 뒤
		// 타겟에 닿았으므로 끝!
		// 보면 중간에 돌리면서 1의 위치가 바뀌어
// ∴ 직전 중요도로 갯수 세는 건 틀린 아이디어 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 개수 카운트 방법 시도 
			// 가장 큰 중요도가 target 중요도와 같을 때 (즉, target이 가장 클 때)
				// target까지 자기랑 같은 수 count
			// 가장 큰 중요도가 target 중요도보다 클 때 
				// 1) 큰 것들 다 세기 
				// 2) 같은 것들 중 직전 중요도와 타겟 사이에 있는 애들 세기
					// 언더바(_)에 있는 애들 세야 해 
					// 6______5 꼴
					// ___5      6___ 꼴 (이것도 순환하면 그 사이가 되니까)
					// 이 때, 직전 중요도란 (a) 타겟 중요도보다 큰 것 중 가장 작은 것 (b) 그 중 가장 뒤에 있는 것 
						// (타겟 중요도와 같은 경우를 출력하기 시작하는 순간이니까)
				// 예제 35133363733 , 37133353733
				// 	 타겟   ↑             ↑
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine()); 
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			// 중요도 배열 
			st = new StringTokenizer(br.readLine());
			// 가장 큰 중요도
			int big = 1;
			int[] arr = new int[N];			
			for (int j=0; j<N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				if (big<=arr[j]) big=arr[j];
			}
			System.out.println("배열에서 가장 큰 중요도 : " + big);
			
			// 타겟의 중요도 
			int target = arr[M];
			// 타겟보다 중요도 큰 것들 개수 
			int bigCnt = 0;
			// 직전 중요도와 그 인덱스 
			int check = 9;
			int checkIndex = 0;
			
			// 로직 시작 
			if (big==target) { // 가장 큰 중요도가 타겟의 중요도와 같을 때
				int cnt = 0;
				for (int j=0; j<=M; j++) {
					if (arr[j]==target) cnt++;
				}
				sb.append(cnt).append('\n');
			} else { // 타겟의 중요도보다 더 큰 중요도가 존재할 때
				// 큰 것 개수 세기 & 직전 중요도 찾기
				for (int j=0; j<N; j++) {
					if (target<arr[j]) {
						bigCnt++;
						if (arr[j]<=check) {
							check = arr[j];
							checkIndex = j;						
						}
					}
				}
				System.out.println("큰 것 개수 : " + bigCnt);
				System.out.println(check + "<-직전중요도+그인덱스->" + checkIndex);
				
				// 타겟과 중요도 같으면서 (순환 측면에서) 직전 중요도와 타겟 사이에 있는 것들 개수
				int cnt = 0;
				// 6_____5 꼴인 경우 
				if (checkIndex<M) { 
					for (int j=checkIndex; j<=M; j++) { 
						if (target==arr[j]) cnt++;
					} 
				} else { // __5    6__ 꼴인 경우 
					for (int j=0; j<N; j++) {  
						if (M<j && j<=checkIndex) continue;
						if (target==arr[j]) cnt++;
					} 				
				}
				System.out.println("중간 개수" + cnt);
				sb.append(bigCnt+cnt).append('\n');							
			}
		}
		System.out.println(sb);
	}
	
}
