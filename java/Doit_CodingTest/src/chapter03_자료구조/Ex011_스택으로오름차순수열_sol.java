package chapter03_자료구조;

import java.util.Scanner;
import java.util.Stack;

public class Ex011_스택으로오름차순수열_sol {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] A = new int[N];
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		
		// 문제대로 배열이 나오는지 확인하는 방법으로 StringBuffer 사용
		StringBuffer sb = new StringBuffer();
		
		Stack<Integer> stack = new Stack<>();
		
		int num = 1;
		boolean result = true;
		for (int i=0 ; i<A.length; i++) {
			int su = A[i]; //현재 수열의 값
			if (su >= num) {
				while (su >= num) {
					stack.push(num++);
					sb.append("+\n");
				}
				stack.pop();
				sb.append("-\n");
			}
			else {
				int n = stack.pop();
				if (n > su) {
					System.out.println("NO");
					result = false;
					break;
				}
				else sb.append("-\n");
			}
		}
		if (result) System.out.println(sb.toString());
	}
}
