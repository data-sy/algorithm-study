package no02_중간고사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex034_2504 {

	public static void main(String[] args) throws IOException {
		// https://www.acmicpc.net/problem/2504
		
		// 이번엔 반복문으로 풀었는데 다음엔 재귀 써보자!

		// ( )[ ]
		// 각 아스키코드 40 41 91 93
		// -100을 하면 -60 -59 -9 -7 => 이 숫자로 처리 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Integer> stack = new Stack<>();
		
		boolean isVPS = true;
		for(int i=0; i<str.length(); i++) {
			int ch = str.charAt(i);
			ch -= 100;
			if ( ch==-60 || ch==-9) stack.push(ch);
			else if (ch==-59) { // ) 가 들어왔을 때 
				if (stack.isEmpty()) {
					isVPS = false;
					break;
				} else {
					int p = stack.peek();
					if (p==-60) {
						stack.pop();
						stack.push(2);
					}
					else if (p==-9) {
						isVPS=false;
						break;
					}
					else {
						p = stack.pop();
						int sum = 0;
						while(p>0) {
							sum +=p;
							if(stack.isEmpty()) { // )랑 쌍이 되는 (가 없는 상
								isVPS=false;
								break;
							}
							p = stack.pop();
						}
						if(!isVPS) break;
						if(p==-9) { // [ 이면 
							isVPS=false;
							break;						
						} else { // ( 가 나온 경우야!
							sum*=2;
							stack.push(sum);
						}
					}
				}
			}
			else { // ch==-7. 즉, ] 일 때 
				if (stack.isEmpty()) {
					isVPS = false;
					break;
				} else {
					int p = stack.peek();
					if (p==-9) {
						stack.pop();
						stack.push(3);
					}
					else if (p==-60) {
						isVPS=false;
						break;
					}
					else {
						p = stack.pop();
						int sum = 0;
						while(p>0) {
							sum +=p;
							if(stack.isEmpty()) { // ]랑 쌍이 되는 [가 없는 상태 
								isVPS=false;
								break;
							}
							p = stack.pop();
						}
						if(!isVPS) break;
						if(p==-60) { // ( 이면 
							isVPS=false;
							break;						
						} else { // [ 가 나온 경우야!
							sum*=3;
							stack.push(sum);
						}
					}
				}
			}
			// idea 
			// 만약 ( [ 가 들어오면 스택에 쌓아
				// 그 뒤가 바로 ]) 이면 pop 하고 숫자 push
			// 그러다가 ] ) 가 들어오면 (숫자 필터링 한) 직전 문자열을 확인해서
				// push 해가면서 while 숫자일 동안 숫자는 더해
			// while 끝나고 
				// ] 가 들어오면 
					// 없으면 No 하고 브레이크
					// 있으면 [ 일 때 pop 하고 3곱하고 다시 push 
							// 그 외의 것이 나오면 No 하고 브레이크 
				// ) 가 들어오면
					// 같은 논리로 작동
				
				// 반복해서 숫자 쌓아뒀다가
				
				// 마지막에 모두 뽑아서 더하기
		}
		int result = 0;
		while(!stack.isEmpty()) {
			// 스택에 음수가 남아있으면 안 돼
			int tmp = stack.pop();
			if(tmp<0) {
				isVPS=false;
				break;
			} else result += tmp;
		}
		if (isVPS) System.out.println(result);
		else System.out.println("0");

	}

}
