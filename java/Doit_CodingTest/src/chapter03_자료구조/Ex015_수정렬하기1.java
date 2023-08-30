package chapter03_자료구조;

import java.util.Arrays;
import java.util.Scanner;

public class Ex015_수정렬하기1 {
	public static void main(String[] args){
		// n<1000 으로 작은 상황이라 버블 정렬 사용해보기
		// 오름차순 정렬
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();

		int[] arr = new int[n];
		for (int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i=0; i<n-1; i++) {
			for (int j=0; j<n-1-i; j++) {
				if (arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]= temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
