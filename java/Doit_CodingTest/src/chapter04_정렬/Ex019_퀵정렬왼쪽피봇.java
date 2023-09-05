package chapter04_정렬;

import java.util.Arrays;

public class Ex019_퀵정렬왼쪽피봇 {
	public static void main(String[] args) {
		
		int[] A = {5, 2, 0, 9, 3, 6, 1, 8, 7, 4};
		quickSortL(A, 0, A.length - 1);
		System.out.println(Arrays.toString(A));
		
	}
	private static void quickSortL(int[] A, int lo, int hi) {		
		// 기본단계
		if(lo >= hi) {
			return;
		}
		// 재귀단계
		int pivot = partition(A, lo, hi);			
		quickSortL(A, lo, pivot - 1);
		quickSortL(A, pivot + 1, hi);
	}
	
	// 피봇의 위치 반환
	private static int partition(int[] A, int left, int right) {
		// 나중에 swap 할 때 left를 사용해야 하므로 새로운 변수에 담음
		int lo = left;
		int hi = right;
		int pivot = A[left];		// 부분리스트의 왼쪽 요소를 피벗으로 설정
		while(lo < hi) {
			while(A[hi] > pivot && lo < hi) {
				hi--;
			}
			while(A[lo] <= pivot && lo < hi) {
				lo++;
			}
			swap(A, lo, hi);
		}
		swap(A, left, lo);		
		// 두 요소가 교환되었다면 피벗이었던 요소는 lo에 위치하므로 lo를 반환한다.
		return lo;
	}
 
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
}
