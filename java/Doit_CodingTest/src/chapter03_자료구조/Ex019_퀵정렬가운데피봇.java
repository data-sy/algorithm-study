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
		quickSort(arr, 0, arr.length - 1);
	}
	// 정렬할 배열, s(start, low), e(end, high) 인덱스를 입력받아서
	private static void quickSort(int[] A, int s, int e) {
			// 기본 단계
			if(s >= e) {
				return;
			}
			// 재귀 단계
			int pivot = partition(A, s, e);			
			quickSort(A, s, pivot);
			quickSort(A, pivot + 1, e);
	}
	// partitioning의 결과가 pivot이야!
	private static int partition(int[] A, int left, int right) {
		
		// s와 e는 각각 배열의 끝에서 1 벗어난 위치부터 시작한다. => why???
		int s = left - 1;
		int e = right + 1;
		int pivot = A[(left + right) / 2];		// 부분리스트의 중간 요소를 피벗으로 설정
		
		while(true) {
			// 1 증가시키고 난 뒤의 s 위치의 요소가 pivot보다 큰 요소를 찾을 떄 까지 반복한다.
			do { 
				s++; 
			} while(A[s] < pivot);
			// 1 감소시키고 난 뒤의 e 위치가 s보다 크거나 같은 위치이면서 e위치의 요소가 pivot보다 작은 요소를 찾을 떄 까지 반복한다.
			do {
				e--;
			} while(A[e] > pivot && s <= e);
			// 만약 e가 s보다 크지 않다면(엇갈린다면) swap하지 않고 e를 리턴한다.
			if(s >= e) {
				return e;
			}
		}
	}
	private static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
