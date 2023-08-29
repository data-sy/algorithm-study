package chapter03_자료구조;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Ex011_스택으로오름차순수열 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
//		int[] arr = new int[n+1];
//		for(int i=1; i<=n; i++) {
//			arr[i] = sc.nextInt();
//		}
		int[] arr = {0, 4, 3, 6, 8, 7, 5, 2, 1};
		
//		// 문제대로 배열이 나오는지 확인
//		int[] result = new int[n+1];
//		int r = 1;
		
		Stack<Integer> stack = new Stack<>();
		int j=1;
		for (int i=1 ; i<=n; i++) {
			stack.push(i);
			System.out.println("+");
			while(stack.peek()==arr[j]) {
//				result[r++] = stack.pop();
				stack.pop();
				System.out.println("-");
				j++;
				if (j == n+1) break;
			}

		}
//		System.out.println(Arrays.toString(result));
	}
}
