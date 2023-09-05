package chapter04_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Ex019_K번째수구하기 {
	public static void main(String[] args) throws IOException {
		// 방법 1 : 투포인터 없이 우선 해보자
		// 이렇게 하려고 했더니 small + pivot + large 더하는 부분이 자바에서는 까다로워.. (파이썬에서는 그냥 + 했눈디...ㅋㅋ)
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//
//		int N = Integer.parseInt(st.nextToken());
//		int K = Integer.parseInt(st.nextToken());
//		
//		st = new StringTokenizer(br.readLine());
//
//		List<Integer> arr = new ArrayList<>();
//		for (int i=0; i<N; i++) {
//			arr.add(Integer.parseInt(st.nextToken()));
//		}
//
//	}
//	public static List<Integer> quick(List<Integer> arr) {
//		int pivot = arr.get(0);
//		List<Integer> small = new ArrayList<>();
//		List<Integer> large = new ArrayList<>();		
//		for (int i=1; i<arr.size(); i++) {
//			int n = arr.get(i);
//			if (n<pivot) small.add(n);
//			else large.add(n);
//		}
//		return
		
		// 그래서 결국 투포인터 사용하는구나
		// 이 방법도 슬라이싱하면 새로운 배열을 만들어 내는 셈이라 ㅜㅠ 힝
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//
//		int N = Integer.parseInt(st.nextToken());
//		int K = Integer.parseInt(st.nextToken());
//		
//		st = new StringTokenizer(br.readLine());
//
//		int[] arr = new int[N];
//		for (int i=0; i<N; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
//		}
//		quick(arr, -1);
//		System.out.println(arr[K-1]);		
//	}
//	public static void quick(int[] arr, int pivot) {
//		int start = 0;
//		int end = -2;
//		while(start!=end) {
//			while (arr[start]<arr[pivot]) start++;
//			while (arr[end]>arr[pivot]); end--;
//			swap(arr, start, end);			
//		}
//		int[] small = Arrays.copyOfRange(arr, 0, start+1);
//		int[] large = Arrays.copyOfRange(arr, start+1, end);		
//			
//	}
//	public static void swap(int[] A, int i, int j) {
//		int temp = A[i];
//		A[i] = A[j];
//		A[j] = temp;		
		
	}
}
