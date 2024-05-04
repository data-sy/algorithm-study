package no02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex022_1966 {

	public static void main(String[] args) throws IOException{
		// https://www.acmicpc.net/problem/1966
		
		// 참고 자료 : https://sookr5416.tistory.com/250
		// 포인트 1 : 큐에 int[]를 담아서 인덱스를 살려줄 수 있어 ([인덱스, 중요도])
		// 포인트 2 : while을 true로 돌리고 필요한 순간에 break로 멈추도록 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine()); 
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			Queue<int[]> queue = new LinkedList<>();
			st = new StringTokenizer(br.readLine()); 
			
			for (int j=0; j<N; j++) {
				int priority = Integer.parseInt(st.nextToken());
				queue.add(new int[] {j, priority}); 		// 배열을 변수명에 담아주지 않고 바로 new로 생성해서 사용해도 됨! 
			}

			int cnt = 0;
			while (true) {
				int[] cur = queue.poll(); 	// cf) cur : current의 축약형. 현재값을 나타내는 변수명으로 사용됨 
				boolean hasNoMax = true;
				
				for (int[] item : queue) {
					// 만약 중요도가 더 큰 값이 존재한다면 
					if (cur[1] < item[1]) {
						hasNoMax = false;
						break;
					}
				}
				// hasNoMax가 true이다 = cur의 중요도보다 큰 값은 없다 = cur이 가장 중요도가 크다. ( = 위의 for문에서 break가 안 됐다. )
				if (hasNoMax) {
					cnt++;
					if (cur[0] == M) break;
				} else queue.offer(cur);

			}
			sb.append(cnt).append('\n');
		}
		System.out.println(sb);
	}
	
}
