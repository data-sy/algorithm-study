package chapter03_자료구조;

public class Ex019_퀵정렬가운데피봇 {
	public static void main(String[] args) {
		
		// 출처 : https://st-lab.tistory.com/250
		
		// 키워드 : 재귀적 수행, 분할 정복, 비교 정렬, 제자리 정렬(정렬 대상 외의 추가 공간 필요 x), 불안정정렬(서로 떨어진 원소끼리 교환)
		// 파티셔닝(partitioning) : 피벗보다 작은 값들은 왼쪽에, 큰 값들은 오른쪽에 치중하도록 하는 것
		
		// 장점
			// 빠름 O(NlogN)
			// 불안정정렬(서로 떨어진 원소끼리 교환)이라서 효율 좋음 : 해당 원소가 최종적으로 있어야 할 위치에 거의 근접하게 위치하도록 하기 때문
		// 단점 : 정렬된 배열을 정렬하려고 할 때 O(N^2)
		
		// 순서 : 피봇 정하기 -> 파티셔닝 -> 그 결과를 좌우 부분리스트로 재귀
		
		// 피봇 선택 기준
			// 왼쪽, 오른쪽 : 구현이 더 간단. 정렬된 배열에는 느려짐
			// 가운데 : 구현이 더 어렵지만, 정렬된 배열에 그나마 빠름 => 이걸로 알아두자!

		int[] arr = {5, 2, 0, 9, 3, 6, 1, 8, 7, 4};
		quickSortM(arr, 0, arr.length - 1);
	}
	// 정렬할 배열, s(start, low), e(end, high) 인덱스를 입력받아서
	private static void quickSortM(int[] A, int lo, int hi) {
			// 기본 단계
			if(lo >= hi) {
				return;
			}
			// 재귀 단계
			int pivot = partition(A, lo, hi);
			// pivot이 가운데 있으면 hi가 가리키는 위치가 pivot의 위치보다 높으면서 hi가 가리키는 원소가 pivot보다 작은 경우가 생긴다.
			// 따라서, 파티셔닝을 통해 얻은 pivot까지 포함하여 부분리스트로 나누기
			quickSortM(A, lo, pivot);
			quickSortM(A, pivot + 1, hi);
	}
	// pivot의 위치 반환
	private static int partition(int[] A, int left, int right) {
		
		// lo와 hi는 각각 배열의 끝에서 1 벗어난 위치부터 시작한다. => why?
		int lo = left - 1;
		int hi = right + 1;
		int pivot = A[(left + right) / 2];		// 부분리스트의 중간 요소를 피벗으로 설정
		
		while(true) {
			// 1 증가시키고 난 뒤의 lo 위치의 요소가 pivot보다 큰 요소를 찾을 떄 까지 반복한다.
			do { 
				lo++; 
			} while(A[lo] < pivot);
			// 1 감소시키고 난 뒤의 hi위치의 요소가 pivot보다 작은 요소를 찾을 떄 까지 반복한다. 기본 조건 lo<=hi
			do {
				hi--;
			} while(A[hi] > pivot && lo <= hi);
			// 만약 hi가 lo보다 크지 않다면(엇갈린다면) swap하지 않고 hi를 리턴한다.
			if(lo >= hi) {
				return hi;
			}
			swap(A, lo, hi);
		}
	}
	private static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
