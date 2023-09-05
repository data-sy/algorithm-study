package chapter03_자료구조;

import java.util.Arrays;

public class Ex020_수정렬하기2 {
	public static void main(String[] args) {
		
		// 병합정렬 이론
			// 병합정렬은 안정적이고 시간복잡도도 좋다.
			// 방법론이 다른 코테에서도 자주 쓰이므로 알아두자! => 2개의 그룹을 병합하는 상황
			// 시간복잡도 O(nlogn) 병합하면서 정렬하는 횟수 logn(2개씩 그룹을 합치므로) * 한 정렬 당 n번 데이터 액세스
		
	// 2개의 그룹을 병합하는 과정 - 응용 포인트
		// 예) 길이 4인 A그룹과 B그룹 병합 
			// 길이 8인 전체 배열에서 투 포인터 시작점은 0번째와 5번째
			// A[0]>B[0] 이면 B[0]이 첫번째로 이동!!!
				// 이 이동을 버블소트로 구현했다면 swap 4번
				// 요게 엄청 반짝이는 아이디어야!
		// 적용) 자동차 시합에서 현재 순위를 배열로. 낮은 숫자일수록 빠른 자동차
			// 이렇게 쭉~ 무한대로 간다고 하면 이 자동차 시합에서는 몇 번의 역전이 일어날까
			// 병합 정렬 아이디어로 풀면 ) B그룹에서 그 원소가 "뽑히는 순간" "A그룹의" 원소들을 몇 개를 뛰어넘었는지 count 하면 돼
				// 이 때 , A그룹을 뛰어넘는다 = A그룹에 남아있는 원소
				// "뽑히는 순간" = 그 전에 뽑힌 A는 세지 않아. "A그룹의" = B그룹의 원소는 셀 필요 없어
		
//		// 1차 시도 : merge의 아이디어는 얼추 맞아. 
		// 이 때, 그 전에 재귀를 실행시켜줌으로써 분할을 먼저
//		int[] test = {4, 5, 2, 6, 3, 9, 1, 0, 7, 8};
//		
////		mergeSort();
//		System.out.println(Arrays.toString(test));	
//	}
//	public static int[] mergeSort(int[] A, int[] B) {
//		int[] C = new int[A.length+B.length];
//		int i=0, j=0, k=0;
//		while(i<A.length-1 || j<B.length-1) {
//			if (A[i]<B[j]) C[k++]=A[i++];
//			else C[k++]=B[j++];
//		}
//		if (i==A.length-1) {
//			while(j==B.length-1) C[k++]=B[j++];
//			}
//		if (j==B.length-1) {
//			while(i==A.length-1) C[k++]=A[i++];
//		}
//		return C;
		
		// 2차 시도
		int[] test = {4, 5, 2, 6, 3, 9, 1, 0, 7, 8};
		
//		mergeSort();
		System.out.println(Arrays.toString(test));			
	}
	public static void mergeSort(int s, int e) {
		// 기본 단계
		if (s==e) return;
	
		// 재귀 단계
		int m = (s+e)/2;
		mergeSort(s, m);
		mergeSort(m+1, e);
		
		// 정렬 수행
		
		
		
	}
}
