package chapter03_자료구조;

import java.util.Arrays;
import java.util.Scanner;

public class Ex015_수정렬하기1_sol {
	public static void main(String[] args){
		// n을 대문자로 바꾼거 말고는 없음
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();

		int[] arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i=0; i<N-1; i++) {
			for (int j=0; j<N-1-i; j++) {
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
