package no02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex019_1875_2 {

	public static void main(String[] args) throws IOException{
		//https://www.acmicpc.net/problem/10769
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int[] arr = new int[N];
		for (int i=0;i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Stack<Integer> stack = new Stack<>();
		
		int num = 1;
		Boolean isPoss = true;
		for (int i=0; i<N; i++) {
			int target = arr[i];
			if (target>=num) {
				while(target>=num) {
					stack.push(num++);
					sb.append("+\n");
				}
				stack.pop();
				sb.append("-\n");
			} else { // target<num
				// 만약 팝 한게 타겟이랑 안 맞다면?! 불가능한 경우야.
				int tmp = stack.pop();
				if (target == tmp) {
					sb.append("-\n");
				} else {
					isPoss=false;
					break;
				}
			}
		}
		if(isPoss) System.out.println(sb);
		else System.out.println("NO");
	}

	// 맞긴 맞았는데.. 팝 할게 없을 수는 없나? 예외처리를 심도있게 보지 않았어
	
}
