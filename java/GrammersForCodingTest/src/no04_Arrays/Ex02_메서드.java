package no04_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Ex02_메서드 {

	public static void main(String[] args) {

		int[] arr = {100, 10, 1000, 1, 10000};
		String[] arrStr = {"Hello", "Java", "World"};

		System.out.println("===== toString : String으로 변환하는 건데 print에 for문 안 돌려도 되는 용법으로 사용 =====");
		System.out.println(Arrays.toString(arr)); // [100, 10, 1000, 1, 10000]
		
		System.out.println("===== sort : 오름차순 정렬 =====");
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr)); // [1, 10, 100, 1000, 10000]		
		System.out.println("===== binarySearch : (정렬된 배열에 대해) 이진탐색 =====");
		System.out.println(Arrays.binarySearch(arr, 10)); // 1

		System.out.println("===== copyOf(A, n) : A를 길이 n인 배열로 복사 =====");
		String[] arrStr2 = Arrays.copyOf(arrStr, 5);
		System.out.println(Arrays.toString(arrStr2)); // 남는 길이는 기본값으로 초기화
		System.out.println("===== copyOfRange(A, n, m) : A를 인덱스 n이상 m미만 슬라이싱해서 복사 =====");
		int[] arr2 = Arrays.copyOfRange(arr, 1, 4);
		System.out.println(Arrays.toString(arr2)); // [10, 100, 1000]
	
		System.out.println("===== fill(A, a) : 배열 A를 특정값 a로 초기화 =====");
		Arrays.fill(arr, 5);
		System.out.println(Arrays.toString(arr)); // [5, 5, 5, 5, 5]
		
		System.out.println("===== asList : 배열을 ArrayList로 변환 =====");
		List<String> list = Arrays.asList(arrStr);
		for (String str : list) {
		     System.out.println(str + " ");
		}
		// List 아닌 ArrayList로 받으려면
		Integer[] arrInt = {5, 26, 1, 74, 59, 38};
		ArrayList<Integer> arrlist = new ArrayList<Integer>(Arrays.asList(arrInt));
		for (int i : arrlist) {
		     System.out.print(i + " ");
		}
	}

}
